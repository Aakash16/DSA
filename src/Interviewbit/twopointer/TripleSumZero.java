package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripleSumZero {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(
				Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3));

		ArrayList<ArrayList<Integer>> res = threeSum(list);

		for (ArrayList<Integer> l : res) {
			System.out.println(l);
		}

	}

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

		Collections.sort(A);
		int K = 0;
		boolean is = false;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int j = 0; j < A.size(); j++) {

			
			int kk = K - A.get(j);
			

			for (int i = j + 1; i < A.size() - 1; i++) {
				temp.clear();
				temp.add(A.get(i));
				temp.add(A.get(j));
				int k = kk - A.get(i);

				temp.add(k);
				
				//System.out.println(temp);
				is = binSearch(A, i + 1, A.size() - 1, k);
				if (is) {
					list.add(temp);
				}
			}
		}

		return list;
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
