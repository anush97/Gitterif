package Models;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Class to handle all Data and Helper Functions to Get and Process data for Repository Profile Page
 * @author Elvin Rejimone
 *
 */
public class RepositoryProfile {
		
	public String queryString;
	public String repoID;
	public String repoName;
	public String ownerName;
	public String description;
	public String size;
	public String language;
	public String created;
	public String stars;
	public String watch;
	public String forks;
	public String issues_URL;
	public String contributors_URL;
	public String issuesCount;
	public String repoLink;
	
	public ArrayList<String> issueTitleList = new ArrayList<>(); // @Anushka This ArrayList is for your Issue Statistics Page
	
	public ArrayList<RepoIssue> issueList = new ArrayList<>();
	public ArrayList<RepoCollaborator> collabList = new ArrayList<>();
	ArrayList<String> topics = new ArrayList<>() ;
	JsonNode issuesObj;
	JsonNode contributorsObj;
	int count=0;

	
	/**
	 * Constructor to create RepositoryProfile Object which will contain all Details of a Repository
	 * @param obj
	 * @param query
	 * @param id
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @author Elvin Rejimone
	 */
	public RepositoryProfile(JsonNode obj, String query, String id) throws InterruptedException, ExecutionException {
		queryString =query;
		repoID = id;
		
		for(JsonNode data:obj) {
			if(data.get("id").toString().equals(repoID)) {
				repoName= data.get("name").toString().substring(1, data.get("name").toString().length()-1);
				ownerName= data.get("owner").findPath("login").toPrettyString().substring(1,data.get("owner").findPath("login").toPrettyString().length()-1);
				description = data.get("description").toString().replaceAll("^\"|\"$", "");;
				size = data.get("size").toString();
				stars = data.get("stargazers_count").toString();
				watch = data.get("watchers").toString();
				language = data.get("language").toString().replaceAll("^\"|\"$", "");;
				issuesCount = data.get("open_issues").toString();
				issues_URL = "https://api.github.com/repos/"+ ownerName + "/"+ repoName + "/issues";
				contributors_URL = "https://api.github.com/repos/"+ ownerName + "/"+ repoName + "/contributors";
				created = data.get("created_at").toString().replaceAll("^\"|\"$", "");
				topics = new ObjectMapper().convertValue(data.get("topics"), ArrayList.class);
				forks = data.get("forks").toString().replaceAll("^\"|\"$", "");
				repoLink = data.get("html_url").toString().replaceAll("^\"|\"$", "");
				System.out.println(topics.toString());			
				break;
			}
			
		}
	
	}
	
	
	
	/**
	 * Function to get JsonNode result and extract Issues and Collaborators and call their respective constructors to create Objects
	 * @param obj
	 * @param option
	 * @return boolean To indicate success of results 
	 * @author Elvin Rejimone
	 */
	public boolean getDataFromResult(JsonNode obj, String option) {
		int count=0;
		
		if(option.equals("Issues")) {
			for(JsonNode data:obj) {
				if(count==20) {
					break;
				}else {
					RepoIssue issue = new RepoIssue(data.get("title").toString(), data.get("body").toString(), data.get("created_at").toString(), data.get("state").toString(), data.get("number").toString());
					issueList.add(issue);
					issueTitleList.add(data.get("title").toString().substring(1, data.get("title").toString().length()-1));
					count++;
				}				
			}
			return true;
			
		}else if(option.equals("Collab")) {
			
			for(JsonNode data:obj) {
				RepoCollaborator contributor = new RepoCollaborator(data.get("login").toString(), data.get("id").toString(), data.get("contributions").toString(), data.get("avatar_url").toString());
				collabList.add(contributor);
			}
			return true;
		}
		return false;
	}
	
	 
	/**
	 * Function to return Topics
	 * @return List of Topics
	 * @author Elvin Rejimone
	 */
	public ArrayList<String> getTopicsList(){
		 return topics;
	 };
}
