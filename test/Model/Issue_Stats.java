package Model;

import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http.*;
import play.mvc.Result;
import play.test.WithApplication;
import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;
import org.junit.Before;
import Models.*;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.test.WithApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors.*;
import org.junit.Assert.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.Test;
public class Issue_Stats {
	static ArrayList<String> titles = new ArrayList<String>();
    static ArrayList<String> test;
    static ArrayList<String> keys= new ArrayList<String>();
	static Map<String,Integer> frequency= new HashMap<String,Integer>();
    static ArrayList<String> dummyList = new ArrayList<String>();

    @BeforeClass
     		public static void Init() {
                titles.add("Add Hierholzer algorithm (finding an eulerian circuit in a graph)");
                titles.add("No __init__.py in `Fractals`");
                titles.add("Implement Hierholzer algorithm (finding eulerian circuit on graph)");
                titles.add("Add flood fill algorithm implementation");
                titles.add("Update merge_insertion_sort.py");
                titles.add("Update merge_insertion_sort.py to solve #5774");
                titles.add("Add missing type annotations in `matrix` directory");
                titles.add("Added TrashBin Problem");
                titles.add("feat: Add basic issue forms");
                titles.add("Add-README-files-3/8");
                titles.add("Add missing type annotations for `strings` directory"); 
                titles.add("Improve Project Euler problem 074 solution 2");
                titles.add("Update `sorts/bubble_sort.py`");
                titles.add("Added volume of Ellipsoid and Tetrahedron");
                titles.add("Fix `sorts/bucket_sort.py` implementation");
                titles.add("Added: pressure.py");
                titles.add("Rewrite queue to make it more meaningful and readable, add type hints...");
                titles.add("Merge insertion sort doesn't work");
                titles.add("Improve Project Euler problem 203 solution 1");
                titles.add("Improve Project Euler problem 030 solution 1");

		
		        dummyList.add("Issue is new dependency");
		        dummyList.add("Issue is new dependency");
		
		        HashMap<String,Integer> dummyMap = new HashMap<String,Integer>();
		
				
     		}

   @Test
   public void testIssues() {
    //  Map<String, Integer> treeMap = new TreeMap<String, Integer>(Collections.reverseOrder());
    //  treeMap.putAll(frequency);
   // ArrayList<String> test2= new ArrayList<String>( Arrays.asList("Issue is new dependency","Issue is new dependency"));
    assertEquals(titles.size(),20); // checking if list is empty

    Stream<String> stream1 = titles.stream(); // converting ArrayList into Stream
    //Splitting stream on respect to " "
   stream1 = stream1.flatMap(
       (value)->{
       String[] split = value.split(" ");
       return (Stream<String>) Arrays.asList(split).stream();
            });
    //Mapping words with their frequency 
    Map<String, Integer> wordsCountMap = stream1.map(eachWord -> eachWord)
    .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));       
    //Sorting the result in descending order
    wordsCountMap = wordsCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

  
    StatisticsInfo S = new StatisticsInfo(); 
    StatsModel sm =S.Calculate_Count(titles);

   assertEquals(sm.wordfrequency,wordsCountMap); // checking if word frequency is same as frequency
   
   ArrayList<Integer> details = S.Calculate_Stats();



   assertEquals(details.get(0),(Integer)108); // total_words
   assertEquals(details.get(1),(Integer)38); // total_repetition
   assertEquals(details.get(2),(Integer)810); // total_char
   assertEquals(details.get(4),(Integer)6); // max_freq
   assertEquals(details.get(5),(Integer)1); // min_freq
   assertEquals(details.get(3),(Integer)70); // unique_words




   int count = titles.size();
   assertEquals(count,20); // checking if total issues is of that count
  
    }
   
}
