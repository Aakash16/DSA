package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MatrixPath {
	private static final int MOD = (int) (1e9 + 7);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");

			int n = Integer.parseInt(ints[0]);
			int m = Integer.parseInt(ints[1]);
			int k = Integer.parseInt(ints[2]);

			int[][] b = new int[k][2];
			for (int tt = 0; tt < k; tt++) {
				ints = br.readLine().trim().split("\\s+");
				b[tt][0] = Integer.parseInt(ints[0]);
				b[tt][1] = Integer.parseInt(ints[1]);
			}

			/*
			 * System.out.println(n + " " + m + " " + k);
			 * 
			 * for (int tt = 0; tt < k; tt++) { System.out.println(b[tt][0] + " " +
			 * b[tt][1]); }
			 */

			out.write(getLen(n, m, b) + "\n");
		}

		br.close();
		out.close();
	}

	//static int last = 0;

	private static long getLen(int n, int m, int[][] k) {

		long[][] dp = new long[n + 1][m + 1];

		int t = 1;
		for (int i = 0; i <= n; i++) {
			if (isBlocked(k, i, 0)) {
				System.out.println("_b " + i + " " + 0);
				dp[i][0] = 0;
				t = 0;
			} else
				dp[i][0] = t;
		}

		t = 1;
		for (int i = 0; i <= m; i++) {
			if (isBlocked(k, 0, i)) {
				System.out.println("b_ " + 0 + " " + i);
				dp[0][i] = 0;
				t = 0;
			} else
				dp[0][i] = t;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (isBlocked(k, i, j)) {
					System.out.println("b " + i + " " + j);
					dp[i][j] = 0;
				} else
					dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD + dp[i-1][j-1] % MOD) % MOD;
			}
		}

		return dp[n - 1][m - 1];
	}

	private static boolean isBlocked(int[][] k, int x, int y) {
		for (int i = 0; i < k.length; i++) {
			if (k[i][0] == x && k[i][1] == y)
				return true;
		}
		return false;
	}
}
