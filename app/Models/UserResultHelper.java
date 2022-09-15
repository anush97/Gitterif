package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author ujjawal
 * Helps to find the user repositories and other details 
 */
public class UserResultHelper{
	
	  
    public ArrayList<String> allSearches = new ArrayList<>();
    LinkedHashMap<String, ArrayList<GithubResult>> allResult = new LinkedHashMap<String, ArrayList<GithubResult>>();
    public HashMap<String, JsonNode> fullSearchData = new HashMap<String, JsonNode>();

    
    
    
	/**
	 * filters the data based on query
	 * @param query for searching the value in input box
	 * @param obj data from github
	 * @return returns the value
	 * @throws InterruptedException 
	 * @throws ExecutionException
	 */
	public LinkedHashMap<String, ArrayList<GithubResult>> getUserResult(String query, JsonNode obj) throws InterruptedException, ExecutionException {
		List<GithubResult> records = new ArrayList<GithubResult>();
		System.out.println("Size of Obj :: "+obj.size());
		
		for(JsonNode data:obj) {
			GithubResult result = new GithubResult(data.get("name").toString(),data.get("owner").findPath("avatar_url").toPrettyString(),data.get("topics"),query, data.get("description").toString());
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
	 * 
	 * @param query searches for the query
	 * @param singleRecord argument
	 */
	public void addToTotalSearchList(String query, ArrayList<GithubResult> singleRecord) {
		if(!allSearches.contains(query)) {
			if(allSearches.size()==10) {
				String removingQuery = allSearches.get(0);
				allResult.remove(removingQuery);
				allSearches.remove(0);
			}
			allSearches.add(query);
			allResult.put(query, singleRecord);
		}
	System.out.println(allSearches.toString());
	}

}