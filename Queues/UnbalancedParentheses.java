import java.util.EmptyStackException;
import java.util.Stack;

public class UnbalancedParentheses {
	public static void main(String[] args) {
		String test = ")(";
		System.out.println(stackValid(test));
	}

	public static boolean valid(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				count++;
			else if (str.charAt(i) == ')')
				count--;
			if (count < 0)
				return false;
		}
		return count == 0;
	}

	public static boolean stackValid(String str) {
		Stack<String> parentheses = new Stack<String>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				parentheses.push("(");
			else if (str.charAt(i) == ')')
				try {
					parentheses.pop();
				} catch (EmptyStackException ex) {
					return false;
				}
		}
		return parentheses.isEmpty();
	}
}
