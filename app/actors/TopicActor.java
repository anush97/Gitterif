package actors;


import play.shaded.ahc.org.asynchttpclient.*;
import play.libs.ws.ahc.*;
import akka.stream.Materializer;
import play.libs.ws.WSRequest;
import java.time.LocalDateTime;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import play.libs.ws.WSClient;
import scala.concurrent.duration.Duration;
import services.RepoProfileService;
import play.libs.Json;
import akka.actor.AbstractActorWithTimers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.GithubResult;
import Models.TopicResultHelper;
import Utils.Cache;
import akka.actor.ActorRef;
import javax.inject.Inject;
import akka.actor.Props;
//import controllers.JsonNode;
//import controllers.WSRequest;
import play.Logger;
import play.libs.Json;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;



public class TopicActor extends AbstractActorWithTimers{
	@com.google.inject.Inject WSClient wsTopic; 
	private Set<ActorRef> userActors;
	public String topicName;
	TopicResultHelper topicHelper = new TopicResultHelper();
	
	private static final class Tick{
	}

	static public class RegisterMsg{

	}

	static public Props getProps() {
		return Props.create(TopicActor.class);

	}

	static public class TopicInfo{
		public final String topicName;
		public TopicInfo(String topicName) {
			this.topicName = topicName;
		}
	}
	

	private TopicActor() {
		this.userActors = new HashSet<>();

	}

	

	@Override

	public void preStart() {
	}
	@Override

	public Receive createReceive() {

		return receiveBuilder()
				.match(TopicInfo.class, this::getTopicData)
				.match(RegisterMsg.class, msg -> userActors.add(sender()))
				.build();

	}

	private void getTopicData(TopicInfo tpi) throws Exception,InterruptedException, ExecutionException {
		System.out.println("**********Here in getTopicData!!");
		AsyncHttpClientConfig asyncHttpClientConfig =
				new DefaultAsyncHttpClientConfig.Builder()
				.setMaxRequestRetry(0)
				.setShutdownQuietPeriod(0)
				.setShutdownTimeout(0)
				.build();
		AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient(asyncHttpClientConfig);
		WSClient client = new AhcWSClient(asyncHttpClient, Materializer.matFromSystem(context().system()));
		WSRequest req = client.url(String.format("https://api.github.com/search/repositories?q=topic:%s&per_page=10&sort=updated",tpi.topicName));
		//JsonNode j = req.get().thenApply(r-> r.getBody(json())).toCompletableFuture().get();
		CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
		JsonNode obj = Json.toJson(res.toCompletableFuture().get().findPath("items"));
		LinkedHashMap<String, ArrayList<GithubResult>> finalList = topicHelper.getArrayofGithubResult(tpi.topicName, obj);
		
		  sender().tell(finalList, self());
	}



}
