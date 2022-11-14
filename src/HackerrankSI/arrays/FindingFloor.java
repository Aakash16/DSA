package HackerrankSI.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class FindingFloor {


    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);

        int len = in.nextInt();
        int[] ar1 = in.nextIntArray(len);
        int q = in.nextInt();

        int l1 = ar1.length;
        ar1 = mergeSort(ar1, 0, l1 - 1);

        // System.out.println(Arrays.toString(ar1));

        int mval = ar1[0];
        for (int i = 0; i < q; i++) {
            int k = in.nextInt();

            int min = binarySearch(ar1, k);
            // System.out.println("F: " + min);

            if (min >= 0) {
                System.out.println(ar1[min]);
            } else {
                if (k > mval)
                    System.out.println(ar1[min - 1]);
                else {
                    System.out.println(Integer.MIN_VALUE);
                }
            }
        }
    }

    public static int binarySearch(int ar[], int k) {

        int s = 0;
        int e = ar.length - 1;
        int ans = Integer.MIN_VALUE;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (k < ar[mid]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    private static int binSearch(int[] ar, int lo, int hi, int k) {

        int mid = (hi + lo) / 2;

        if (ar[mid] == k) {
            return mid;
        }

        if (ar[mid] > k) {
            return binSearch(ar, lo, mid, k);
        } else

            return binSearch(ar, mid + 1, hi, k);

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

    public static class InputReader {

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
