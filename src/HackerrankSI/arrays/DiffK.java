package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class DiffK {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);

		int lim = in.nextInt();

		for (int c = 0; c < lim; c++) {

			int len = in.nextInt();
			int K = in.nextInt();
			int[] ar = in.nextIntArray(len);

			ar = mergeSort(ar, 0, ar.length - 1);

			boolean is = false;
			for (int i = 0; i < ar.length - 1; i++) {

				int k = ar[i] + K;
				is = binSearch(ar, i + 1, ar.length - 1, k);
				if (is)
					break;
			}
			if (is)
				System.out.println("true");
			else
				System.out.println("false");

		}

	}

	private static boolean binSearch(int[] ar, int lo, int hi, int k) {

		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (ar[mid] == k) {
				return true;
			}

			if (k < ar[mid])
				return binSearch(ar, lo, mid - 1, k);
			else
				return binSearch(ar, mid + 1, hi, k);
		}

		return false;

	}

	private static int[] mergeSort(int[] ar, int lo, int hi) {

		if (lo == hi) {
			return ar;
		}

		int mid = (lo + hi) / 2;

		mergeSort(ar, lo, mid);
		mergeSort(ar, mid + 1, hi);
		merge(ar, lo, mid, hi);

		return ar;

	}

	private static int[] merge(int[] ar, int lo, int mid, int hi) {

		int[] temp = new int[hi - lo + 1];

		int idx = 0, p1 = lo, p2 = mid + 1;

		while (p1 <= mid && p2 <= hi) {

			if (ar[p1] <= ar[p2])
				temp[idx++] = ar[p1++];
			else
				temp[idx++] = ar[p2++];
		}

		while (p1 <= mid) {
			temp[idx++] = ar[p1++];
		}

		while (p2 <= hi) {
			temp[idx++] = ar[p2++];
		}

		int k = 0;
		for (int i = lo; i <= hi; i++) {
			ar[i] = temp[k++];
		}

		return ar;
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
