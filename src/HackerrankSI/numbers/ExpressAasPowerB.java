package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExpressAasPowerB {

	private static long N = 100000000;
	private static boolean[] visited = new boolean[(int) N];

	static {
		for (int i = 2; i < 1000; i++) {
			int j = i;
			long prod = i * j;
			while (prod < N) {
				visited[(int) prod] = true;
				prod *= i;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int num = Integer.parseInt(br.readLine());
			if (num == N || visited[num]) {
				out.write("Yes\n");
			} else {
				out.write("No\n");
			}
		}

		br.close();
		out.close();
	}

}
