package SmartInterviews.sorting;

import java.util.Scanner;

//Am: -1 3 10 12 15 18 20 0 0 0 0 0
//Bn: -5 -2 12 25 30

//-5, -2, 12, 25, 30
public class AlreadySorted {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] ar1 = new int[] { -1, 3, 10, 12, 15, 18, 20, 0, 0, 0, 0, 0 };

		int[] ar2 = new int[] { 4, 7, 12, 25, 30 };

		int len = ar1.length - 1;

		int idx1 = ar1.length - ar2.length - 1;
		int idx2 = ar2.length - 1;

		while ((len) >= 0) {

			if (idx1 < 0) {
				while (idx2 >= 0) {
					ar1[len--] = ar2[idx2--];
				}
				break;
			}

			if (idx2 < 0) {
				while (idx1 >= 0) {
					ar1[len--] = ar1[idx1--];
				}
				break;
			}

			if (ar1[idx1] >= ar2[idx2]) {
				ar1[len--] = ar1[idx1--];
			} else {
				ar1[len--] = ar2[idx2--];
			}

			System.out.println(idx1 + " " + idx2);
		}

		for (int x : ar1) {
			System.out.print(x + " ");
		}

		sc.close();
	}

}
