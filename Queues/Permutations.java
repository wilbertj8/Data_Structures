import java.util.Stack;
import java.util.TreeSet;

public class Permutations {
	public static void main(String[] args) {
		//create word
		String word = "brian";
		//create permutations
		TreeSet<String> p = getPermutations(word);
		//print permutations
		System.out.println("Unique Permutations Formed: " + p.size() + "\n" + p);
	}

	public static TreeSet<String> getPermutations(String word) {
		Stack<String> words = new Stack<String>();
		TreeSet<String> permutations = new TreeSet<String>();
		words.push("+" + word);
		while (!words.isEmpty()) {
			String trial = words.pop();
			if (trial.endsWith("+"))
				permutations.add(trial.substring(0, trial.length() - 1));
			else {
				String temp = "";
				int index = trial.indexOf("+");
				for (int i = 1; i < trial.length() - trial.indexOf("+"); i++) {
					temp = trial.substring(0, index) + trial.charAt(index + i) + trial.substring(index, index + i)
							+ trial.substring(index + i + 1);
					words.push(temp);
				}
			}
		}
		return permutations;
	}
}
