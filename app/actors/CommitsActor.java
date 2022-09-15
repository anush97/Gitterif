package actors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.*;

import javax.inject.Inject;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import Models.CommitsResult;
import play.libs.ws.WSClient;
import services.CommitService;
/**
 * @author Santhosh Santhanam
 * Commits Akka Actor to fetch user details from web socket and passing the instance to Service 
 * together with appropriate message classes
 */
public class CommitsActor extends AbstractActor {
/**
* get the user details creating instance of Service class
*
*/
	static public class CommitInfo {
		public final String username;
		public final String reponame;
		CommitService cService;

		public CommitInfo(String username, String reponame, CommitService cService) {
			this.username = username;
			this.reponame = reponame;
			this.cService = cService;
		}
	}
/**
* Constructor of this Info class.
*
*/
	private final CommitService commitService;

	@Inject
	public CommitsActor(CommitService commitService) {
		this.commitService = commitService;
	}
	/**
	 * Factory method to create instance of Commits Actor
	 * @return Props
	 */
	public static Props getProps(CommitService cs) {
		return Props.create(CommitsActor.class, () -> new CommitsActor(cs));
	}
	/**
	 * It receives referrences and decides action based on them.
	 * 
	 */
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder().match(CommitInfo.class, this::sendCommitsData).build();
	}
	/**
	*Commits function to calculate the statistics for a repositories commits
	* @throws Exception
	*/
	private void sendCommitsData(CommitInfo cInfo) {
		try {
			CompletionStage<List<CommitsResult>> cData = cInfo.cService.getCommitsData(cInfo.username, cInfo.reponame);
			System.out.println("Output from Commits ACTOR!!");
			sender().tell(cData.toCompletableFuture().get(), self());
		} catch (InterruptedException e) {
			sender().tell(new CommitsResult(), self());
		} catch (ExecutionException e) {
			sender().tell(new CommitsResult(), self());
		}
	}

}
