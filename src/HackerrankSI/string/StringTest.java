package HackerrankSI.string;

import java.util.Arrays;

public class StringTest {
	
	final static int PRIME = 1;
	final static int K = (int) (1e9 + 7);
	final static int N = 23;

	private static long[] pArray = new long[N]; // 1000000
	static {
		computePowerArray(N);
	}
	
	public static void main(String[] args) {
		
		String A = "mzmqnnrkurfmmfrukrnnqsm";
		long[] fH = fHash(A);
		System.out.println(Arrays.toString(fH));
		diff(fH);
		
	}
	
	private static void diff(long[] A) {
		for(int i=1;i<A.length;i++) {
			System.out.println(A[i] - A[i-1]);
		}
	}

	
	private static long[] fHash(String A) {

		int Na = A.length();
		long[] fA = new long[Na];

		int p_idx = N - 1;
		fA[0] = (A.charAt(0) * pArray[p_idx]);

		for (int i = 1; i < Na; i++) {

			long p = pArray[p_idx--];
			long ele = (A.charAt(i) * p);

			//System.out.println(p + " " + ele);

			fA[i] = (fA[i - 1] % K + ele % K) % K;
		}

		return fA;

	}
	
	private static void computePowerArray(int len) {

		pArray[len - 1] = PRIME;
		for (int i = pArray.length - 2; i >= 0; i--) {

			pArray[i] = (pArray[i + 1] % K * (PRIME % K)) % K;
		}
	}
}
