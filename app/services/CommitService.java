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

import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import Models.CommitsResult;
/**
 * Class for CommitsResult data model
 * @author Santhosh Santhanam
 * fetch the 100 newest commits and compile statistics about: (i) the top-10 committers, i.e., users who had
 * the most commits, where you hyperlink the user to the profile page from task a) and show the total
 * number of commits of that user as a number (n) next to the name; (ii) the minimum, maximum,
 * and average number of additions and deletions across all these commits.
 */
public class CommitService implements WSBodyReadables, WSBodyWritables {

	private WSClient ws;
	public Map<String, Integer> result = new LinkedHashMap<>();

	CommitsResult cr;

	@Inject
	public CommitService(WSClient ws) {
		this.ws = ws;
	}

	public CompletableFuture<List<CommitsResult>> getCommitsData(String ownerName, String repoName) {
		List<Integer> AddList = new ArrayList<>();
		List<Integer> DelList = new ArrayList<>();
		List<CommitsResult> commitsDataModelList = new ArrayList<>();
		return CompletableFuture.supplyAsync(() -> {
			Optional<Integer> maxAdd, maxDel, minAdd, minDel, avgAdd, avgDel;
			String commitUrl = "https://api.github.com/repos" + "/" + ownerName + "/" + repoName + "/commits";
			System.out.println(commitUrl);
			WSRequest req1 = ws.url(commitUrl).addHeader("Authorization",
					"token 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");
			req1.addQueryParameter("per_page", "100");
			req1.addQueryParameter("page", "1");
			req1.setMethod("GET");
			CompletionStage<JsonNode> jsonPromise = req1.get().thenApply(r -> r.getBody(json()));
			try {
				List<String> shaList = new ArrayList<String>();
				for (JsonNode sha : jsonPromise.toCompletableFuture().get()) {
					shaList.add(sha.get("sha").asText());
				}

				System.out.println("Sha size: " + shaList.size());
				for (int i = 0; i < shaList.size(); i++) {
					WSRequest req = ws.url(commitUrl + "/" + shaList.get(i)).addHeader("Authorization",
							"token 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");
					req.setMethod("GET");
					CompletionStage<JsonNode> resFromRequest = req.get().thenApply(result -> result.asJson());
					JsonNode temp = resFromRequest.toCompletableFuture().get();
					AddList.add(temp.get("stats").findPath("additions").asInt());
					DelList.add(temp.get("stats").findPath("deletions").asInt());
					maxAdd = AddList.stream().max(Integer::compare);
					minAdd = AddList.stream().min(Integer::compare);
					avgAdd = Optional.of(AddList.stream().reduce(0, Integer::sum) / shaList.size());
					maxDel = DelList.stream().max(Integer::compare);
					minDel = DelList.stream().min(Integer::compare);
					avgDel = Optional.of(DelList.stream().reduce(0, Integer::sum) / shaList.size());
					cr = new CommitsResult(temp.get("author").findPath("avatar_url").asText(),
							temp.get("author").findPath("login").asText(),
							temp.get("commit").findPath("message").asText(),
							temp.get("stats").findPath("additions").asText(),
							temp.get("stats").findPath("deletions").asText(),
							temp.get("stats").findPath("total").asText(), maxAdd, minAdd, maxDel, minDel, avgAdd,
							avgDel);
					commitsDataModelList.add(cr);
				}

			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commitsDataModelList;

		});
	}

}
