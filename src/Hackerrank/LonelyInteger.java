package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int[] ar = new int[len];

		int tc = 0;
		while (tc < len) {
			ar[tc++] = in.nextInt();
		}

		in.close();
		int n = bins(ar);
		System.out.println(n);

	}

	private static int bins(int[] ar) {
		int len = ar.length;
		Arrays.sort(ar);
		int s = 0, e = len, mid = (e + s) / 2;

		while (s < e) {

			mid = (e + s) / 2;

			if (mid == e || mid == s || ar[mid] != ar[mid - 1] && ar[mid] != ar[mid + 1]) {
				return ar[mid];
			}

			if (ar[mid] == ar[mid - 1]) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		return ar[mid];
	}

}
