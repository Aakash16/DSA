package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ncr {

	private static final int MOD = (int) (1e9 + 7);
	private static final int N = 2000;
	private static final long[][] dp = new long[N + 1][N + 1];

	static {

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				dp[i][j] = -1;
			}
		}

		for (int i = 1; i <= N; i++) {

			dp[i][0] = 1;
			dp[i][i] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (dp[i][j] == -1) {
					dp[i][j] = (dp[i - 1][j - 1] % MOD + dp[i - 1][j] % MOD) % MOD;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(ints[0]);
			int r = Integer.parseInt(ints[1]);

			long ans = dp[n][r];
			out.write(ans + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	/*
	 * private static long nCr(int n, int r) { if (n == 0) return 0; if (r == 0)
	 * return 1;
	 * 
	 * if (dp[n][r] == -1) { return (nCr(n - 1, r - 1) % MOD + nCr(n - 1, r) % MOD)
	 * % MOD; } else return dp[n][r]; }
	 */

}