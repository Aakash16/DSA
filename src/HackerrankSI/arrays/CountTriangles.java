package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class CountTriangles {

	public static void main(String[] args) {

		/*InputReader in = new InputReader(System.in);
		int tc = in.nextInt();
		for (int cc = 0; cc < tc; cc++) {
			int len = in.nextInt();
			int[] ar = in.nextIntArray(len);

			Arrays.sort(ar);
			//int s = getTriangles(ar);
			
			System.out.println(s);

		}
*/
		int[] ar = new int[] {4, 6, 13, 16, 20, 3, 1, 12};
		
		int s = getTriangles(ar);
		System.out.println(s);
		
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList( 4, 6, 13, 16, 20, 3, 1, 12));
		 s = getTriangles(list);
		System.out.println(s);
	}

	private static int getTriangles(int[] ar) {
		int n = ar.length;
		int sum = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int k = j + 1;
				while (k < n && ar[i] + ar[j] > ar[k]) {
					sum++;
					k++;
				}
			}
		}

		return sum;
	}

	private static int getTriangles(ArrayList<Integer> list) {
		Collections.sort(list);
		int n = list.size();
		int sum = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				int k = j + 1;
				while (k < n && (list.get(i) + list.get(j) > list.get(k))) {
					sum++;
					sum %= 1000000007;
					k++;
				}
			}
		}

		return sum;
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

	private static int getriangles(int[] ar, int N, int idx, int sum, int[] tri) {

		if (idx == N - 1) {
			return sum;
		}

		tri[0] = ar[idx];
		int g = 0;

		for (int i = idx + 1; i < N; i++) {

			tri[1] = ar[i];
			int j = i + 1;
			while (j < N) {

				tri[2] = ar[j];

				System.out.println("T: " + Arrays.toString(tri));

				System.out.println(g + " " + tri[2]);
				if (g != tri[2]) {
					if (isValidtri(tri)) {
						sum++;
					}

				}
				g = tri[2];
				j++;

			}

		}

		System.out.println("---end---");
		return getriangles(ar, N, idx + 1, sum, tri);

	}

	private static boolean isDup(int[] a, int[] b) {

		if (a == null || b == null)
			return false;

		if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
			return true;
		} else
			return false;
	}

	private static boolean isValidtri(int[] a) {

		if (a[0] + a[1] >= a[2] && a[0] + a[2] >= a[1] && a[1] + a[2] >= a[0]) {
			return true;
		} else
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
