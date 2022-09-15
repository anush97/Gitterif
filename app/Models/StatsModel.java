package Models;
import java.util.Map;
/**
 * @author ANUSHKA SHARMA
 * 
 * Store words- its count in this model as Map (key- words, value- count).
 */
public class StatsModel {
    public Map<String, Integer> wordfrequency;


	public StatsModel( Map<String, Integer> wordfrequency) {
		this.wordfrequency = wordfrequency;
		
	}
}
