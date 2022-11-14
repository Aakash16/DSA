package Interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class AbsDiff {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList( 55, -8, 43, 52, 8, 59, -91, -79, -18, -94));
		System.out.println(maxArr(a));
	}

	public static int maxArr(ArrayList<Integer> A) {

		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int c = 1;
		for (Integer a : A) {
			tm.put(a, c++);
		}

		int x = (int) tm.firstKey();
		int y = (int) tm.lastKey();

		int i = tm.firstEntry().getValue();
		int j = tm.lastEntry().getValue();

		System.out.println(x + " " + y + " " + i + " " + j);
		int dif1 = Math.abs(j - i);
		int dif2 = Math.abs(y - x);
		if (dif1 == 0 && dif2 == 0) {
			dif2 = c - 1;
		}
		return (dif1 + dif2);
	}
}
