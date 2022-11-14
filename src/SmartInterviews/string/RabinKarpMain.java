package SmartInterviews.string;

import java.util.Arrays;

public class RabinKarpMain {

	private static int MOD = (int) (1e9 + 7);
	private static int P = 7;

	public static void main(String[] args) {

		String A = "abqueuexyz";
		String B = "queue";

		getMatch(A, B);
	}

	private static boolean getMatch(String A, String B) {

		boolean isMatch = false;
		int N = A.length();
		int M = B.length();

		// long[] pArr = computePowerArray(M, P);

		long hB = getHashArray(B, M);

		System.out.println("HB:" + hB);

		long hA = getHashArray(A, M);

		// long hA = (A.charAt(0) * pArr[0]) % MOD;

		long[] hArr = new long[N-M+1];

		hArr[0] = hA;

		/*
		 * for (int i = 0; i < M - 1; i++) { hArr[i + 1] = (((((hA * P) % MOD -
		 * (A.charAt(i) * pArr[i] * P) % MOD) + MOD) % MOD) + (A.charAt(i + 1) * pArr[i
		 * + 1])) % MOD; }
		 */
		
		

		long p5 = (long) (Math.pow(P, M) % MOD);
		int c = 1;
		for (int i = M; i < N; i++) {

			
			hArr[c] = ((((hArr[c] * P) % MOD - (A.charAt(i - M) * p5 * P)%MOD) + MOD) % MOD + ((A.charAt(i) * P) % MOD))%MOD;

			System.out.println(hArr[c]);
			c++;
		}

		System.out.println(Arrays.toString(hArr));

		return isMatch;

	}

	private static long[] computePowerArray(int len, int prime) {

		long[] pArray = new long[len];
		pArray[pArray.length - 1] = 1;

		for (int i = pArray.length - 2; i >= 0; i--) {

			int idx = i + 1;
			pArray[i] = (pArray[idx] * prime) % MOD;
		}

		return pArray;

	}

	private static long getHashArray(String A, int N) {

		long hA = (long) ((A.charAt(0) * Math.pow(P, N)) % MOD);

		for (int i = 1; i < N; i++) {
			long p = (long) (Math.pow(P, N - i) % MOD);
			hA = (hA % MOD + (A.charAt(i) * p) % MOD) % MOD;
		}

		return hA;
	}
}
