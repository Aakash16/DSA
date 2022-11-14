package Arrays;

public class FindMinKRotated {

    public static void main(String[] args) {

        int[] input = new int[]{7, 8, 9, 10, 11, 1, 2, 3};
        int ans = findMin(input, 0, input.length - 1, input.length);
        System.out.println(ans);
    }

    private static int findMin(int[] ar, int lo, int hi, int N) {

        int mid = lo + (lo + hi) / 2;
        if (mid >= 0 && mid < N)
           if (ar[mid] < ar[mid - 1] || ar[mid] > ar[mid + 1])
                return ar[mid];

        findMin(ar, lo, mid - 1, N);
        findMin(ar, mid + 1, hi, N);
        return ar[mid];
    }

}
