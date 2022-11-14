package SmartInterviews.sorting;

import java.util.Scanner;

public class BinarySort {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();
		int[] ar = new int[len];

		for (int i = 0; i < len; i++) {
			ar[i] = sc.nextInt();
		}

		int p1 = 0;
		int p2 = len - 1;

		while (p1 < p2) {

			while (p1 < len && ar[p1] == 0) {
				p1++;
			}

			while (p2 >= 0 && ar[p2] == 1) {
				p2--;
			}

			if (p1 < p2) {
				int temp = ar[p1];
				ar[p1] = ar[p2];
				ar[p2] = temp;

			}
			p1++;
			p2--;

		}

		for (int i : ar) {
			System.out.print(i);
		}

		sc.close();
	}

}
