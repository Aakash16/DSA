package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class DiffK2 {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);

		int lim = in.nextInt();

		for (int c = 0; c < lim; c++) {

			int len = in.nextInt();
			int K = in.nextInt();
			int[] ar = in.nextIntArray(len);

			int cc = countPairsWithDiffK(ar,ar.length,K);
			System.out.println(cc);
		}

	}

	// Standard binary search function // 
    static int binarySearch(int arr[], int low,  
                               int high, int x) 
    { 
        if (high >= low)  
        { 
            int mid = low + (high - low) / 2; 
            if (x == arr[mid]) 
                return mid; 
            if (x > arr[mid]) 
                return binarySearch(arr, (mid + 1), 
                                          high, x); 
            else
                return binarySearch(arr, low,  
                                    (mid - 1), x); 
        }
        return -1; 
    } 
  
    // Returns count of pairs with  
    // difference k in arr[] of size n.  
    static int countPairsWithDiffK(int arr[], int n, int k) 
    { 
        int count = 0, i; 
          
        // Sort array elements 
        Arrays.sort(arr); 
  
        // code to remove duplicates from arr[]  
  
        // Pick a first element point 
        for (i = 0; i < n - 1; i++) 
            if (binarySearch(arr, i + 1, n - 1, 
                             arr[i] + k) != -1) 
                count++; 
  
        return count; 
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
