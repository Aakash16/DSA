package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;

public class MaxSubArraySum {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		int tc = in.nextInt();
		for (int cc = 0; cc < tc; cc++) {
			int len = in.nextInt();
			int[] ar = in.nextIntArray(len);

			maxSub(ar, len);
		}

	}

	//Using DP
	private static long getMax(int[] ar, int len, int max) {
		long ans = max;
		long x = Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++) {
			x = Math.max(x, 0) + ar[i];
			ans = Math.max(x, ans);
		}
		
		return ans;
	}
	
	private static void maxSub(int[] ar) {

		int ans = Integer.MIN_VALUE;
		int len = ar.length;
		int m = len - 1, n = 0;

		int s2 = 0;
		for (int i = 0; i < ar.length; i++) {
			int sum = 0;

			for (int j = i; j < ar.length; j++) {

				sum += ar[j];

				if (ans < sum) {
					ans = sum;
					m = j;
					s2 = ans;
				}

			}

			if (s2 < ans) {
				s2 = ans;
				n++;
			}
		}

		System.out.println(ans + " " + (len - 1 - n) + " " + m);
	}
//j -i + 1
	private static void maxSub(int[] ar, int N) {

		int ans = Integer.MIN_VALUE;

		HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();

		for (int i = 0; i < N; i++) {
			int sum = 0;

			for (int j = i; j < N; j++) {

				sum += ar[j];

				if (sum > ans) {
					map.put(sum, new int[] { i, j });
					ans = sum;
				}
			}
		}

		int[] idx = map.get(ans);
		System.out.println(ans + " " + idx[0] + " " + idx[1]);
	}

	private static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}

	}
}
