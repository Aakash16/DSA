package HackerrankSI.arrays;

import java.util.Scanner;

public class SubsetSum2 {

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

			boolean is = isSum(ar, size, N, 0, 0);
			System.out.println(is);

		}

		sc.close();
	}

	private static boolean isSum(int ar[], int N, int K, int s, int idx) {
		if (idx == (N-1)) {
			return s == K;
		}

		return (isSum(ar, N, K, s + ar[idx], idx+1) || isSum(ar, N, K, s, idx+1));
	}
}
