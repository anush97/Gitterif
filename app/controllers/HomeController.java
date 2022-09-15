package controllers;

import static akka.pattern.Patterns.ask;
import scala.concurrent.Await;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import akka.actor.ActorNotFound;
import akka.actor.ActorRef;
import akka.actor.Nobody;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import play.mvc.WebSocket;
import java.util.HashMap;//
import javax.inject.Inject;
import actors.UserActor;
import actors.TopicActor;
import scala.concurrent.duration.Duration;
import com.fasterxml.jackson.databind.JsonNode;
import scala.concurrent.Await;

import Models.CommitsResult;
import Models.GithubResult;
import Models.RepositoryProfile;
import Models.SearchResultHelper;
import Models.StatisticsInfo;
import Models.StatsModel;
import Models.TopicResultHelper;
import Models.UserResultHelper;
import Utils.Cache;
import actors.CommitsActor;
import actors.CommitsActor.CommitInfo;
import actors.RepoProfileActor;
import actors.RepoProfileActor.RepoProfileInfo;
import actors.SearchResultActor;
import actors.SearchResultActor.SearchResultInfo;
import actors.SearchSupervisor;
import actors.StatisticsActor;//actor
import actors.StatisticsActor.StatsInfo;//
import actors.TopicActor;
import actors.TopicActor.TopicInfo;
import actors.SupervisorActor;

//import actors.TimeActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.libs.streams.ActorFlow;
import scala.compat.java8.FutureConverters;
import services.CommitService;
import services.RepoProfileService;
import services.StatsService;// service


/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 *
 * @author Elvin Rejimone, Santhosh Santhanam, Anushka Sharma, Ujjawal Aggarwal,
 *         Sejal Chopra
 * @version 1.0.0
 */

/**
 * @author ujjawal
 *
 */
