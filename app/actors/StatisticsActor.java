package actors;

import Models.*;
import play.libs.Json;
import services.StatsService;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.*;
/**
 * @author Anushka Sharma
 * create a new Akka Actor to perform the Word Level Statistics of Issues of a repository , together with appropriate message classes
 * 
 * @version 1.0.0
 */
public class StatisticsActor extends AbstractActor {

    static public class StatsInfo {

		public final ArrayList<String> issueTitleList;
    /**
	 * Constructor to create instance of this actor.
	 * 
	 * @param issueTitleList
	 */
        public StatsInfo(ArrayList<String> issueTitleList) {
			this.issueTitleList = issueTitleList;
        }
    }
	/**
	 * Factory method to create instance of Word Stats Actor
	 * @return Props
	 */
	public static Props getProps() {
		return Props.create(StatisticsActor.class);
	}
	
	/**
	 * It receives referrences and decides action based on them.
	 * 
	 */
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(StatsInfo.class, this::sendIssueData )
				.build();
	}

    /**
	 * This method sends issue list data when queried by user to service 
	 * Calculate total number or words in issues, total_repetition of words, total characters
 	 * max_frequency of a word, minimum frequency of a word, unique words as 
 	 * Statistics along with Map (key- words, value- count).
	 */
	private void sendIssueData(StatsInfo si) {
		HashMap<String,Object> send_data = new HashMap<String,Object>();
			//StatsService statsService ;
			StatsService statsService = new StatsService();
			StatsModel stats = statsService.get_Count(si.issueTitleList);

            // for (Map.Entry<String, Integer> entry1 : stats.wordfrequency.entrySet()) {
			// 	System.out.println(entry1.getKey() + " => " + entry1.getValue());
			// }
			
			System.out.println();
			System.out.println("Data List got");
			System.out.println();
			//
			ArrayList<Integer> Isseus_details = statsService.getstatsData();
			System.out.println();
			System.out.println("Stats List got");
			System.out.println();
			//////////////////////////////
			send_data.put("list",stats);
			send_data.put("count",Isseus_details);
			System.out.println(send_data.get("list"));
			System.out.println(send_data.get("count"));
			sender().tell(send_data, self());
	    
		


	}

}
