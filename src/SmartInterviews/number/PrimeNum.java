package SmartInterviews.number;

import java.util.Arrays;

public class PrimeNum {

	public static void main(String[] args) {

		primeUptoN(30);
		//primeUptoN2(100);
	}

	private static boolean isPrime(long N) {

		boolean isPr = true;
		if (N < 0 || N == 1) {
			return false;
		}

		long sqr = (long) Math.sqrt(N);
		for (int i = 2; i < sqr; i++) {
			if (N % i == 0) {
				isPr = false;
				break;
			}
		}

		return isPr;
	}

	private static void primeUptoN(int N) {

		boolean[] vis = new boolean[(int) (N + 1)];
		Arrays.fill(vis, true);
		vis[0] = false;
		vis[1] = false;

		int c = 0;
		int sqr = (int) Math.ceil(Math.sqrt(N));

		for (int i = 2; i < sqr; i++) {

			if (vis[i]) {

				int j = 2;
				while (j * i <= N) {
					vis[i * j] = false;
					j++;
				}

			}
		}

		for (int i = 2; i < N + 1 ; i++) {
			if (vis[i])
				System.out.println(i);
		}


	}

	private static void primeUptoN2(int N) {
		boolean[] vis = new boolean[(int) (N + 1)];
		Arrays.fill(vis, true);
		vis[0] = false;
		vis[1] = false;

		int c = 0;
		int sqr = (int) Math.ceil(Math.sqrt(N));

		for (int i = 2; i <= sqr; i++) {
			if (vis[i]) {
				for (int j = i * i; j <= sqr; j += i) {
					vis[j] = false;
				}
			}
		}
		
		for (int i = 1; i < N + 1 ; i++) {
			if (vis[i])
				c++;
		}

		System.out.println(c);
	}

}
