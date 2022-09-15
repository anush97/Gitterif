package actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

import play.Logger;
import play.libs.Json;
import Models.RepositoryProfile;
import Models.SearchResultHelper;
import services.RepoProfileService;
import Utils.Cache;
/**
 * @author Elvin Rejimone
 * Repository Actor containing all available details for a repository of a user
 */
public class RepoProfileActor extends AbstractActor{ 


/**
* get the user details and query string
* storing and retrieving data from Cache
*/
	static public class RepoProfileInfo{
		public final String queryString;
		public final String repoID;
		public final Cache cache;
		public final RepoProfileService repoService;
/**
* Constructor of this Info class.
*
*/
		public RepoProfileInfo(String queryString, String repoID, Cache cache,RepoProfileService repoServ) {
			this.queryString = queryString;
			this.repoID = repoID;
			this.cache = cache;
			this.repoService = repoServ;
		}
	}
	
	/**
	 * Factory method to create instance of Repository Actor
	 * @return Props
	 */
	public static Props getProps() {
		return Props.create(RepoProfileActor.class);
	}
	
	/**
	 * It receives referrences and decides action based on them.
	 * 
	 */
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(RepoProfileInfo.class, this::sendRepoProfileData )
				.build();
	}
	/**
	* fetch details from service class - issue and collaborators
	* @throws Exception
	*/
	private void sendRepoProfileData(RepoProfileInfo rpi) {
		try {
			
			RepositoryProfile newRepository = new RepositoryProfile(SearchResultHelper.fullSearchData.get(rpi.queryString),rpi.queryString, rpi.repoID);        	
		    System.out.println(rpi.repoService.githubIssueResultHelper(newRepository.issues_URL, newRepository, "Issues", rpi.cache));
		    System.out.println(rpi.repoService.githubIssueResultHelper(newRepository.contributors_URL, newRepository, "Collab", rpi.cache));
		    System.out.println("REPO-ACTOR ::: RepoName ::"+ newRepository.repoName);
		    sender().tell(newRepository, self());
		    
		}
		catch(InterruptedException e) {
			sender().tell(new RepoProfileInfo(rpi.queryString, rpi.repoID, rpi.cache, rpi.repoService), self());
		}
		catch(ExecutionException e) {
			sender().tell(new RepoProfileInfo(rpi.queryString, rpi.repoID, rpi.cache, rpi.repoService), self());
		}


	}
}
