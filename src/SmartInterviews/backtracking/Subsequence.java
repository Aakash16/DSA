package SmartInterviews.backtracking;

public class Subsequence {

	public static void main(String[] args) {

		int ar[] = new int[] { 5, 6, 4, 8, 9, 0 };

		int s = sub(ar, ar.length, 0, Integer.MIN_VALUE);
		System.out.println(s);
	}

	private static int sub(int[] ar, int N, int idx, int p) {
		if (idx == 1)
			return 1;

		return sub(ar, N, idx + 1, p) + ((ar[idx] >= p) ? sub(ar, N, idx + 1, ar[idx]) : 0);

	}

}
