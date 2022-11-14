package HackerrankSI.arrays;

import java.util.Scanner;

public class SubsetSumBF {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();
			int N = sc.nextInt();

			int[] ar = new int[size];
			for (int j = 0; j < size; j++) {
				ar[j] = sc.nextInt();
			}
			boolean isFound = false;
			long sum = 0;
			for (int j = 0; j < (1 << size); j++) {
				sum = 0;

				for (int k = 0; k < size; k++) {
					if (((j >> k) % 2) == 1) {
						sum += ar[k];
					}
				}
				if (sum == N) {
					isFound = true;
				}

			}

			if (isFound) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

		sc.close();
	}

}
