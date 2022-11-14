package HackerrankSI.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LargestPalindromeHard {

	final static int PRIME = 97;
	final static int K = (int) (1e9 + 7);
	final static int N = 1000000;

	private static long[] pArray = new long[N]; // 1000000
	static {
		computePowerArray(N);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) { // T

			int len = Integer.parseInt(br.readLine());
			String A = br.readLine().trim();

			long[] fArray = fHash(A); // N
			long[] bArray = bHash(A); // N

			int ans = longestPalindromeSubString(A, fArray, bArray, len);

			out.write(ans+"\n");

		}
		out.flush();
		out.close();
		br.close();

	}

	public static boolean validFunction(int mid, String input, long fwdHash[], long bkwdHash[]) {
		int n = input.length();
		int startIndex, endIndex;
		for (int i = mid - 1; i <= n - 1; i++) {
			startIndex = i - mid + 1;
			endIndex = i;
			// System.out.println("StartIndex " + startIndex + "EndIndex "+ endIndex);
			boolean flag = (isPalind(fwdHash, bkwdHash, startIndex, endIndex));
			if (flag) { // System.out.println("StartIndex " + startIndex + "EndIndex "+ endIndex);
				return true;
			}
		}
		return false;
	}

	// binary search function to find the longest palindrome substring

	private static int longestPalindromeSubString(String input, long fwdHash[], long bkwdHash[], int len) {
		int ansEven = 1;
		int ansOdd = 1;
		int ans = 1;
		int n = input.length();
		int low = 0;
		int high = n - n % 2;

		low = 1;
		high = high / 2;
		int mid = (low + high) / 2;
		while (low <= high && mid != 0) { // && mid!=0 && mid<=high){
			// mid = low + (high-low+1)/2;// check if mid is always even
			mid = (low + high) / 2;
			// if(mid%2!=0)
			// mid = mid+1;
			if (validFunction(mid * 2, input, fwdHash, bkwdHash)) {
				ansEven = mid * 2;
				// System.out.println("Even" + ansEven + " " + mid);
				low = mid + 1;
				// System.out.println("Even LOW " + low);
			} else {
				high = mid - 1;
			}

		}
		low = 1;

		high = n - (1 - n % 2);
		while (low <= high && mid != 0) {
			mid = (low + high) / 2;// check if mid is always odd
			if (low == high && mid % 2 == 0)
				break;
			if (mid % 2 == 0)
				mid = mid + 1;
			if (validFunction(mid, input, fwdHash, bkwdHash)) {
				ansOdd = mid;
				// System.out.println("Odd" + ansOdd + " " + mid);
				low = mid + 1;
				// System.out.println("Odd LOW " + low);
			} else {
				high = mid - 1;
				// System.out.println("Odd High " + high);

			}

		}

		ans = Math.max(ansEven, ansOdd);
		return ans;
	}

	private static boolean isPalind(long[] fH, long[] bH, int i, int j) {

		boolean is = false;

		// System.out.println(A + " at " + i + " " + j);

		int N = fH.length;
		long f1 = 0, f2 = 0;

		f1 = fH[j] - (i != 0 ? fH[i - 1] : 0);
		f2 = bH[i] - (j != N - 1 ? bH[j + 1] : 0);

		// System.out.println(f1 + " " + f2);

		f1 = (f1 + K) % K;
		f2 = (f2 + K) % K;

		int p1 = i + 1;
		int p2 = N - j;

		int d = Math.abs(p1 - p2);

		long p = d > 0 ? pArray[d - 1] : 1;
		// System.out.println("pow " + p + " at " + (d - 1));
		if (p1 > p2) {

			f2 = (f2 * p) % K;
		} else {

			f1 = (f1 * p) % K;
		}

		// System.out.println("F: " + f1 + " " + f2 + " " + d);

		if (f1 == f2) {
			// System.out.println("sub ans: " + A.length());
			is = true;
		}

		// System.out.println("\n");
		return is;

	}

	private static long[] fHash(String A) {

		int Na = A.length();
		long[] fA = new long[Na];

		fA[0] = (A.charAt(0) * pArray[0]);

		for (int i = 1; i < Na; i++) {

			long p = pArray[i];
			long ele = (A.charAt(i) * p);

			// System.out.println(p + " " + ele);

			fA[i] = (fA[i - 1] + ele) % K;
		}

		return fA;

	}

	private static long[] bHash(String A) {

		int Nb = A.length();
		long[] bA = new long[Nb];

		int p_idx = Nb - 1;

		bA[p_idx] = (A.charAt(Nb - 1) * pArray[0]);

		for (int i = Nb - 2; i >= 0; i--) {
			long p = pArray[Nb - 1 - i];
			int c = A.charAt(i);
			// System.out.println("char: " + c + " " + p);
			long ele = (c * p);

			// System.out.println("ele: " + ele);

			bA[i] = (bA[i + 1] + (ele)) % K;
		}
		return bA;

	}

	private static void computePowerArray(int len) {

		pArray[0] = PRIME;
		for (int i = 1; i < N; i++) {

			pArray[i] = (pArray[i - 1] * PRIME) % K;
		}
	}

}
