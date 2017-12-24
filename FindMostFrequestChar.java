package Hyland;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FindMostFrequestChar {

	public static LinkedHashMap<Character, Integer> sortHashMapByValues(
	        HashMap<Character, Integer> passedMap) {
	    List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues, Collections.reverseOrder());
	    Collections.sort(mapKeys, Collections.reverseOrder());

	    LinkedHashMap<Character, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<Character> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Character key = keyIt.next();
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

	static HashMap<Character,Integer> createMap(String s){
	    char[] array = s.toCharArray();
	    int l = array.length;
	   HashMap<Character,Integer> map = new HashMap<>();     
	   for(int i=0;i<l;i++){
	        if(map.containsKey(array[i]))
	   map.put(array[i],map.get(array[i])+1);
	        else{
	    map.put(array[i],1);  
	      }
	    } 
	   return map;     
	}

	//main method
	static void printFrequentChar(String s){
	     HashMap<Character,Integer> map = createMap(s);
	     LinkedHashMap<Character, Integer> linkMap = sortHashMapByValues(map);
	     int min = Integer.MIN_VALUE;
	     for(Map.Entry<Character, Integer> entry : linkMap.entrySet()){
	    	 int maxValue = entry.getValue();
	    	 if(maxValue>=min){
	    		 System.out.println(entry.getKey());
	    		 min = maxValue;
	    	 }
	    	 else{
	    		 break;
	    	 }
	    	 
	     }
	     
	}
	
	public static void main(String [] arg){
		printFrequentChar("AABBDDFFRRffgg");
	}
}
