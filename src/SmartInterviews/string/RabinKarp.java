package SmartInterviews.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RabinKarp {

	final static int PRIME = 97;
	final static int K = (int) (1e9 + 7);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] subs = br.readLine().trim().split("\\s+");
			long count = getMatchingUsingRK(subs[1], subs[0]);
			System.out.println(count);

		}

	}

	private static long getMatchingUsingRK(String A, String B) {
		long count = 0;
		int N = A.length();
		int M = B.length();

		long[] pArr = computePowerArray(M);
		long hB = getHashOfString(B, M, pArr);

		long hA = getHashOfString(A, M, pArr);

		if (hA == hB) {
			count++;
		}

		long leadingPow = pArr[0];
		for (int i = M; i < N; i++) {

			hA = (((((((hA % K - (A.charAt(i - M) * leadingPow) % K) + K) % K) * PRIME) % K) % K)
					+ (A.charAt(i) * PRIME) % K) % K;

			if (hA == hB)
				count++;
		}

		return count;
	}

	private static long getHashOfString(String A, int len, long[] pArr) {
		long hA = 0;
		for (int i = 0; i < len; i++) {
			hA = (hA % K + (long) ((A.charAt(i) * pArr[i]) % K)) % K;
		}

		return hA;
	}

	private static long[] computePowerArray(int len) {

		long[] pArray = new long[len];
		
		pArray[len-1] = PRIME;
		for (int i = pArray.length-2; i >= 0; i--) {

			pArray[i] = (pArray[i+1] * PRIME) % K;
		}

		return pArray;

	}

}