package actors;

//import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import Models.CommitsResult;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.Materializer;
import akka.testkit.javadsl.TestKit;
import play.libs.ws.WSClient;
import play.libs.ws.ahc.AhcWSClient;
import play.shaded.ahc.org.asynchttpclient.AsyncHttpClient;
import play.shaded.ahc.org.asynchttpclient.AsyncHttpClientConfig;
import play.shaded.ahc.org.asynchttpclient.DefaultAsyncHttpClient;
import play.shaded.ahc.org.asynchttpclient.DefaultAsyncHttpClientConfig;
import actors.CommitsActor;
import services.CommitService;
import org.junit.Test;

//import org.junit.jupiter.api.Test;

import Models.SearchResultHelper;
import Utils.Cache;
import actors.SearchResultActor.SearchResultInfo;
import actors.SearchSupervisor.GithubSearchMessage;
import actors.TopicActor.*;

class TopicActorTest {

	
		@Test
		public void commitsTest() {
			final ActorSystem topicSystem = ActorSystem.create();
			try {
				Materializer materializer = Materializer.matFromSystem(topicSystem);
				AsyncHttpClientConfig asyncHttpClientConfig = new DefaultAsyncHttpClientConfig.Builder()
						.setMaxRequestRetry(0).setShutdownQuietPeriod(0).setShutdownTimeout(0).build();
				AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient(asyncHttpClientConfig);
				WSClient client = new AhcWSClient(asyncHttpClient, materializer);
				//CommitService cs = new CommitService(client);
				new TestKit(topicSystem) {
					{
						System.out.println(topicSystem);
						final Props props = TopicActor.getProps(null);
						final ActorRef topicRef = topicSystem.actorOf(props);
						topicRef.tell(new TopicActor.RegisterMsg(), getRef());
						topicRef.tell("data", getRef());
						topicRef.tell(new TopicActor.TopicInfo("apache"), topicRef);
					}
				};
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				TestKit.shutdownActorSystem(topicSystem);
			}
		}



}
