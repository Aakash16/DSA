package Interviewbit.arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {

		ArrayList<Integer> res = plusOne(new ArrayList<Integer>(Arrays.asList(0)));
		System.out.println(res.toString());

	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		while (A.get(0) == 0 && A.size() > 1) {
			A.remove(0);
		}
		int index = A.size() - 1;

		while (A.get(index) + 1 == 10) {
			int r = A.get(index);
			r++;

			if (r == 10) {
				A.set(index--, 0);
			} else {
				A.set(index--, r);
			}

			if (index < 0) {
				break;
			}
		}

		if (index < 0) {
			A.add(0, 1);

		} else {
			A.set(index, A.get(index) + 1);
		}
		return A;
	}

}
