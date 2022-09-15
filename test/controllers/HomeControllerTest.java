package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

public class HomeControllerTest extends WithApplication {

	protected Application provideApplication() {
		return new GuiceApplicationBuilder().build();
	}

	@Test
	public void testIndex() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/");

		Result result = route(app, request);
		assertEquals(OK, result.status());
	}

	@Test
	public void testUser1() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/users/ujjawala397");

		Result result = route(app, request);
		assertEquals(404, result.status());
	}

	@Test
	public void testUser2() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/users");

		Result result = route(app, request);
		assertEquals(404, result.status());
	}

	@Test
	public void testUser3() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/users/ujjawala397/repos");

		Result result = route(app, request);
		assertEquals(404, result.status());
	}

	@Test
	public void testUser4() {
		Http.RequestBuilder request = new Http.RequestBuilder().method(GET).uri("/user/ujjawala397");

		Result result = route(app, request);
		assertEquals(200, result.status());
	}

	@Test
	public void testCommitStats() throws InterruptedException, ExecutionException {

		/*
		 * final WSClient client = Mockito.mock(WSClient.class); WSRequest request =
		 * Mockito.mock(WSRequest.class); WSResponse response =
		 * Mockito.mock(WSResponse.class);
		 * when(client.url("https://api.github.com/repos/TheAlgorithms/Java/commits")).
		 * thenReturn(request); when(request.addHeader(eq("Authroization"),
		 * anyString())).thenReturn(request);
		 * when(request.get()).thenReturn(CompletableFuture.completedFuture(response));
		 * when(response.asJson()).thenReturn(testOutput); HomeController hc = new
		 * HomeController(); hc.commits("TheAlgorithms", "Java");
		 * System.out.println(hc.result);
		 */
		Http.RequestBuilder req = new Http.RequestBuilder().method(Helpers.GET).uri("/repos/Santhosh-S14/Kotlin-progamming/commits");
		Result commitsResult = Helpers.route(app, req);
		assertEquals(Http.Status.OK, commitsResult.status());
		String commitsHtml = Helpers.contentAsString(commitsResult);
		assertTrue(commitsHtml.contains("<td style=\"background-color: #dee2e1;width: 200px;\">76</td>"));

	}

	@Test
	public void testTopics() {
		Http.RequestBuilder req = new Http.RequestBuilder().method(Helpers.GET).uri("/topic/java");
		Result topicsResult = Helpers.route(app, req);
		assertEquals(Http.Status.OK, topicsResult.status());
		String topicsHtml = Helpers.contentAsString(topicsResult);
		assertTrue(topicsHtml.contains("<h1 style=\"display:inline-block;margin-left: 10px;\">java</h1>"));
	}
	
	@Test
	   public void testIndexSearch() {
	       Http.RequestBuilder request = new Http.RequestBuilder()
	               .method(GET)
	               .uri("/?search=eclipse");

	       Result result = route(app, request);
	       assertEquals(200, result.status());
	   }


}
