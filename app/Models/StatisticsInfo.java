package Models;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.*;

/**
 * @author ANUSHKA SHARMA
 * 
 * Calculate total number or words in issues, total_repetition of words, total characters
 * max_frequency of a word, minimum frequency of a word, unique words as 
 * Statistics along with Map (key- words, value- count).
 */
public class StatisticsInfo {

    public Integer total_words;
	public Integer total_repetition;
	public Integer total_char;
	public Integer max_freq;
	public Integer min_freq;
	public Integer unique_words; 
    long c ,r, unique,char_c;
    ArrayList<Integer> calc = new ArrayList<Integer>();

    // calc word frequency
    public  StatsModel Calculate_Count (ArrayList<String> titleList){
        Stream<String> stream1 = titleList.stream(); // converting ArrayList into Stream
        Stream<String> stream_char = titleList.stream(); // converting ArrayList into Stream

        //Splitting stream on respect to " "
       stream1 = stream1.flatMap(
           (value)->{
           String[] split = value.split(" ");
           return (Stream<String>) Arrays.asList(split).stream();
                });
               
        
        //stream.forEach(s -> System.out.println(s)); // printing elements in Stream
        stream_char = stream_char.flatMap(
                (value)->{
                String[] splitc = value.split("");
                return (Stream<String>) Arrays.asList(splitc).stream();
                     });

        c= stream1.map((value)->{
            return value.toLowerCase();}).count(); // total_words
        char_c =stream_char.map((value)->{
            return value.toLowerCase();}).count(); // total_words
        Stream<String> stream = titleList.stream(); // converting ArrayList into Stream
        stream = stream.flatMap(
            (value)->{
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
                 });
        //Mapping words with their frequency 
        Map<String, Integer> wordsCountMap = stream.map(eachWord -> eachWord)
        .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));       
    
        
        //Sorting the result in descending order
        wordsCountMap = wordsCountMap.entrySet()
					.stream()
					.sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));
       unique = wordsCountMap.size();
       r = (c-unique);
        

    //     Iterator<String> itr = wordsCountMap.keySet().iterator();
    //     while (itr.hasNext()) {
    //         System.out.println(itr.next());
    // }

    max_freq = wordsCountMap.entrySet().stream().findFirst().get().getValue();
    min_freq  = Collections.min(wordsCountMap.values());
    StatsModel n = new StatsModel(wordsCountMap);
        
    for( Map.Entry<String, Integer> entry : wordsCountMap.entrySet() ){
        System.out.println( entry.getKey() + " => " + entry.getValue() );
    }
    return n ;
}

    //calc counts
    public ArrayList<Integer> Calculate_Stats (){
        // System.out.println("titleList---------------------");
        // for (String i : titleList){
        //     System.out.println(i);}
        // System.out.println("--------------------");

         // calc the number of issues
        //  int size=titleList.size();
        //  Integer iInteger = Integer.valueOf(size) ;
         //calc.add(iInteger);

        total_words = ((Long)c).intValue();        
        total_repetition =((Long)r).intValue();  
        total_char=((Long)char_c).intValue();
        unique_words= ((Long)unique).intValue();  
        calc.add(total_words);
        calc.add(total_repetition);
        calc.add(total_char);
        calc.add(unique_words);
        calc.add(max_freq);
        calc.add(min_freq);
        
        return calc;
        }
}
