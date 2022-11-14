package SmartInterviews.sorting;

public class BinSearch {

	public static void main(String[] args) {

		int[] ar = new int[] { 1, 2};

		
		//System.out.println(binSearch(ar, 0, ar.length - 1, 0));
	}

	private static boolean binSearch(int[] ar, int lo, int hi, int k) {

		if (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (ar[mid] == k) {
				return true;
			}

			if (k < ar[mid])
				return binSearch(ar, lo, mid, k);

			return binSearch(ar, mid + 1, hi, k);
		}

		return false;

	}
}
