package SmartInterviews.carryfwd;

import java.util.Arrays;

public class FirstMissingNum {

	public static void main(String[] args) {
		int[] ar = new int[] { 5, 1, 3, 2, 8, 1, -6, 15, 10, -4 };
		System.out.println(Arrays.toString(ar));
		getMissing(ar);
	}

	private static int getMissing(int[] A) {

		int ans = 0;
		int K = 100;
		int N = A.length;
		for (int i = 0; i < N; i++) {
			if (A[i] <= 0 || A[i] > N) {
				A[i] = K;
			}
		}
		System.out.println(Arrays.toString(A));
		
		for (int i = 0; i < N; i++) {
			if(A[i] > 0 && A[i]<(N+1)) {
				int idx = A[i];
				A[idx-1] *= -1;
			}
			
			if(A[i]<0) {
				int idx = A[i] * -1;
				
				if(idx<K)
				A[idx-1] = -A[idx-1];
			}
			
		}

		System.out.println(Arrays.toString(A));
		/*for(int i=0;i<N;i++) {
			if(A[i]<0) {
				int idx = A[i] * -1;
				A[idx-1] = -A[idx-1];
			}
		}*/
		
		for (int i = 0; i < N; i++) {
			if(A[i]>0 && A[i]<K) {
				ans = A[i];
			}
		}
		
		System.out.println("ans: " + ans);
		return ans;
	}
}
