package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import Utils.Cache;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;

/**
 * Class with functions and parameters to facilitate Searched Data Processing and Creation of GithubResult
 * @author Elvin Rejimone
 *
 */
public class SearchResultHelper{
	
	  
    public ArrayList<String> allSearches = new ArrayList<>();
    LinkedHashMap<String, ArrayList<GithubResult>> allResult = new LinkedHashMap<String, ArrayList<GithubResult>>();
    public static HashMap<String, JsonNode> fullSearchData = new HashMap<String, JsonNode>();

	private WSClient ws;
	
	@Inject
	public SearchResultHelper(WSClient ws) {
		this.ws = ws;
	}
     
	/**
	 * Function that takes Response Object of type JsonNode and creates the List of GithubResult Objects and appends it to allResult and FullSearchData .
	 * It returns allResult of Type LinkedHashMap<String, ArrayList<GithubResult>>
	 * @param query
	 * @param obj
	 * @return LinkedHashMap<String, ArrayList<GithubResult>> allResult
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @author Elvin Rejimone
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
		System.out.println(allResult);
		return allResult;
	}
	
	/**
	 * Function to add a GithubResult object to search result variable allResult and limit it to 10 results in total
	 * Also checks for duplicated result and overwrites it in the correct position
	 * @param query
	 * @param singleRecord
	 *  @author Elvin Rejimone
	 */
	public void addToTotalSearchList(String query, ArrayList<GithubResult> singleRecord) {
		
		if(allSearches.contains(query)) {
			allResult.remove(query);
			allSearches.remove(allSearches.indexOf(query));
		}
		
		if(allSearches.size()==10) {
			String removingQuery = allSearches.get(0);
			allResult.remove(removingQuery);
			allSearches.remove(0);
		}
		allSearches.add(query);
		allResult.put(query, singleRecord);
		
	System.out.println(allSearches.toString());
	}
	
	
	
	/**
	 * Search- hit the api and search the for the word
	 * 
	 * @author Elvin Rejimone
	 * @param query - search string
	 * @param type  To identify the API call
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public LinkedHashMap<String, ArrayList<GithubResult>> searchGithub(String query, Cache cache, Boolean USE_CACHE)
			throws InterruptedException, ExecutionException {
		WSRequest req = null;
		LinkedHashMap<String, ArrayList<GithubResult>> finalList = null;
			String querytoCheckCache = "https://api.github.com/search/repositories?q=" + query;
			JsonNode obj = cache.get(querytoCheckCache);
			if (obj != null && USE_CACHE) {
				System.out.println("Taking from Cache");
			} else {
				System.out.println("Not Found in Cache, requesting and Storing in Cache");
				System.out.println("Query : https://api.github.com/search/repositories?q=" + query);
				System.out.println();
				req = ws.url("https://api.github.com/search/repositories?q=" + query + "&sort=updated")
						.addHeader("Authorization",
								"token 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");
				CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
				obj = Json.toJson(res.toCompletableFuture().get().findPath("items"));
				cache.put(querytoCheckCache, obj);
			}

			finalList = getArrayofGithubResult(query, obj);
		return finalList;
	
	}
}