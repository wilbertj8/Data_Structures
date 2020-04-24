import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		String input = "Mary had a little lamb. Its fleece was white as snow. Now I'm full.";
		System.out.println(reverse(input));
	}

	public static String reverse(String str) {
		//output
		String output = "";
		//scanner to parse words
		Scanner in = new Scanner(str);
		Stack<String> words = new Stack<String>();
		//runs while another words exists
		while (in.hasNext()) {
			String word = in.next();
			//add word to stack
			words.add(word);
			//if last word added ends with a ".", print reversed sentence
			if (word.substring(word.length() - 1).equals(".")) {
				int size = words.size();
				//traverse through words in stack
				for (int i = 0; i < size; i++) {
					String wrd = words.pop();
					//make last word start with capital and remove period
					if (i == 0)
						output += wrd.substring(0, 1).toUpperCase() + wrd.substring(1, wrd.length() - 1) + " ";
					//remove capital from last word and add period
					else if (i == size - 1)
						output += wrd.substring(0, 1).toLowerCase() + wrd.substring(1) + ". ";
					//otherwise print word as it is
					else
						output += wrd + " ";
				}
			}
		}
		return output;
	}
}
