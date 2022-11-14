package Hackerrank;

import java.util.Arrays;

public class ThreeDSurface {

	public static void main(String[] args) {

		//int[][] A = new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } };
		int[][]A = new int[][] {{12,89,20,37,15,43,8,31,52,72,45,82,100,99,12,90,29,43,78,80,92,9,39,28,97,23,72,53,72,78,22,26,39,57,52,57,89,80,97,83,77,6,88,26,34,92,6,59,49,68,56,44,73,54,54,70,14,10,57,72,97,4,85,70,94,2,100,83,79,38,1,68,38,22,90,39,79,54,35,53,23,49,49,88,34,60,56,86,18,18,9,36,38,46,60,87,68,81,15,38}};
		int w = A.length;
		int l = A[0].length;

		System.out.println(w+" " + l);
		int min = min(A);
		int max = max(A);
		int surf = 0;

		int hc = 0;
		while (!getEmptyRowCol(A) && max-- > 0) {

			min = min(A);

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < l; j++) {

					if (A[i][j] >= min)
						A[i][j] -= min;
				}
			}

			hc++;
			print(A);

		}

		surf += (w * l + l * hc + w * hc) * 2;

		System.out.println("1: " + surf);

		while (max-- > 0) {
			for (int i = 0; i < w; i++) {
				int mz = midZeros(A[i]);

				boolean em = getEmptyRowCol(A[i]);
				if (!em)
					surf += 2 * (1 + mz);

			}

			System.out.println(max + ":1:" + surf);
			for (int i = 0; i < l; i++) {
				int mz = midZeros(A, i);

				boolean em = getEmptyRowCol(A, i);
				if (!em)
					surf += 2 * (1 + mz);

			}

			System.out.println(max + ":2:" + surf);

			min = min(A);
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < l; j++) {

					if (A[i][j] >= min)
						A[i][j] -= min;
				}
			}

			print(A);

		}

		// System.out.println(surf);

	}

	private static int midZeros(int[] A) {

		int c = 0;
		boolean f1 = false, f2 = false;
		int i1 = 0, i2 = 0;

		System.out.print(Arrays.toString(A) + " c:" + c + " ");
		for (int i = 0; i < A.length; i++) {

			if (!f1 && A[i] > 0) {
				f1 = true;
				i1 = i;
			}

			if (!f2 && A[A.length - 1 - i] > 0) {
				f2 = true;
				i2 = A.length - 1 - i;
			}

		}

		if (i1 < i2)
			for (int i = i1; i <= i2; i++) {
				if (A[i] == 0)
					c++;
			}

		System.out.print(i1 + " " + i2);
		System.out.println("zrc:" + c);

		return c;

	}

	private static int midZeros(int[][] A, int j) {

		int c = 0;
		boolean f1 = false, f2 = false;
		int i1 = 0, i2 = 0;

		System.out.print("A: ");
		for (int i = 0; i < A.length; i++) {

			System.out.print(A[i][j] + " ");

			if (!f1 && A[i][j] > 0) {
				f1 = true;
				i1 = i;
			}

			if (!f2 && A[A.length - 1 - i][j] > 0) {
				f2 = true;
				i2 = A.length - 1 - i;
			}

		}

		System.out.print(i1 + " " + i2);
		if (i1 < i2)
			for (int i = i1; i <= i2; i++) {
				if (A[i][j] == 0)

					c++;
			}

		System.out.println("zrc:" + c);

		return c;

	}

	private static boolean getEmptyRowCol(int[][] A, int j) {

		int c = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i][j] == 0)
				c++;

		}

		if (c == 3)
			return true;
		else
			return false;

	}

	private static boolean getEmptyRowCol(int[] A) {

		int c = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] == 0)
				c++;

		}

		if (c == 3)
			return true;
		else
			return false;

	}

	private static boolean getEmptyRowCol(int[][] A) {

		int w = A.length;
		int l = A[0].length;

		for (int i = 0; i < w; i++) {

			int row = 0, col = 0;
			for (int j = 0; j < l; j++) {

				
				if (i<row && j<col && A[i][j] == 0)
					row++;

				if (j<row && i<col && A[j][i] == 0)
					col++;

			}

			if (row == w || col == l)
				return true;
		}

		return false;

	}

	private static int min(int[][] A) {

		int w = A.length;
		int l = A[0].length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < l; j++) {
				if (A[i][j] > 0 && A[i][j] < min) {
					min = A[i][j];
				}
			}
		}

		return min;
	}

	private static int max(int[][] A) {

		int w = A.length;
		int l = A[0].length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < l; j++) {
				if (A[i][j] > max) {
					max = A[i][j];
				}
			}
		}

		return max;
	}

	private static void print(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("");
	}

}
