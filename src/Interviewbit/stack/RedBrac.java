package Interviewbit.stack;

import java.util.Stack;

public class RedBrac {

	public static void main(String[] args) {

		String A = "((a + b))";
		A = "(a + (a + b))";
		A = "(a*b)+(b*(d+(a)))";
		braces(A);

	}

	private static int braces(String A) {

		Stack<Integer> br = new Stack<Integer>();
		Stack<Integer> op = new Stack<Integer>();

		for (int i = 0; i < A.length(); i++) {

			char c = A.charAt(i);

			switch (c) {

			case '(':

				br.push(1);
				break;

			case ')':

				if (!op.isEmpty()) {
					op.pop();
					br.pop();
				}
				break;

			case '+':
			case '-':
			case '*':
			case '/':

				if (!br.isEmpty())
					op.push(1);

				break;
			}

		}

		System.out.println(br.toString());

		if (br.size() > 0)
			return 1;
		else
			return 0;
	}

}
