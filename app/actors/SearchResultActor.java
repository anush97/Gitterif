package actors;

import akka.actor.AbstractActor;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ExecutionException;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

import play.Logger;
import play.libs.Json;
import Models.GithubResult;
import Models.RepositoryProfile;
import Models.SearchResultHelper;
import services.RepoProfileService;
import Utils.Cache;
import actors.RepoProfileActor.RepoProfileInfo;
import java.util.concurrent.TimeUnit;
import scala.concurrent.duration.Duration;

public class SearchResultActor extends AbstractActorWithTimers{ 
		  private Set<ActorRef> replyActors;
		  private SearchResultInfo srf;
		  static boolean IS_TIMER_RUNNING= false;
		  LinkedHashMap<String, ArrayList<GithubResult>> currentResultList;
		  HashMap<String, ArrayList<String>> currentRepoList = new HashMap<String, ArrayList<String>>(); ;
		  
		  
	static public class SearchResultInfo{
		public final String queryString;
		public final Cache cache;
		public final SearchResultHelper srHelper;
		public SearchResultInfo(String queryString, Cache cache, SearchResultHelper srHelper) {
			this.queryString = queryString;
			this.cache = cache;	
			this.srHelper = srHelper;
		}
	}
	
	private SearchResultActor() {
		System.out.println("SearchActor CREATED by Supervisor Actor!!");
		this.replyActors = new HashSet<>();
	}
	

    public static final class Tick{
    	SearchResultInfo savedSRF;
    	public Tick(SearchResultInfo savedSRF) {
    		this.savedSRF = savedSRF;
    	}
    }
	
    
	 static public class RegisterMsg{

	    }

	 public void preStart(){
	    }
	
	public static Props getProps() {
		return Props.create(SearchResultActor.class);
	}
	
	
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(SearchResultInfo.class, this::sendSearchResults )
				.match(RegisterMsg.class, msg -> replyActors.add(sender()))
				.match(Tick.class, msg -> UpdateSearchResults(msg.savedSRF))
				.build();
	}
	
	private void sendSearchResults(SearchResultInfo sri) {
		try {
			LinkedHashMap<String, ArrayList<GithubResult>> allResultList = new LinkedHashMap<String, ArrayList<GithubResult>>();
			System.out.println("Inside SearchActor:: Key ="+ sri.queryString);
			if(sri.queryString.equals("none")) {
				 sender().tell(allResultList, self());
			}else {
				allResultList = sri.srHelper.searchGithub(sri.queryString, sri.cache, true);					
			    System.out.println("SearchResult-ACTOR ::: KeySet ::"+ allResultList.keySet());
			    currentResultList = allResultList;
			    updateRepoIDs();
			    if(!IS_TIMER_RUNNING) {
			        getTimers().startPeriodicTimer("Timer", new Tick(sri), Duration.create(15, TimeUnit.SECONDS));
			        IS_TIMER_RUNNING=true;
			    }
			    sender().tell(allResultList, self());
			}
			
		    
		}
		catch(InterruptedException e) {
			sender().tell(new SearchResultInfo(sri.queryString, sri.cache, sri.srHelper), self());
		}
		catch(ExecutionException e) {
			sender().tell(new SearchResultInfo(sri.queryString, sri.cache, sri.srHelper), self());
		}


	}
	
	@SuppressWarnings("deprecation")
	private void UpdateSearchResults(SearchResultInfo sri) {
		try {
			Boolean Has_Changed = false;
			String OutputMSG;
			Integer changeCount=0;
			LinkedHashMap<String, ArrayList<GithubResult>> allResultList = new LinkedHashMap<String, ArrayList<GithubResult>>();
			System.out.println("Inside SearchActorUPDATE-ACTOR:: Key ="+ sri.queryString);
			
			allResultList = sri.srHelper.searchGithub(sri.queryString, sri.cache, false);					
		    System.out.println("SearchResultUPDATE-ACTOR ::: KeySet ::"+ allResultList.keySet());
		    System.out.println("SearchResultUPDATE-ACTOR ::: replyActors ::"+ replyActors.size());
		    
		    final ObjectNode response = Json.newObject();
		    
		    ArrayList<ObjectNode> arrayOfChanges = new ArrayList<>();
	
	    	for(String key : allResultList.keySet()) {
	    		for(int i =0; i< allResultList.get(key).size();i++) {
	    			if(!currentRepoList.get(key).contains(allResultList.get(key).get(i).repoID)){
	    				Has_Changed = true;
	    				 changeCount++;
	    				 ObjectNode ChangeObject = Json.newObject(); 
	    				 ChangeObject.put("queryString", allResultList.get(key).get(i).queryString);
	    				 ChangeObject.put("repoID", allResultList.get(key).get(i).repoID);
	    				 ChangeObject.put("ownerName", allResultList.get(key).get(i).ownerName);
	    				 ChangeObject.put("repoName", allResultList.get(key).get(i).repoName);
	    				 ChangeObject.put("topics", allResultList.get(key).get(i).returnTopics().toString());
	    				 ChangeObject.put("repoToChange",currentRepoList.get(key).get(changeCount));		    				 
	    				 arrayOfChanges.add(ChangeObject);		    				 
	    		}
	    	}
	    	
	    	}
		    
		    if(Has_Changed) {
		    	System.out.println(changeCount + " - Changes");
		    	response.put("status", changeCount.toString());
				 response.put("value", arrayOfChanges.toString());
				 currentResultList = allResultList;
				 updateRepoIDs();
		    }else {
		    	System.out.println("No Change in List");
		    	OutputMSG = "No-Change";
		    	response.put("status", "No-Change");
		    }
		    
		    SearchSupervisor.GithubSearchMessage tMsg = new SearchSupervisor.GithubSearchMessage(response);
		    replyActors.forEach(ar -> ar.tell(tMsg, self()));
				    
		}
		catch(InterruptedException e) {
			sender().tell(new SearchResultInfo(sri.queryString, sri.cache, sri.srHelper), self());
		}
		catch(ExecutionException e) {
			sender().tell(new SearchResultInfo(sri.queryString, sri.cache, sri.srHelper), self());
		}


	}
	
	
	private void updateRepoIDs() {
		for(String key : currentResultList.keySet()) {
			ArrayList<String> repoIDListforString = new ArrayList<>();
    		for(int i =0; i< currentResultList.get(key).size();i++) {   				   
    			repoIDListforString.add(currentResultList.get(key).get(i).repoID);
    		}
    		currentRepoList.put(key, repoIDListforString);
    	}
    	
    	}
	}
	
