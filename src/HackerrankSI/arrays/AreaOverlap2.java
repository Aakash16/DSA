package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class AreaOverlap2 {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		int tc = in.nextInt();

		for (int cc = 0; cc < tc; cc++) {

			int x11 = in.nextInt();
			int y11 = in.nextInt();
			Point p1 = new Point(x11, y11);

			int x12 = in.nextInt();
			int y12 = in.nextInt();
			Point p2 = new Point(x12, y12);

			int x21 = in.nextInt();
			int y21 = in.nextInt();
			Point p3 = new Point(x21, y21);

			int x22 = in.nextInt();
			int y22 = in.nextInt();
			Point p4 = new Point(x22, y22);

			System.out.println(overlappingArea(p1, p2, p3, p4));
		}

	}

	private static long overlappingArea(Point l1, Point r1, Point l2, Point r2) {
		long area1 = Math.abs(l1.getX() - r1.getX()) * Math.abs(l1.getY() - r1.getY());

		long area2 = Math.abs(l2.getX() - r2.getX()) * Math.abs(l2.getY() - r2.getY());

		if (r2.getX() <= l1.getX() || r1.getX() <= l2.getX() || l1.getY() >= r2.getY() || l2.getY() >= r1.getY()) {
			return area1 + area2;
		}

		long areaI = (min(r1.getX(), r2.getX()) - max(l1.getX(), l2.getX()))
				* (min(r1.getY(), r2.getY()) - max(l1.getY(), l2.getY()));

		return (area1 + area2 - areaI);

	}

	private static int min(int x, int y) {
		return x < y ? x : y;
	}

	private static int max(int x, int y) {
		return x > y ? x : y;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

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
