import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		Map<String, Integer> scores;				//keys are strings, values are Integer wrappers
													//use the interface type for variable declarations
		
		scores = new TreeMap<String, Integer>();	//use a HashMap if you don't need 
												 	//to visit keys in sorted order
		scores.put("Harry", 90);					
		scores.put("Sally", 95);					//adds keys and values to the map	
		
		scores.put("Sally", 100);					//modifies value of existing key
		
		int n = scores.get("Sally");				//gets the value associated with a key, or null
		Integer n2 = scores.get("Diana");			//if they key is not present. n is 100, n2 is null
		
		System.out.println(scores);					//prints scores to .toString(), a string of the form
													//{Harry-90, Sally-100}
		
		for(String key : scores.keySet()) {			//iterates through all map keys and values
			Integer value = scores.get(key);
		}
		
		scores.remove("Sally");						//removes the key and value
	}
}
