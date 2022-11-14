package Interviewbit.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {

		ArrayList<Integer> list = intersect(
				new ArrayList<Integer>(Arrays.asList(1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33,
						35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63,
						64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98,
						98, 100, 101)),
				new ArrayList<Integer>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69,
						70, 78, 82, 94, 94, 98)));
		System.out.println(list);
	}

	public static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {

		int p1 = 0, p2 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (p1 < A.size() && p2 < B.size()) {
			if (A.get(p1) > B.get(p2)) {
				p2++;
			} else if (A.get(p1) < B.get(p2)) {
				p1++;
			} else if (A.get(p1) == B.get(p2)) {
				list.add(A.get(p1));
				p1++;
				p2++;
			}
		}

		while (p1 < A.size()) {
			if (B.get(p2 - 1) == A.get(p1)) {
				list.add(B.get(p2-1));
				break;
			}
			p1++;
		}

		while (p2 < B.size()) {
			if (B.get(p2) == A.get(p1 - 1)) {
				list.add(A.get(p1-1));
				break;
			}
			p2++;
		}
		return list;
	}
}
