package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeMinSum {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4,
				-7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9,
				-10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
		System.out.println(threeSumClosest(A, -1));

	}

	public static int threeSumClosest(ArrayList<Integer> A, int B) {

		Collections.sort(A);

		System.out.println(A);
		int n = A.size();
		int ms = 0;
		int l = 0;
		for (int i = 0; i < n - 2; i++) {
			ms = A.get(i) + A.get(i + 1) + A.get(i + 2);
			System.out.println(ms);
			if (ms >= B) {
				l = i;
				break;
			}

		}

		 System.out.println(l);
		if (l < n - 3) {
			int s2 = A.get(l + 1) + A.get(l + 2) + A.get(l + 3);
			return (s2 - B) > (B - ms) ? ms : s2;
		} else {
			return ms;
		}

	}
}
