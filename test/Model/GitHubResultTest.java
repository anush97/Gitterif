package Model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import play.libs.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.GithubResult;

public class GitHubResultTest {

	public JsonNode topicsList;
	public String topicListString = "[\"eclipseiot\",\"home-automation\",\"internet-of-things\",\"iot\",\"java\",\"smarthome\"]";
		
	
	@Test
	public void testGithubResultFunctions() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		topicsList = mapper.readTree(topicListString);
		GithubResult GR1 = new GithubResult("1smarthome1","1eclipse-archived1",topicsList,"eclipse","15778981");
		assertEquals("smarthome", GR1.getRepoName());
		assertEquals("eclipse-archived", GR1.getOwnerName());
	}
}
