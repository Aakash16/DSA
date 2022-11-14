package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FibonacciAdv {

	private static final int MOD = (int) (1e9 + 7);
	private static long N = 100001;
	private static final long[] dp = new long[(int)N];

	static {
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= 6; j++) {
				if ((i - j) >= 0) {
					dp[i] = (dp[i] % MOD + dp[(i - j)] % MOD) % MOD;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int sum = Integer.parseInt(br.readLine());
			long ans = dp[sum];
			out.write(ans + "\n");

		}

		out.flush();
		br.close();
		out.close();
	}

}
