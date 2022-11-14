package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.InputMismatchException;

public class FindFrequency {
	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);

		int num = in.nextInt();
		int[] ar = in.nextIntArray(num);
		int l = in.nextInt();
		int[] qr = in.nextIntArray(l);

		findFreq3(ar, qr);
	}

	private static void findFreq3(int[] ar, int[] qr) {

		ar = mergeSort(ar, 0, ar.length - 1);
		int[] ac = compress(ar);
		int[] fr = getFreqAr(ar, ac);

		System.out.println(Arrays.toString(ac));
		System.out.println(Arrays.toString(fr));
		for (int i = 0; i < qr.length; i++) {

			int j = binsearch1(ac, qr[i]);

			if (j >= 0)
				System.out.println(fr[j]);
			else
				System.out.println(0);
		}
	}

	
	
	private static void findFreq2(int[] ar, int[] qr) {

		ar = mergeSort(ar, 0, ar.length - 1);

		for (int i = 0; i < qr.length; i++) {
			int g = binsearch1(ar, qr[i]);
			int k = binsearch2(ar, qr[i]);
			System.out.println(k - g + 1);
		}
	}

	private static int[] getFreqAr(int[] ar, int[] cr) {

		int[] fr = new int[cr.length];
		int j = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == cr[j]) {
				fr[j]++;
			} else {

				j++;
				fr[j]++;

			}
		}

		return fr;

	}

	private static int[] compress(int[] ar) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (i < ar.length) {
			if (i == 0) {
				list.add(ar[i]);
				i++;
			} else {

				if (ar[i] != list.get(list.size() - 1)) {
					list.add(ar[i]);
				}
				i++;
			}
		}

		int[] temp = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			temp[k] = list.get(k);
		}

		return temp;
	}

	private static int binsearch2(int[] ar, int k) {

		int start = 0;
		int end = ar.length - 1;
		int ans = Integer.MIN_VALUE;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (k < ar[middle]) {
				end = middle - 1;
			}

			else {
				ans = middle;
				start = middle + 1;
			}

		}
		return ans;

	}

	private static int binsearch1(int[] ar, int k) {

		int start = 0;
		int end = ar.length - 1;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (k < ar[middle]) {
				end = middle - 1;
			}

			if (k > ar[middle]) {
				start = middle + 1;
			}

			if (k == ar[middle]) {
				return middle;
			}
		}
		return -1;

	}

	private static void findFreqHash(int[] ar, int[] qr) {

		Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			int num = ar[i];

			if (h.get(num) == null) {
				h.put(num, 1);
			} else {

				h.put(num, h.get(num) + 1);
			}

		}

		for (int j = 0; j < qr.length; j++) {
			int n = qr[j];

			if (h.get(n) == null)
				System.out.println("0");
			else
				System.out.println(h.get(n));
		}
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
