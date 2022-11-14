package BinarySearch;

public class BinarySerach {

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        int k = binsearch(a, 2);
        System.out.println("k:" + k);
    }


    private static int binsearch(int[] ar, int k) {

        int start = 0;
        int end = ar.length - 1;
        int ans = Integer.MIN_VALUE;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (k > ar[middle]) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }
        return ans;
    }
}
