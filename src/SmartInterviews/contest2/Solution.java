package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int len = Integer.parseInt(ints[0]);
			int m = Integer.parseInt(ints[0]);
			int[] ar = new int[len];

			String[] ints2 = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints2[p]);
			}

			find(ar, m);
		}

		br.close();
		out.close();
	}

	public static void find(int[] arr, int m) {
		int l = 0, r = 0;
		int maxLen = 0;
		int zeroCount = 0;
		int len = arr.length;
		while (r < len) {
			if (zeroCount <= m) {
				if (arr[r] == 0)
					zeroCount++;
				r++;
			}
			if (zeroCount > m) {
				if (arr[l] == 0)
					zeroCount--;
				l++;
			}
			if ((r - l > maxLen) && (zeroCount <= m)) {
				maxLen = r - l;
			}
		}
		System.out.print(maxLen + " ");

	}

}
