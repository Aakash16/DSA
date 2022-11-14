package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divisors {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());

			int sqr = (int) Math.sqrt(num);
			int c = 0;
			//System.out.println("s:" + sqr);
			boolean isPerf = false;
			for (int f = 1; f <= sqr; f++) {

				if (f * f == num) {
					isPerf = true;
				}
				if (num % f == 0)
					c++;
			}

			int ans = 2 * c;
			if (isPerf)
				ans--;
			System.out.println(ans);
		}
	}

}
