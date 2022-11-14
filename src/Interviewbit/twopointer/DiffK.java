package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DiffK {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
		int k = 4;

		System.out.println(diffPossible(list, k));
	}

	public static int diffPossible(ArrayList<Integer> A, int K) {
		Collections.sort(A);
		boolean is = false;
		for (int i = 0; i < A.size() - 1; i++) {

			int k = A.get(i) + K;
			is = binSearch(A, i + 1, A.size() - 1, k);
			if (is)
				break;
		}
		if (is)
			return 1;
		else
			return 0;

	}

	private static boolean binSearch(ArrayList<Integer> ar, int lo, int hi, int k) {

		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (ar.get(mid) == k) {
				return true;
			}

			if (k < ar.get(mid))
				return binSearch(ar, lo, mid - 1, k);
			else
				return binSearch(ar, mid + 1, hi, k);
		}

		return false;

	}
}
