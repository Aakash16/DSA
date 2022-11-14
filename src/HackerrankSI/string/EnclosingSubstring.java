package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnclosingSubstring {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] subs = br.readLine().trim().split("\\s+");
			long count = smallestWindow(subs[1], subs[0]);
			System.out.println(count);

		}
	}

	public static int smallestWindow(String A, String B) {

		int N = A.length();
		int M = B.length();

		int[] cArr_A = new int[27];
		int[] cArr_B = new int[27];

		int count = 0;
		int start = 0;
		int wlen = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			cArr_A[B.charAt(i) - 'a']++;
		}

		for (int j = 0; j < N; j++) {
			cArr_B[A.charAt(j) - 'a']++;

			if (cArr_A[A.charAt(j) - 'a'] >= cArr_B[A.charAt(j) - 'a']) {
				count++;
			}

			if (count == M) {

				while (cArr_B[A.charAt(start) - 'a'] > cArr_A[A.charAt(start) - 'a']
						|| cArr_A[A.charAt(start) - 'a'] == 0) {

					if (cArr_B[A.charAt(start) - 'a'] > cArr_A[A.charAt(start) - 'a']) {
						cArr_B[A.charAt(start) - 'a']--;
					}
					start++;

				}
				wlen = j - start + 1;
				ans = Math.min(ans, wlen);
			}

		}

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		return ans;
	}

}