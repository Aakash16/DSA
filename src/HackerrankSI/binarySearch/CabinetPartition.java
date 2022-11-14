package HackerrankSI.binarySearch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class CabinetPartition {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		int tc = in.nextInt();

		for (int cc = 0; cc < tc; cc++) {

			int len = in.nextInt();
			int k = in.nextInt();
			int[] ar = in.nextIntArray(len);

			int p = partition(ar, ar.length, k);
			System.out.println(p);
		}

	}

	private static int partition(int[] a, int N, int k) {

		int lo = 0;
		int sum = Arrays.stream(a).sum();

		int hi = sum;
		int ans = sum;
		int mid = (hi + lo) / 2;

		while (lo <= hi) {

			mid = (hi + lo) / 2;

			if (isvalidPart(a, N, mid, k - 1)) {
				System.out.println("va:" + mid);

				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		return ans;
	}

	private static boolean isvalidPart(int[] a, int N, int mid, int k) {

		int sum = 0;
		int p = 0;

		while (k > 0) {

			while (p < N && sum <= mid) {
				sum += a[p++];
			}
			p--;
			System.out.println("b:" + p + " " + mid);

			sum = 0;
			k--;
		}

		while (p < N)
			sum += a[p++];

		System.out.println(sum);

		if (sum <= mid)
			return true;
		else
			return false;
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
