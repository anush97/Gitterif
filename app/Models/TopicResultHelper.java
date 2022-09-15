package Models;
/**
 * This class contains methods to format the data fetched from response and limit the search reults to 10
 * to the application's home page.
 *
 * @author  Sejal Chopra
 * @version 1.0.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;


public class TopicResultHelper{
	/**
     * Defining the variables to be used
     */
	  
    
    public ArrayList<String> allSearches = new ArrayList<>();
    LinkedHashMap<String, ArrayList<GithubResult>> allResult = new LinkedHashMap<String, ArrayList<GithubResult>>();
    public HashMap<String, JsonNode> fullSearchData = new HashMap<String, JsonNode>();

    
    
    
	/**
	 * @param query
	 * @param obj
	 * @return allResults
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * This methods parses the required data from the API response and adds it to a list
	 */
	public LinkedHashMap<String, ArrayList<GithubResult>> getArrayofGithubResult(String query, JsonNode obj) throws InterruptedException, ExecutionException {
		List<GithubResult> records = new ArrayList<GithubResult>();
		System.out.println("Size of Obj :: "+obj.size());
		
		for(JsonNode data:obj) {
			GithubResult result = new GithubResult(data.get("name").toString(),data.get("owner").findPath("login").toPrettyString(),data.get("topics"),query, data.get("id").toString());
			fullSearchData.put(query, obj);
			records.add(result);			
		}
		
		records = records.stream()
				.limit(10)
				.collect(Collectors.toList());
		addToTotalSearchList(query, (ArrayList<GithubResult>) records);
		
		return allResult;
	}
	
	/**
	 * @param query
	 * @param singleRecord
	 * 
	 * Keeps only the latest topic results clicked by the user
	 */
	public void addToTotalSearchList(String query, ArrayList<GithubResult> singleRecord) {
		
			if(allSearches.size()==1) {
				String removingQuery = allSearches.get(0);
				allResult.remove(removingQuery);
				allSearches.remove(0);
			}
			allSearches.add(query);
			allResult.put(query, singleRecord);
		
	System.out.println(allSearches.toString());
	}

}