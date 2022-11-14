package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RangeSq {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			long[] ar = new long[2];

			String[] ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < 2; p++) {
				ar[p] = Long.parseLong(ints[p]);
			}

			long n = ar[0];
			long m = ar[1];

			long sq1 = (long) Math.sqrt(n);
			sq1 = (long) Math.ceil(sq1);

			long sq2 = (long) Math.sqrt(m);
			sq2 = (long) Math.floor(sq2);

			long dif = sq2 - sq1;

			if (dif >= 0)
				out.write((sq2 - sq1) + "\n");
			else
				out.write(0 + "\n");
		}

		br.close();
		out.close();
	}

	static double countSquares(int a, int b) {
		return (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
	}
}
