package HackerrankSI.recursion;

import java.util.Scanner;

public class TowerOfHanoi {

	private static int calls = 0;
	private static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			int N = sc.nextInt();

			sb = new StringBuilder();
			tower(N, 'A', 'B', 'c');
			System.out.println(calls);
			System.out.println(sb.toString());
			calls = 0;

		}
		sc.close();
	}

	private static void tower(int N, char s, char t, char d) {

		if (N == 0) {
			return;
		}
		tower(N - 1, s, d, t);
		sb.append(("Move " + N + " from " + s + " to " + d + "\n"));
		tower(N - 1, t, s, d);
		calls++;
	}
}
