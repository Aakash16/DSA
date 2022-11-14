package SmartInterviews.sorting;

import java.util.Scanner;

//Am: -1 3 10 12 15 18 20 0 0 0 0 0
//Bn: -5 -2 12 25 30

//-5, -2, 12, 25, 30
public class AlreadySorted2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] ar1 = new int[] { -1, 3, 10, 12, 15, 18, 20 };

		int[] ar2 = new int[] { 4, 7, 12, 25, 30 };

		int idx1 = 0;
		int idx2 = 0;

		while (idx1 < ar1.length && idx2 < ar2.length) {

			if (ar1[idx1] < ar2[idx2]) {
				System.out.println(ar1[idx1++]);
			} else {
				System.out.println(ar2[idx2++]);
			}

		}

		while (idx1 < ar1.length) {
			System.out.println(ar1[idx1++]);
		}

		while (idx2 < ar2.length) {
			System.out.println(ar2[idx2++]);
		}

		sc.close();
	}

}
