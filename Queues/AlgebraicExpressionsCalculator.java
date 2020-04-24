import java.util.Scanner;
import java.util.Stack;

public class AlgebraicExpressionsCalculator {
	//instance variables
	public static Stack<String> operators = new Stack<String>();
	public static Stack<Integer> operons = new Stack<Integer>();

	public static void main(String args[]) {
		//scanner object
		Scanner in = new Scanner(System.in);
		//prompts for input
		System.out.println("Enter one number or operator per line. Type q to quit.");
		boolean done = false;
		//while not done, continue
		while (!done) {
			//takes in next line
			String input = in.nextLine();
			//check if integer, otherwise push operator
			try {
				operons.push(Integer.parseInt(input));
			} catch (NumberFormatException e) {
				//if open parentheses, push it
				if (input.equals("("))
					operators.push(input);
				//if arithmetic operator, evaluate if operator stack isn't empty
				else if (input.equals("%") || input.equals("*") || input.equals("-") || input.equals("+")
						|| input.equals("/")) {
					while (!operators.isEmpty() && hasPrecedence(operators.peek(), input))
						evaluateTop();
					operators.push(input);
				} 
				//if close parentheses, evaluate until open parentheses is found
				else if (input.equals(")")) {
					while (!operators.peek().equals("("))
						evaluateTop();
					operators.pop();
				}
				//if q, then quit program
				else if (input.equals("q")) {
					done = true;
					in.close();
					while (operators.size() != 0)
						evaluateTop();
				}
			}
		}
		//print final result
		System.out.println(operons.pop());
	}

	private static void evaluateTop() {
		//pop off operons and operators
		int one = operons.pop();
		int two = operons.pop();
		String op = operators.pop();
		//evaluate operation
		switch (op) {
			case "%": {
				operons.add(two % one);
				break;
			}
			case "+": {
				operons.add(two + one);
				break;
			}
			case "-": {
				operons.add(two - one);
				break;
			}
			case "*": {
				operons.add(two * one);
				break;
			}
			case "/": {
				operons.add(two / one);
				break;
			}
		}
	}

	private static boolean hasPrecedence(String op1, String op2) {
		//if + or -, return true if second is + or -, otherwise false
		if (op1.equals("+") || op1.equals("-"))
			return op2.equals("+") || op2.equals("-");
		//if * or / or %, return true, since it has precedence
		return op1.equals("*") || op1.equals("%") || op1.equals("/");
	}
}
