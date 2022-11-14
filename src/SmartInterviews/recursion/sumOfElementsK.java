package SmartInterviews.recursion;

public class sumOfElementsK {

	public static void main(String[] args) {
		int ar[] = new int[] { 5, 10, -1, 6, -2 };
		boolean is = getSum(ar, ar.length, 14, 0, 0);
		System.out.println(is);
	}

	private static boolean getSum(int[] ar, int N, int k, int sum, int idx) {

		if(idx<N)
		System.out.println(idx + " " + sum);
		if (idx == N)
			return (sum == k);

		return getSum(ar, N, k, sum + ar[idx], idx + 1) || getSum(ar, N, k, sum, idx + 1);
	}

}
