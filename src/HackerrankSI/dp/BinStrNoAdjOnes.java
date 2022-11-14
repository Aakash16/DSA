package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinStrNoAdjOnes {
	private static final int MOD = (int) (1e9 + 7);
	private static int N = 100000;
	private static final long[] ans = new long[N + 1];
	private static final int[] dp0 = new int[N];
	private static final int[] dp1 = new int[N];
	static {
		dp0[0] = 1;
		dp1[0] = 1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int num = Integer.parseInt(br.readLine());

			out.write(getLen(num) + "\n");
		}

		br.close();
		out.close();
	}

	static int last = 0;

	private static long getLen(int num) {
		long ans = 0;

		if ((num - 1) <= last) {
			ans = (dp0[num - 1] % MOD + dp1[num - 1] % MOD) % MOD;
			//System.out.println(num + " already");
		} else {
			//System.out.println(num + " new calc");
			for (int i = (last + 1); i < num; i++) {

				dp0[i] = (dp0[i - 1] % MOD + dp1[i - 1] % MOD) % MOD;

				dp1[i] = dp0[i - 1] % MOD;

				last = i;
			}
		}

		//System.out.println("last " + last);

		ans = (dp0[num - 1] % MOD + dp1[num - 1] % MOD) % MOD;

		return ans;
	}
}
