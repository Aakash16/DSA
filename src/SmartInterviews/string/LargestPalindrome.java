package SmartInterviews.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPalindrome {

	public static long[] powerFunction(int n) {
		long pwr[] = new long[n + 1];
		pwr[0] = 1;
		int modulo = (int) Math.pow(10, 9) + 7;
		int p = 103;
		for (int i = 1; i <= n; i++) {
			pwr[i] = (pwr[i - 1] % modulo * p % modulo) % modulo;
		}

		return pwr;
	}

	// cumulative fwd Hash
	public static long[] forwardHash(long pwr[], String input) {
		long fwdHash[] = new long[input.length()];
		int modulo = (int) Math.pow(10, 9) + 7;
		fwdHash[0] = input.charAt(0) * pwr[1];
		for (int i = 1; i < input.length(); i++) {
			fwdHash[i] = (fwdHash[i - 1] % modulo + ((long) input.charAt(i) % modulo * pwr[i + 1] % modulo) % modulo)
					% modulo;
		}
		return fwdHash;
	}

	// cumulative backwardHash
	public static long[] backwardHash(long pwr[], String input) {
		long bkwdHash[] = new long[input.length()];
		int modulo = (int) Math.pow(10, 9) + 7;
		int n = input.length();
		bkwdHash[n - 1] = input.charAt(n - 1) * pwr[1];
		for (int i = n - 2; i >= 0; i--) {
			bkwdHash[i] = (bkwdHash[i + 1] % modulo + ((long) input.charAt(i) % modulo * pwr[n - i] % modulo) % modulo)
					% modulo;
		}
		return bkwdHash;
	}

	// valid function to check palindrome using the concept of hashing in string
	// matching original and reverse
	// fwdhash of required substring(f) = bkwdhash pf required substring(b)
	// f = fwdHash(end)-fwdHash(start-1)
	// b = bkwdHash(start)-bkwdHash(end+1)
	// diff = abs((n - end)-(start +1))
	// to adjust the powers = if( (start+1) < (n -end))
	// f= f*pwr[d]
	// else b = b*pwr[d]
	public static boolean checkPalindrome(int startIndex, int endIndex, long fwdHash[], long bkwdHash[], long pwr[],
			String input) {
		long f, b;
		int diff;
		int n = input.length();
		int modulo = (int) Math.pow(10, 9) + 7;
		if (startIndex == 0) {
			f = fwdHash[endIndex];
		} else
			f = (fwdHash[endIndex] - fwdHash[startIndex - 1] + modulo) % modulo;

		if (endIndex == n - 1)
			b = bkwdHash[startIndex];
		else
			b = ((bkwdHash[startIndex] - bkwdHash[endIndex + 1]) + modulo) % modulo;

		diff = Math.abs((n - endIndex) - (startIndex + 1));
		if ((startIndex + 1) < (n - endIndex))
			f = (f % modulo * pwr[diff] % modulo) % modulo;
		else
			b = (b % modulo * pwr[diff] % modulo) % modulo;

		if (f == b)
			return true;
		else
			return false;
	}

	// valid function to check whether strings of length mid are palindrome or not
	public static boolean validFunction(int mid, String input, long fwdHash[], long bkwdHash[], long pwr[]) {
		int n = input.length();
		int startIndex, endIndex;
		for (int i = mid - 1; i <= n - 1; i++) {
			startIndex = i - mid + 1;
			endIndex = i;
			// System.out.println("StartIndex " + startIndex + "EndIndex "+ endIndex);
			boolean flag = (checkPalindrome(startIndex, endIndex, fwdHash, bkwdHash, pwr, input));
			if (flag) { // System.out.println("StartIndex " + startIndex + "EndIndex "+ endIndex);
				return true;
			}
		}
		return false;
	}

	// binary search function to find the longest palindrome substring

	public static int longestPalindromeSubString(String input) {
		int ansEven = 1;
		int ansOdd = 1;
		int ans = 1;
		int n = input.length();
		long pwr[] = powerFunction(n);
		long fwdHash[] = forwardHash(pwr, input);
		long bkwdHash[] = backwardHash(pwr, input);
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
			if (validFunction(mid * 2, input, fwdHash, bkwdHash, pwr)) {
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
			if (validFunction(mid, input, fwdHash, bkwdHash, pwr)) {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numTestCases = Integer.parseInt(br.readLine());
		while (numTestCases > 0) {
			int length = Integer.parseInt(br.readLine());
			String input = br.readLine();
			int lenPalindrome = longestPalindromeSubString(input);
			System.out.println(lenPalindrome);
			numTestCases--;
		}
	}
}
