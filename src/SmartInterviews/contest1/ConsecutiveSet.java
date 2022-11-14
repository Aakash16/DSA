package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsecutiveSet {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < tc; t++) {

			long num = Long.parseLong(br.readLine());

			long count = 0;
			long ans = Integer.MIN_VALUE;
		
			for (int i = 0; i < 64; i++) {

				if (isSetbit(num, i)) {
					count++;
				} else {
					ans = Math.max(count, ans);
					count = 0;
				}

			}
			
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
