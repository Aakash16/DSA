package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPalindrome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());
			String A = br.readLine().trim();

			int ans = 0;

			for (int i = 0; i < len; i++) {

				int subL = 0;
				int p1 = i;
				int p2 = i;

				while (p1 >= 0 && p2 < len) {

					if (A.charAt(p1) == A.charAt(p2)) {

						subL++;
						p1--;
						p2++;
					} else {
						break;
					}
				}
				ans = Math.max(ans, (subL * 2 - 1));

				subL = 0;
				p1 = i;
				p2 = i + 1;

				while (p1 >= 0 && p2 < len) {

					if (A.charAt(p1) == A.charAt(p2)) {
						subL++;
						p1--;
						p2++;
					} else {
						break;
					}
				}
				ans = Math.max(ans, (subL * 2));
			}

			System.out.println("F: " + ans);

		}

	}
}
