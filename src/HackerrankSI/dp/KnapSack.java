package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KnapSack {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int cap = Integer.parseInt(ints[0]);
			int len = Integer.parseInt(ints[1]);

			int[] wg = new int[len];
			int[] val = new int[len];

			for (int t1 = 0; t1 < len; t1++) {

				ints = br.readLine().trim().split("\\s+");

				wg[t1] = Integer.parseInt(ints[0]);
				val[t1] = Integer.parseInt(ints[1]);

			}

			int ans = knapSack(cap, wg, val, len);
			out.write(ans + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	static int knapSack(int cap, int w[], int v[], int n) {
		int i, j;
		int dp[][] = new int[n + 1][cap + 1];

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= cap; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (w[i - 1] <= j)
					dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][cap];
	}
	
}
