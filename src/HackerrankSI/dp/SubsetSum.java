package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SubsetSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int len = Integer.parseInt(ints[0]);
			int sum = Integer.parseInt(ints[1]);

			int[] ar = new int[len];

			ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			boolean is = func(ar, len, sum);
			if (is)
				out.write("YES\n");
			else
				out.write("NO\n");

		}

		out.flush();
		br.close();
		out.close();
	}

	static boolean func(int set[], int n, int sum) {
		boolean subset[][] = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		return subset[sum][n];
	}
}
