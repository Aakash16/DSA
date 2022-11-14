package SmartInterviews.backtracking;

import java.util.Scanner;

public class MagicSquare {

	final static int ref[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] inp = new int[9];

		for (int i = 0; i < 9; i++) {
			inp[i] = in.nextInt();
		}

		fun(ref, inp, ref.length, 0);
		System.out.println(ans);

		in.close();
	}

	/*
	 * private static void fun(final int[] arr, int[] visited, ArrayList<Integer>
	 * list, int N, int idx) {
	 * 
	 * if (idx == N) { System.out.println(list); return; }
	 * 
	 * for (int j = idx; j < N; j++) {
	 * 
	 * list.add(arr[j]); fun(arr, visited, list, N, idx + 1);
	 * list.remove(list.size() - 1); }
	 * 
	 * return; }
	 */

	private static void fun(int[] ar, int[] inp, int N, int idx) {

		if (idx == N - 1) {

			if (isMagic(ar, 15)) {
				int sum = 0;
				for (int i = 0; i < 9; i++) {
					sum += (Math.abs(ar[i] - inp[i]));
				}

				System.out.println(sum);

				if (sum < ans)
					ans = sum;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			swap(ar, i, N - 1);
			fun(ar, inp, N, idx + 1);
			swap(ar, i, N - 1);
		}

		// return ans;

	}

	private static void swap(int[] ar, int j, int k) {

		int temp = ar[j];
		ar[j] = ar[k];
		ar[k] = temp;

	}

	private static int[] rotate(int k) {
		int[] arr = new int[ref.length];
		for (int i = 0; i < ref.length; i++) {
			arr[i] = ref[(i + k) % (ref.length)];
		}
		return arr;
	}

	private static boolean isMagic(int[] a, int K) {

		if ((a[0] + a[1] + a[2] == K) && (a[3] + a[4] + a[5] == K) && (a[6] + a[7] + a[8] == K)
				&& (a[0] + a[3] + a[6] == K) && (a[1] + a[4] + a[7] == K) && (a[2] + a[5] + a[8] == K)) {
			return true;
		}

		return false;
	}
}
