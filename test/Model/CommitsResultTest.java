package Model;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import Models.CommitsResult;
import play.libs.Json;

public class CommitsResultTest {

	static String responseToCheck;
	static JsonNode testOutput;

	@BeforeClass
	public static void setupForTesting() {
		responseToCheck = "{\"commit\":{\"message\":\"Addauthor(#2831)\\n\\nCo-authored-by:github-actions<${GITHUB_ACTOR}@users.noreply.github.com>\",\"tree\":{\"sha\":\"7d813b5aa9ef0f067efd042bc71894dfc863d64f\",\"url\":\"https://api.github.com/repos/TheAlgorithms/Java/git/trees/7d813b5aa9ef0f067efd042bc71894dfc863d64f\"}},\"author\":{\"login\":\"Sachwin-Kohli\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/68062300?v=4\"},\"stats\":{\"total\":789,\"additions\":392,\"deletions\":397}}";
		testOutput = Json.parse(responseToCheck);
	}

	@Test
	public void testCommitsApi() throws InterruptedException, ExecutionException {
		// System.out.println(testOutput);
		CommitsResult cr = new CommitsResult(testOutput.get("author").findPath("login").asText(),
				testOutput.get("stats").findPath("additions").asText(),
				testOutput.get("stats").findPath("deletions").asText());
		assertEquals(cr.get_user_name(), "Sachwin-Kohli");
		assertEquals(cr.get_additions(), "392");
		assertEquals(cr.get_deletions(), "397");

		CommitsResult cr1 = new CommitsResult(testOutput.get("author").findPath("avatar_url").asText(),
				testOutput.get("author").findPath("login").asText(),
				testOutput.get("commit").findPath("message").asText(),
				testOutput.get("stats").findPath("additions").asText(),
				testOutput.get("stats").findPath("deletions").asText(),
				testOutput.get("stats").findPath("total").asText(), Optional.of(1554), Optional.of(1298),
				Optional.of(2321), Optional.of(1145), Optional.of(156), Optional.of(123));

		assertEquals(cr1.userAvatar, "https://avatars.githubusercontent.com/u/68062300?v=4");
		assertEquals(cr1.get_user_name(), "Sachwin-Kohli");
		assertEquals(cr1.commitMsg,
				"Addauthor(#2831)\n\nCo-authored-by:github-actions<${GITHUB_ACTOR}@users.noreply.github.com>");
		assertEquals(cr1.get_additions(), "392");
		assertEquals(cr1.get_deletions(), "397");
		assertEquals(cr1.total, "789");
		assertEquals(cr1.maxAdd, Optional.of(1554));
		assertEquals(cr1.minAdd, Optional.of(1298));
		assertEquals(cr1.maxDel, Optional.of(2321));
		assertEquals(cr1.minDel, Optional.of(1145));
		assertEquals(cr1.avgAdd, Optional.of(156));
		assertEquals(cr1.avgDel, Optional.of(123));
	}
}