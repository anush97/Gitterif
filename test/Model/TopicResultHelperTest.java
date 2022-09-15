package Model;
/**
 * Test Class for Models.TopicResultHelper.java
 *
 * @author  Sejal Chopra
 * @version 1.0.0
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

import Models.GithubResult;
import Models.TopicResultHelper;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TopicResultHelperTest {
	
	
	
	
	@Test
	public void testTopic() throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException {
		TopicResultHelper trh= new TopicResultHelper();
		String responseToCheck=null;
		//JsonNode testOutput=null;
		String result=null;
		String query=null;
		
		ObjectMapper mapper = new ObjectMapper();
	   
		responseToCheck="[{\"id\":371853626,\"node_id\":\"MDEwOlJlcG9zaXRvcnkzNzE4NTM2MjY=\",\"name\":\"excel-to-csv\",\"full_name\":\"bradjacobs\\/excel-to-csv\",\"private\":false,\"owner\":{\"login\":\"bradjacobs\",\"id\":39069344,\"node_id\":\"MDQ6VXNlcjM5MDY5MzQ0\",\"avatar_url\":\"https:\\/\\/avatars.githubusercontent.com\\/u\\/39069344?v=4\",\"gravatar_id\":\"\",\"url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\",\"html_url\":\"https:\\/\\/github.com\\/bradjacobs\",\"followers_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/followers\",\"following_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/following{\\/other_user}\",\"gists_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/gists{\\/gist_id}\",\"starred_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/starred{\\/owner}{\\/repo}\",\"subscriptions_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/subscriptions\",\"organizations_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/orgs\",\"repos_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/repos\",\"events_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/events{\\/privacy}\",\"received_events_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/received_events\",\"type\":\"User\",\"site_admin\":false},\"html_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv\",\"description\":\"Simple Conversion of Excel Worksheet to CSV (via JAVA)\",\"fork\":false,\"url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\",\"forks_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/forks\",\"keys_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/keys{\\/key_id}\",\"collaborators_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/collaborators{\\/collaborator}\",\"teams_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/teams\",\"hooks_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/hooks\",\"issue_events_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues\\/events{\\/number}\",\"events_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/events\",\"assignees_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/assignees{\\/user}\",\"branches_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/branches{\\/branch}\",\"tags_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/tags\",\"blobs_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/blobs{\\/sha}\",\"git_tags_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/tags{\\/sha}\",\"git_refs_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/refs{\\/sha}\",\"trees_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/trees{\\/sha}\",\"statuses_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/statuses\\/{sha}\",\"languages_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/languages\",\"stargazers_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/stargazers\",\"contributors_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/contributors\",\"subscribers_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/subscribers\",\"subscription_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/subscription\",\"commits_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/commits{\\/sha}\",\"git_commits_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/commits{\\/sha}\",\"comments_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/comments{\\/number}\",\"issue_comment_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues\\/comments{\\/number}\",\"contents_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/contents\\/{+path}\",\"compare_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/compare\\/{base}...{head}\",\"merges_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/merges\",\"archive_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/{archive_format}{\\/ref}\",\"downloads_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/downloads\",\"issues_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues{\\/number}\",\"pulls_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/pulls{\\/number}\",\"milestones_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/milestones{\\/number}\",\"notifications_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/notifications{?since,all,participating}\",\"labels_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/labels{\\/name}\",\"releases_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/releases{\\/id}\",\"deployments_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/deployments\",\"created_at\":\"2021-05-29T01:19:56Z\",\"updated_at\":\"2021-11-20T22:27:38Z\",\"pushed_at\":\"2021-11-20T22:27:36Z\",\"git_url\":\"git:\\/\\/github.com\\/bradjacobs\\/excel-to-csv.git\",\"ssh_url\":\"git@github.com:bradjacobs\\/excel-to-csv.git\",\"clone_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv.git\",\"svn_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv\",\"homepage\":\"\",\"size\":61,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":0,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":0,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https:\\/\\/api.github.com\\/licenses\\/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"allow_forking\":true,\"is_template\":false,\"topics\":[\"csv\",\"excel\",\"java\"],\"visibility\":\"public\",\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"main\",\"score\":1}]";
		 JsonNode testOutput = mapper.readTree(responseToCheck);
		//testOutput= Json.parse(responseToCheck);
		//result="";
		query="excel";
		LinkedHashMap<String, ArrayList<GithubResult>> check =trh.getArrayofGithubResult(query,testOutput);
		assertEquals(query,check.keySet().iterator().next());
		//assertEquals(result, check.entrySet().iterator().next());
	}
	
	@Test
	public void addToTotalSearchListTest() throws JsonMappingException, JsonProcessingException, InterruptedException, ExecutionException{
		
		TopicResultHelper trh= new TopicResultHelper();
		String responseToCheck=null;
		//JsonNode testOutput=null;
		String result=null;
		String query=null;
		
		ObjectMapper mapper = new ObjectMapper();
	   
		responseToCheck="[{\"id\":371853626,\"node_id\":\"MDEwOlJlcG9zaXRvcnkzNzE4NTM2MjY=\",\"name\":\"excel-to-csv\",\"full_name\":\"bradjacobs\\/excel-to-csv\",\"private\":false,\"owner\":{\"login\":\"bradjacobs\",\"id\":39069344,\"node_id\":\"MDQ6VXNlcjM5MDY5MzQ0\",\"avatar_url\":\"https:\\/\\/avatars.githubusercontent.com\\/u\\/39069344?v=4\",\"gravatar_id\":\"\",\"url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\",\"html_url\":\"https:\\/\\/github.com\\/bradjacobs\",\"followers_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/followers\",\"following_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/following{\\/other_user}\",\"gists_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/gists{\\/gist_id}\",\"starred_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/starred{\\/owner}{\\/repo}\",\"subscriptions_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/subscriptions\",\"organizations_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/orgs\",\"repos_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/repos\",\"events_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/events{\\/privacy}\",\"received_events_url\":\"https:\\/\\/api.github.com\\/users\\/bradjacobs\\/received_events\",\"type\":\"User\",\"site_admin\":false},\"html_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv\",\"description\":\"Simple Conversion of Excel Worksheet to CSV (via JAVA)\",\"fork\":false,\"url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\",\"forks_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/forks\",\"keys_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/keys{\\/key_id}\",\"collaborators_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/collaborators{\\/collaborator}\",\"teams_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/teams\",\"hooks_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/hooks\",\"issue_events_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues\\/events{\\/number}\",\"events_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/events\",\"assignees_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/assignees{\\/user}\",\"branches_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/branches{\\/branch}\",\"tags_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/tags\",\"blobs_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/blobs{\\/sha}\",\"git_tags_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/tags{\\/sha}\",\"git_refs_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/refs{\\/sha}\",\"trees_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/trees{\\/sha}\",\"statuses_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/statuses\\/{sha}\",\"languages_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/languages\",\"stargazers_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/stargazers\",\"contributors_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/contributors\",\"subscribers_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/subscribers\",\"subscription_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/subscription\",\"commits_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/commits{\\/sha}\",\"git_commits_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/git\\/commits{\\/sha}\",\"comments_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/comments{\\/number}\",\"issue_comment_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues\\/comments{\\/number}\",\"contents_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/contents\\/{+path}\",\"compare_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/compare\\/{base}...{head}\",\"merges_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/merges\",\"archive_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/{archive_format}{\\/ref}\",\"downloads_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/downloads\",\"issues_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/issues{\\/number}\",\"pulls_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/pulls{\\/number}\",\"milestones_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/milestones{\\/number}\",\"notifications_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/notifications{?since,all,participating}\",\"labels_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/labels{\\/name}\",\"releases_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/releases{\\/id}\",\"deployments_url\":\"https:\\/\\/api.github.com\\/repos\\/bradjacobs\\/excel-to-csv\\/deployments\",\"created_at\":\"2021-05-29T01:19:56Z\",\"updated_at\":\"2021-11-20T22:27:38Z\",\"pushed_at\":\"2021-11-20T22:27:36Z\",\"git_url\":\"git:\\/\\/github.com\\/bradjacobs\\/excel-to-csv.git\",\"ssh_url\":\"git@github.com:bradjacobs\\/excel-to-csv.git\",\"clone_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv.git\",\"svn_url\":\"https:\\/\\/github.com\\/bradjacobs\\/excel-to-csv\",\"homepage\":\"\",\"size\":61,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":0,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":0,\"license\":{\"key\":\"apache-2.0\",\"name\":\"Apache License 2.0\",\"spdx_id\":\"Apache-2.0\",\"url\":\"https:\\/\\/api.github.com\\/licenses\\/apache-2.0\",\"node_id\":\"MDc6TGljZW5zZTI=\"},\"allow_forking\":true,\"is_template\":false,\"topics\":[\"csv\",\"excel\",\"java\"],\"visibility\":\"public\",\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"main\",\"score\":1}]";
		 JsonNode testOutput = mapper.readTree(responseToCheck);
		//testOutput= Json.parse(responseToCheck);
		//result="";
		query="excel";
		LinkedHashMap<String, ArrayList<GithubResult>> check =trh.getArrayofGithubResult(query,testOutput);
		GithubResult resultfetch = new GithubResult("excel-to-csv","bradjacobs",mapper.readTree("[\"csv\",\"excel\",\"java\"]"),query, "371853626");
		ArrayList<GithubResult> checklist=new ArrayList<GithubResult>();
		checklist.add(resultfetch);
		trh.addToTotalSearchList(query, checklist);
		assertEquals(query,trh.allSearches.get(0));
		//assertEquals(resultfetch,trh.allSearches.get(0));
		
	}
}

