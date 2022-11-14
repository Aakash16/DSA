package SmartInterviews.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketPrint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		// List<String> result = new ArrayList<>();
		// bracket(count, count, "", result);
		// System.out.println(result);

		//bracket2(new ArrayList<Character>(), 0, 0, count, 0);

		bracket2(new char[2 * count], 0, 0, count, 0);
		sc.close();
	}

	private static void bracket(int op, int cl, String temp, List<String> result) {

		if (op == 0 && cl == 0) {
			result.add(temp);
			return;
		}

		if (op > 0) {

			bracket(op - 1, cl, temp + "(", result);
		}

		if (op < cl) {

			bracket(op, cl - 1, temp + ")", result);
		}
	}

	private static void bracket2(ArrayList<Character> list, int op, int cl, int N, int idx) {

		if (idx == 2 * N) {

			for (char c : list) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}

		if (op < N) {
			list.add('(');
			bracket2(list, op + 1, cl, N, idx + 1);
			list.remove(list.size() - 1);
		}

		if (cl < op && cl < N) {
			list.add(')');
			bracket2(list, op, cl + 1, N, idx + 1);
			list.remove(list.size() - 1);
		}
	}

	private static void bracket2(char[] ar, int op, int cl, int N, int idx) {

		if (idx == 2 * N) {
			System.out.println(String.valueOf(ar));
			return;
		}

		if (op < N) {
			ar[idx] = '(';
			bracket2(ar, op + 1, cl, N, idx + 1);
			// list.remove(list.size()-1);
		}

		if (cl < op && cl < N) {
			ar[idx] = ')';
			bracket2(ar, op, cl + 1, N, idx + 1);
			// list.remove(list.size()-1);
		}
	}
}
