package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
/**
 * Class for CommitsResult data model
 * @author Santhosh Santhanam
 *
 */
public class CommitsResult {
	
	public List<JsonNode> commitsList;
	public JsonNode allCommitsData;
	public String userAvatar;
	public String userName;
	public String commitMsg;
	public String nAdd, nDel, total;
	public Optional<Integer> maxAdd, minAdd, maxDel, minDel, avgAdd, avgDel;
	
	public CommitsResult() {
		
	}
	/**
	 * Constructor for getting and setting the username, no.of additions and deletions
	 * @param userName
	 * @param nAdd
	 * @param nDel
	 */
	public CommitsResult(String userName, String nAdd, String nDel) {
		this.userName = userName;
		this.nAdd = nAdd;
		this.nDel = nDel;
	}
	/**
	 * Get user name
	 * @return
	 */
	public String get_user_name() {
		return this.userName;
	}
	/**
	 * Get no. of additions in a commit
	 * @return
	 */
	public String get_additions() {
		return this.nAdd;
	}
	/**
	 * Get no. of deletions
	 * @return
	 */
	public String get_deletions() {
		return this.nDel;
	}
	
	/**
	 * Constructor for data model
	 * @param userAvatar
	 * @param userName
	 * @param commitMsg
	 * @param nAdd
	 * @param nDel
	 * @param total
	 * @param maxAdd
	 * @param minAdd
	 * @param maxDel
	 * @param minDel
	 * @param avgAdd
	 * @param avgDel
	 */
	public CommitsResult(String userAvatar, String userName, String commitMsg, String nAdd, String nDel, String total, 
			Optional<Integer> maxAdd, Optional<Integer> minAdd, Optional<Integer> maxDel, Optional<Integer> minDel, Optional<Integer> avgAdd, Optional<Integer> avgDel){
		this.userAvatar = userAvatar;
		this.userName = userName;
		this.commitMsg = commitMsg;
		this.nAdd = nAdd;
		this.nDel = nDel;
		this.total = total;
		this.maxAdd = maxAdd;
		this.minAdd = minAdd;
		this.maxDel = maxDel;
		this.minDel = minDel;
		this.avgAdd = avgAdd;
		this.avgDel = avgDel;
	}

}