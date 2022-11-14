package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] subs = br.readLine().trim().split("\\s+");
			long count = getKMPatch(subs[1], subs[0]);
			System.out.println(count);

		}

	}

	private static long getKMPatch(String A, String B) {

		int txtLen = A.length();
		int patLen = B.length();
		int i = 0;
		int j = 0;
		long count = 0;
		int[] arr = getkArray(B);
		while (i < txtLen) {
			if (A.charAt(i) == B.charAt(j)) {
				i++;
				j++;
			}

			if (j == patLen) {
				count++;
				j = arr[j - 1];
			} else if (i < txtLen && A.charAt(i) != B.charAt(j)) {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					i++;
				}
			}
		}
		return count;
	}

	private static int[] getkArray(String A) {

		int N = A.length();
		int[] ar = new int[N];
		ar[0] = 0;
		int i = 1;
		int j = 0;

		while (i < N) {

			if (A.charAt(i) == A.charAt(j)) {
				j++;
				ar[i] = j;
				i++;
			} else {

				if (j != 0) {
					j = j - 1;
				} else {
					ar[i] = j;
					i++;
				}
			}

		}

		return ar;
	}
}
