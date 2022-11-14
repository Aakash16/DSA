package SmartInterviews.backtracking;

import java.util.Arrays;

public class WorkerTask {

	public static void main(String[] args) {

		//int[] a = new int[] { 5, 3, 10, 2, 7, 4, 8, 1, 3, 5, 8, 1 };
		 int[] a = new int[] { 1, 10, 13, 4, 5, 12, 23, 12, 18, 8 };

		int k = 3;
		System.out.println(fun(a, a.length, k));

	}

	private static int fun(int[] a, int N, int k) {

		int lo = 0;
		int sum = Arrays.stream(a).sum();

		int hi = sum;
		int ans = sum;
		int mid = (hi + lo) / 2;

		while (lo <= hi) {

			mid = (hi + lo) / 2;
			
			if (isvalidPart(a, N, mid, k - 1)) {
				System.out.println("va:" + mid);

				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return ans;
	}

	private static boolean isvalidPart(int[] a, int N, int mid, int k) {

		int sum = 0;
		int p = 0;

		
		while (k > 0) {

			while (p < N && sum <= mid) {
				sum += a[p++];
			}
			p--;
			System.out.println("b:" + p+" " +mid );

			sum = 0;
			k--;
		}

		while (p < N)
			sum += a[p++];

		System.out.println(sum);

		if (sum <= mid)
			return true;
		else
			return false;
	}
}
