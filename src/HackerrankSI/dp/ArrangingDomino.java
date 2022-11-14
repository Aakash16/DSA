package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArrangingDomino {

	private static final int MOD = (int) (1e9 + 7);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int n = Integer.parseInt(br.readLine());
			long ans = countWays(n);
			out.write(ans + "\n");

		}

		out.flush();
		br.close();
		out.close();
	}

	static int countWays(int n) {
		int count[] = new int[1000000 + 1];
		count[0] = 0;
		count[1] = 1;
		count[2] = 1;
		count[3] = 2;
		count[4] = 3;
		count[5] = 7;

		for (int i = 6; i <= n; i++) {

			if (i % 2 == 0)
				count[i] = count[i - 1] + count[i - 5];
			else
				count[i] = count[i - 1]*2 + count[i - 5]*2;
		}

		return count[n];
	}

}
