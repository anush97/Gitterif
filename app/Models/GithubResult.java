package Models;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Model Class to handle Indivudual Github result Objects for Search Results 
 * @author Elvin Rejimone
 *
 */
public class GithubResult{
	public String repoName;
	public String queryString;
	public String repoID;
	public String ownerName;
	ArrayList<String> topics = new ArrayList<>() ;
	JsonNode topiclist;
	
	/**
	 * Constructor to Create GithubResult Object
	 * @param repo
	 * @param owner
	 * @param topic
	 * @param query
	 * @param id
	 * @author Elvin Rejimone
	 */
	public GithubResult(String repo, String owner,JsonNode topic,String query, String id){
		
		repoName = repo.substring(1, repo.length()-1);
		ownerName = owner.substring(1, owner.length()-1);
		System.out.println("Topic :: "+topic);
		topics = new ObjectMapper().convertValue(topic, ArrayList.class);
		queryString= query;
		repoID= id;
	}

	/**
	 * Function to return RepoName()
	 * @return repoName
	 * @author Elvin Rejimone
	 */
	public String getRepoName() {
		return repoName;
	}
	
	/**
	 * Function to Return ownerName
	 * @return ownerName
	 * @author Elvin Rejimone
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * Return an ArrayList of Topics
	 * @return topics
	 * @author Elvin Rejimone
	 */
	public ArrayList<String> returnTopics(){
		return topics;
	}
}