package SmartInterviews.backtracking;

public class ColorBlock {

	public static void main(String[] args) {

		int[] ar = new int[20];
		int[] col = new int[] { 3, 4, 5 };

		int k = 2;

		
		func(ar, ar.length, col, col.length, k, 0, 0);
	}

	private static void func(int[] ar, int N, int[] col, int M, int k, int idx1, int idx2) {

		if (idx1 == N && idx2 == M) {

			return;
		}

		for (int i = 0; idx2 < M && i < col[idx2]; i++) {
			ar[idx1++] = idx2+1;
		}
		if (idx2 < M - 1) {

			for (int i = 0; i < k; i++) {
				ar[idx1++] = 0;
			}

			func(ar, N, col, M, k, idx1, idx2 + 1);
			func(ar, N, col, M, k+1, idx1, idx2 + 1);

		}
		while (idx1 < N) {
			ar[idx1++] = 0;
		}

		for (int i = 0; i < ar.length; i++)
			System.out.print(ar[i] + " ");

		System.out.println();
	}

}
