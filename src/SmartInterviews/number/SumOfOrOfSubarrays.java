package SmartInterviews.number;

public class SumOfOrOfSubarrays {
	public static void main(String[] args) {

		int[] ar = new int[] { 2, 4, 3, 1 };

		//sumOr(ar);
		getOr(ar, ar.length);
	}

	private static void sumOr(int[] ar) {

		int ans = 0;
		int n = ar.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < 32; j++) {

				if (checkbit(ar[i], j)) {

					int tp = (1 << j);
					int a = tp * (n - i);

					System.out.println("ans: " + a + " " + tp + " " + (n - i));
					ans += a;
				}
			}

		}

		System.out.println(ans);

	}

	private static int getOr(int[] a, int n) {

		int ans = 0;
		int[] idx = new int[50];
		for (int i = 1; i <= n; ++i) {
			long tmp = a[i - 1];
			for (int j = 0; j <= 31; ++j) {
				long pw = 1l << j;
				long num = tmp & pw;
				if (num == 1) {
					ans += pw * i;
					idx[j] = i;
				} else if (idx[j] == 1) {
					ans += pw * idx[j];
				}
			}
		}

		System.out.println(ans);
		return ans;
	}

	private static boolean checkbit(int n, int i) {

		return (((n >> i) & 1) == 1);

	}

}
