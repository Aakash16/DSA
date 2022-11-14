package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XoSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			long num = Long.parseLong(br.readLine());

			int c = 0;
			int c2 = 0;
			long num2 = num;
			while(num2>0) {
				num2 = num2 >> 1;
				c2++;
				
			}
			for (int i = 0; i < c2; i++) {

				if (!isSetbit(num, i)) {
					c++;
				}

			}

			long ans = (long) (Math.pow(2, c) - 1);
			System.out.println(ans);

		}

	}

	private static boolean isSetbit(long N, int i) {

		if (((N >> i) & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
