package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			String[] subs = br.readLine().trim().split("\\s+");
			long count = KmpAlgo(subs);
			System.out.println(count);

		}
	}

	public static long KmpAlgo(String[] str) {
		String pat = str[0];
		String txt = str[1];
		int txtLen = txt.length();
		int patLen = pat.length();
		int i = 0;
		int j = 0;
		long count = 0;
		int[] arr = ComputeArray(pat, patLen);
		while (i < txtLen) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}

			if (j == patLen) {
				count++;
				j = arr[j - 1];
			} else if (i < txtLen && txt.charAt(i) != pat.charAt(j)) {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					i++;
				}
			}
		}
		return count;
	}

	public static int[] ComputeArray(String st, int len) {
		int[] ar = new int[len];
		ar[0] = 0;
		int i = 1;
		int j = 0;

		while (i < len) {

			if (st.charAt(i) == st.charAt(j)) {
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
