import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
	public static void main(String[] args) {
		Map<String, Color> favoriteColors = new HashMap<String, Color>();
		favoriteColors.put("Juliet", Color.blue);
		favoriteColors.put("Romeo", Color.green);
		favoriteColors.put("Adam", Color.red);
		favoriteColors.put("Eve", Color.blue);
		//prints all keys and values in the map
		Set<String> keySet = favoriteColors.keySet();
		for(String key : keySet) {
			Color value = favoriteColors.get(key);
			System.out.println(key + " : " + value);
		}
	}
}
