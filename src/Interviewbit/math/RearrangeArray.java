package Interviewbit.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RearrangeArray {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
		//arrange(list);
		System.out.println(findx(list, 1));
	}

	public static void arrange(ArrayList<Integer> a) {

		Collections.sort(a);

		boolean last = false;
		int n = -1;
		// System.out.println(findx(a, 1));
		for (int i = 0; i < a.size() - 1; i++) {

			int num = a.get(i);
			int h = findx(a, num);

			if (h != n) {
				a.set(h, num);
				n = h;
			} else {
				a.set(i, 0);
			}

		}

	}

	private static int findx(ArrayList<Integer> a, int k) {

		int lo = 0;
		int hi = a.size() - 1;
		int mid = (hi + lo) / 2;
		int ans = 0;

		while (lo < hi) {

			mid = (hi + lo) / 2;
			
			if(a.get(mid) == k)
				ans = mid;

			if (a.get(mid) < k) {
				
				lo = mid + 1;
			} 
			else {
				
				hi = mid - 1;
			}
		}

		return ans;
	}
}
