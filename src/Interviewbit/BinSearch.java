package Interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class BinSearch {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		a.add(list);
		list = new ArrayList<Integer>(Arrays.asList(6, 7, 8, 9, 10));
		a.add(list);
		list = new ArrayList<Integer>(Arrays.asList(11, 12, 13, 14, 15));
		a.add(list);
		list = new ArrayList<Integer>(Arrays.asList(16, 17, 18, 19, 20));
		a.add(list);

		searchMatrix(a, 13);
	}

	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < a.size(); i++) {
			list.add(a.get(i).get(0));
		}

		int h = bins(list, b);

		if (h == -1)
			return 0;
		else {

			int d = binsearch1(a.get(h), b);

			if (d >= 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private static int binsearch1(ArrayList<Integer> list, int k) {

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (k < list.get(middle)) {
				end = middle - 1;
			}

			if (k > list.get(middle)) {
				start = middle + 1;
			}

			if (k == list.get(middle)) {
				return middle;
			}
		}
		return -1;

	}

	private static int bins(ArrayList<Integer> list, int k) {

		int start = 0;
		int end = list.size() - 1;
		int ans = -1;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (k < list.get(middle)) {
				end = middle - 1;
			}

			else {
				ans = middle;
				start = middle + 1;
			}

		}
		return ans;

	}
}
