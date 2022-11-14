package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DecodeStr {

	private static final int MOD = (int) (1e9 + 7);

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());

			String ints = br.readLine();

			last = false;
			long ans = getCount(ints);
			out.write(ans + "\n");

		}

		out.flush();
		br.close();
		out.close();
	}

	private static boolean last;

	private static long getCount(String num) {

		long count = 1;

		for (int i = 1; i < num.length(); i++) {

			int c1 = num.charAt(i) - 48;
			int c2 = num.charAt(i - 1) - 48;

			int comb = (c2 * 10) + c1;

			if (comb >= 10 && comb <= 26) {
				if (last) {

					count = count / 2;
					count = (count * 3) % MOD;
					// System.out.println(c2 + " " + c1 + " " + comb);
					// System.out.println("last true " + count);
					//last = false;
				} else {
					count = (count * 2) % MOD;
					// System.out.println(c2 + " " + c1 + " " + comb);
					// System.out.println("last false " + count);
					last = true;
				}
			} else {
				last = false;
			}

		}

		return count;

	}

}
