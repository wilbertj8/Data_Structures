import java.util.Map;
import java.util.TreeMap;

public class LetterMap {
	public static void main(String args[]) {
		String text = "Mary had a little lamb";
		Map<String, Integer> freqs = makeLetterMap(text);
		System.out.println(freqs);
	}
	
	public static Map<String, Integer> makeLetterMap(String str) {
		//initializes Map of letters and frequencies
		Map<String, Integer> letterMap = new TreeMap<String, Integer>();
		//for loops to iterate through letters of String
		for (int i = 0; i < str.length(); i++) {
			String letter = str.substring(i, i + 1);
			//if selected letter doesn't exists in Map, add it to Map
			if (letterMap.get(letter) == null)
				letterMap.put(letter, 1);
			//otherwise, update current value of frequency of selected letter by 1
			else
				letterMap.put(letter, letterMap.get(letter) + 1);
		}
		return letterMap;
	}
}
