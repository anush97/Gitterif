package Models;

/**
 * Class for Issue Values in Repository Profile Page
 * @author Elvin Rejimone
 *
 */
public class RepoCollaborator{
	
	public String ContributorName;
	public String ContributorID;
	public String ContributorContributions;
	public String ContributorAvatarURL;

	
	/**
	 * Constructor to create Indivudual Issues
	 * @param title
	 * @param body
	 * @param created
	 * @param state
	 * @param issueNo
	 * @author Elvin Rejimone
	 */
	public RepoCollaborator(String name, String id, String contributions, String avatar) {
		ContributorName = name.substring(1, name.length()-1);
		ContributorID = id;
		ContributorContributions = contributions;
		ContributorAvatarURL = avatar.substring(1, avatar.length()-1);;
	}
	
}