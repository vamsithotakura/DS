package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidParentheses {

	private static char bracketOneOpen = '(';
	private static char bracketOneClose = ')';

	private static char bracketTwoOpen = '{';
	private static char bracketTwoClose = '}';

	private static char bracketThreeOpen = '[';
	private static char bracketThreeClose = ']';

	static boolean isValid(String expression) {
		Stack<Character> myStack = new Stack<Character>(expression.length());
		char brackets[] = new char[expression.length()];
		brackets = expression.toCharArray();
		for(int i=0; i<expression.length(); i++) {
			if(brackets[i] == bracketOneOpen || brackets[i] == bracketTwoOpen || brackets[i] == bracketThreeOpen) {
				myStack.push(brackets[i]);
			} else if(brackets[i] == bracketOneClose || brackets[i] == bracketTwoClose || brackets[i] == bracketThreeClose) {
				if(myStack.isEmpty()) {
					return false;
				}
				char bracketLeft = (char) myStack.pop();
				char bracketRight = brackets[i];
				if(bracketLeft == bracketOneOpen && bracketRight == bracketOneClose) {
					continue;
				} else if(bracketLeft == bracketTwoOpen && bracketRight == bracketTwoClose) {
					continue;
				} else if(bracketLeft == bracketThreeOpen && bracketRight == bracketThreeClose) {
					continue;
				} else {
					return false;
				}
			}
		}
		if(myStack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {

		//The program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input an expression!");
		String expression = br.readLine();

		if(expression != null && !expression.isEmpty()) {
			System.out.println("Expression State : "+isValid(expression));
		}
	}
}