/**
 * @author ujjawal
 *
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {
	/**
	 * Defining the public parameters
	 */
	private final AssetsFinder assetsFinder;
	private Cache cache;

	@Inject
	WSClient ws = null;
	Map.Entry<String, Integer> e;
	JsonNode fullCommitsResult;
	List<JsonNode> response = new ArrayList<>();
	LinkedHashMap<String, ArrayList<GithubResult>> allResultList = new LinkedHashMap<String, ArrayList<GithubResult>>();
	List<String> keysList = new ArrayList<>();
	CommitsResult cr;
	public ArrayList<String> issueTitleList_controller = new ArrayList<>();
	public ArrayList<String> issue_controller;
	LinkedHashMap<String, ArrayList<GithubResult>> topicResultList = new LinkedHashMap<String, ArrayList<GithubResult>>();
	List<String> topicList = new ArrayList<>();
	TopicResultHelper topicHelper = new TopicResultHelper();
	List<String> userList = new ArrayList<>();
	UserResultHelper userHelper = new UserResultHelper();
	ArrayList<String> al2;
	public Map<String, Integer> result = new LinkedHashMap<>();
	HashMap<String,Object> data  ;//

	//Services 
	
	@Inject 
	SearchResultHelper srHelper = new SearchResultHelper(ws);
	@Inject
	RepoProfileService repoService = new RepoProfileService(ws);
	@Inject
	CommitService commitService = new CommitService(ws);
	@Inject//
	StatsService statsService= new StatsService();

	@Inject
	private ActorSystem actorSystem;
	@Inject
	private Materializer materializer;

	ActorRef repoProfileActor;
	ActorRef commitsActor;
	ActorRef searchActor;
	ActorRef statsActor;//
	ActorRef topicActor;//
	
	//SUPERVISOR ACTOR
		ActorRef supervisor;

	
	boolean IS_SUPERVISOR_CREATED = false;

	public HomeController() {
		this.assetsFinder = null;
	}

	@Inject
	public HomeController(AssetsFinder assetsFinder, Cache cache, ActorSystem system)  throws InterruptedException,ExecutionException {
		this.assetsFinder = assetsFinder;
		this.cache = cache;

		if(!IS_SUPERVISOR_CREATED) {
			
			supervisor = system.actorOf(SupervisorActor.getProps(), "supervisor");
			IS_SUPERVISOR_CREATED =true;
		}	
			CompletionStage<ActorRef> searchActorImpl = FutureConverters
			.toJava((ask(supervisor, SearchResultActor.getProps(), 5000)))
			.thenApply(response -> {
				return (ActorRef) response;
			});
		
			searchActor = searchActorImpl.toCompletableFuture().get();
			
		repoProfileActor = system.actorOf(RepoProfileActor.getProps());
		commitsActor = system.actorOf(CommitsActor.getProps(commitService));
//		searchActor = system.actorOf(SearchResultActor.getProps(), "searchActor");
		statsActor = system.actorOf(StatisticsActor.getProps());//
		topicActor = system.actorOf(TopicActor.getProps(),"topicActor");	
		

	}
	
	 /**
	 * @Websocket pushes info from server to client
	 */
	public WebSocket ws(){
		 System.out.println("Inside Websocket!! ");
	        return WebSocket.Json.accept(request -> ActorFlow.actorRef(SearchSupervisor::props, actorSystem, materializer));
	    }
	 
	  public WebSocket wsTopic(){
		  
	        return WebSocket.Json.accept(request->ActorFlow.actorRef(UserActor::props,actorSystem,materializer));
	    }

	/**
	 * enter new search terms which will result in 10 more results being displayed
	 * 
	 * @author Santhosh Santhanam
	 * @author Elvin Rejimone
	 * @author Anushka Sharma
	 * @author Ujjawal Agarwal
	 * @author Sejal Chopra
	 * @param request Http request parameter
	 * @return search.scala.html
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public CompletionStage<Result> index(Http.Request request) throws InterruptedException, ExecutionException {
		System.out.println(request.queryString("search"));

//		if (!request.queryString("search").isPresent()) {
//			return CompletableFuture.supplyAsync(ok(views.html.index.render(allResultList, keysList)));
//		} else {
			
			String QueryString = "none";; 
			if(request.queryString("search").isPresent()) {
				QueryString = request.queryString("search").get();
			}
			
			return FutureConverters
					.toJava(ask(searchActor, new SearchResultInfo(QueryString, cache, srHelper), 10000))
					.thenApply(response -> {
						allResultList = (LinkedHashMap<String, ArrayList<GithubResult>>)response;

						if(allResultList.size() == 0) {
						   return ok(views.html.index.render(allResultList, keysList, request));
						}else {
						keysList.clear();
						keysList.addAll((allResultList.keySet()));
						Collections.reverse(keysList);
						return ok(views.html.index.render(allResultList, keysList, request));
						}
					});
			
//			allResultList = srHelper.searchGithub(request.queryString("search").get(), cache);
//			keysList.clear();
//			keysList.addAll((allResultList.keySet()));
//			Collections.reverse(keysList);
//			return ok(views.html.index.render(allResultList, keysList));
//		}

	}

	/**
	 * Search- hit the api and search the for the word
	 * 
	 * @author Santhosh Santhanam
	 * @author Elvin Rejimone
	 * @author Sejal Chopra
	 * @param query - search string
	 * @param type  To identify the API call
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public LinkedHashMap<String, ArrayList<GithubResult>> searchGithub(String query, int type)
			throws InterruptedException, ExecutionException {
		WSRequest req = null;
		LinkedHashMap<String, ArrayList<GithubResult>> finalList = null;
		if (type == 1) {
			String querytoCheckCache = "https://api.github.com/search/repositories?q=" + query;
			JsonNode obj = cache.get(querytoCheckCache);
			if (obj != null) {
				System.out.println("Taking from Cache");
			} else {
				System.out.println("Not Found in Cache, requesting and Storing in Cache");
				System.out.println("Query : https://api.github.com/search/repositories?q=" + query);
				System.out.println();
				req = ws.url("https://api.github.com/search/repositories?q=" + query);
				CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
				obj = Json.toJson(res.toCompletableFuture().get().findPath("items"));
				cache.put(querytoCheckCache, obj);
			}

			finalList = srHelper.getArrayofGithubResult(query, obj);
		} else if (type == 2) {
			req = ws.url(String.format("https://api.github.com/search/repositories?q=topic:%s&per_page=10&sort=updated",
					query));
			CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
			JsonNode obj = Json.toJson(res.toCompletableFuture().get().findPath("items"));
			finalList = topicHelper.getArrayofGithubResult(query, obj);
		} else if (type == 3) {
			req = ws.url(String.format("https://api.github.com/users/%s/repos", query));
			CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
			JsonNode obj = res.toCompletableFuture().get();
			finalList = userHelper.getUserResult(query, obj);
		}
		return finalList;
	}

	/**
	 * display the 10 latest repositories containing this topic, in the same format
	 * as the results on the main search page.
	 * 
	 * @author Sejal Chopra
	 * @param request Http request parameter
	 * @return views.html.topic
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public CompletionStage<Result> topics(String requests,Http.Request request) throws InterruptedException, ExecutionException,TimeoutException {
			
		return FutureConverters
				.toJava(ask(topicActor, new TopicInfo(requests), 10000))
				.thenApply(response -> {
					topicResultList = (LinkedHashMap<String, ArrayList<GithubResult>>) response;
					topicList.clear();
					topicList.addAll(topicResultList.keySet());
					Collections.reverse(topicList);
					
					return ok(views.html.topic.render(topicResultList, topicList, request));
				});	    
	}

	/**
	 * Display all available public profile information about a user and the other
	 * repositories of that user
	 * 
	 * @author Ujjawal
	 * @param request
	 * @return Users details
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	
	// public CompletionStage<Result> users(String requests,Http.Request request) throws InterruptedException, ExecutionException,TimeoutException {
		
	// 	if(!IS_TOPIC_ACTOR_STARTED) {
	// 		topicActor = actorSystem.actorOf(UsersActor.getProps(requests),"userActor");
	// 		IS_TOPIC_ACTOR_STARTED = true;
	// 	}
		
	// 	return FutureConverters
	// 			.toJava(ask(topicActor, new TopicInfo(requests), 10000))
	// 			.thenApply(response -> {
	// 				topicResultList = (LinkedHashMap<String, ArrayList<GithubResult>>) response;
	// 				topicList.clear();
	// 				topicList.addAll(topicResultList.keySet());
	// 				Collections.reverse(topicList);
					
	// 				return ok(views.html.users.render(topicResultList, topicList, request));
	// 			});	    
	// }

	public Result users(String request) throws InterruptedException, ExecutionException {

		topicResultList = searchGithub(request, 3);
		topicList.clear();
		topicList.addAll(topicResultList.keySet());
		Collections.reverse(topicList);
		return ok(views.html.user.render(topicResultList, topicList));
		
	}

	/**
	 * Repository Profile: all available details for a repository Display 20 latest
	 * issues of that repository with their information
	 * 
	 * @author Elvin Rejimone
	 * @param queryString
	 * @param IDString
	 * @return Return result object
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public CompletionStage<Result> repoProfileRequestHandler(String queryString, String IDString)
			throws InterruptedException, ExecutionException {
		return FutureConverters
				.toJava(ask(repoProfileActor, new RepoProfileInfo(queryString, IDString, cache, repoService), 10000))
				.thenApply(response -> {
					RepositoryProfile repoProfile = (RepositoryProfile) response;
					issueTitleList_controller = repoProfile.issueTitleList;
					return ok(views.html.repodetails.render(repoProfile));
				});
	}

	/**
	 * Initialised issue page with words statistics and further stats
	 * 
	 * @author Anushka Sharma
	 * @param request
	 * @return word statistics of issues titles
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	// Issues
	public CompletionStage<Result> issues() throws InterruptedException, ExecutionException {//
		issue_controller = new ArrayList<>();
		 if (issueTitleList_controller.isEmpty()){
			return CompletableFuture.supplyAsync(() -> {
		 		return ok(views.html.no_issues.render());
		});}
		 else{
return FutureConverters
		.toJava(ask(statsActor, new StatsInfo(issueTitleList_controller), 10000))
		.thenApply(response -> {
			//StatsModel stats = (StatsModel) response;
			 data = (HashMap<String,Object>) response;
			StatsModel s= (StatsModel)data.get("list");
			ArrayList<Integer>Isseus_details = (ArrayList<Integer>)data.get("count");

			// for (Map.Entry<String, Integer> entry1 : s.wordfrequency.entrySet()) {
			//  	System.out.println(entry1.getKey() + " => " + entry1.getValue());
			// }

			Iterator iterator = s.wordfrequency.keySet().iterator();
			while (iterator.hasNext()) {
				Object key = iterator.next();
				issue_controller.add((String) key);
			}
			//StatisticsInfo obj = new StatisticsInfo();
			//ArrayList<Integer> Isseus_details = obj.Calculate_Stats();
			return ok(views.html.issuesstats.render(Isseus_details, issue_controller, s.wordfrequency));
			

		});}
}
	/**
	 * Commits function to calculate the statistics for a repositories commits
	 * 
	 * @author Santhosh Santhanam
	 * @param user Owner name of the repository owner
	 * @param repo Repository name
	 * @return Completion stage of result containing commits statistics
	 * @throws Exception
	 */
	public CompletionStage<Result> commits(String user, String repo) throws Exception {
		List<String> commitKeysList = new ArrayList<>();
		/*
		 * CompletableFuture<List<CommitsResult>> topCommiters =
		 * commitService.getCommitsData(user, repo); List<CommitsResult> topTen =
		 * topCommiters.toCompletableFuture().get().parallelStream() .map(c -> new
		 * CommitsResult(c.get_user_name(), c.get_additions(), c.get_deletions()))
		 * .collect(Collectors.toList()); result =
		 * topTen.parallelStream().collect(Collectors.toMap(w -> w.get_user_name(), w ->
		 * 1, Integer::sum)); result =
		 * result.entrySet().stream().sorted((Map.Entry.<String,
		 * Integer>comparingByValue().reversed())).limit(10)
		 * .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->
		 * e1, LinkedHashMap::new)); Iterator<String> iterator =
		 * result.keySet().iterator(); while (iterator.hasNext()) { Object commitKey =
		 * iterator.next(); commitKeysList.add((String) commitKey); } int size =
		 * topCommiters.toCompletableFuture().get().size();
		 * System.out.println("LAST VALUE: " +
		 * topCommiters.toCompletableFuture().get().get(size - 1)); return
		 * ok(views.html.commits.render(topCommiters.toCompletableFuture().get().get(
		 * size - 1), commitKeysList, result));
		 */
		return FutureConverters.toJava(ask(commitsActor, new CommitInfo(user, repo, commitService), 1000000))
				.thenApplyAsync(response -> {
					List<CommitsResult> topCommiters = (List<CommitsResult>) response;
					List<CommitsResult> topTen = topCommiters.parallelStream()
							.map(c -> new CommitsResult(c.get_user_name(), c.get_additions(), c.get_deletions()))
							.collect(Collectors.toList());
					result = topTen.parallelStream()
							.collect(Collectors.toMap(w -> w.get_user_name(), w -> 1, Integer::sum));
					result = result.entrySet().stream()
							.sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).limit(10)
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
									LinkedHashMap::new));
					Iterator<String> iterator = result.keySet().iterator();
					while (iterator.hasNext()) {
						Object commitKey = iterator.next();
						commitKeysList.add((String) commitKey);
					}
					int size = topCommiters.size();
					return ok(views.html.commits.render(topCommiters.get(size - 1), commitKeysList, result));
				});
	}

}
