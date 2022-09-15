package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import Models.CommitsResult;
import Models.RepositoryProfile;
import Utils.Cache;

/**
* @author Elvin Rejimone
* Service Class of Repository Display
* Data is read from web socket and all details are fetched
*/
public class RepoProfileService implements WSBodyReadables, WSBodyWritables{

	private WSClient ws;
	
	@Inject
	public RepoProfileService(WSClient ws) {
		this.ws = ws;
	}
	
	/**
	 * Fetching repository's issue and Collaborator details
	 * @author Elvin Rejimone
	 * @param query
	 * @param rp
	 * @param Option
	 * @param Cache An Injected Instance of Cache
	 * @return Return a boolean confirmation message
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public boolean githubIssueResultHelper(String query, RepositoryProfile rp, String Option, Cache cache) throws InterruptedException, ExecutionException {
		System.out.println("Query : " + query);
		
		JsonNode obj = cache.get(query);
		if(obj!= null) {
			System.out.println("Taking from Cache");
		}else {
			System.out.println("Not Available In Cache, Query Github API and Storing Result in Cache");
			WSRequest req = ws.url(query);
			req.setMethod("GET");
			CompletionStage<JsonNode> res = req.get().thenApply(r -> r.asJson());
			obj = Json.toJson(res.toCompletableFuture().get());
			cache.put(query, obj);
		}
		return rp.getDataFromResult(obj, Option);
	}
	
}