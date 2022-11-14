package Arrays;

import java.util.Scanner;

public class MinMax {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long sum = 0;
        for (int num : arr)
            sum += num;
        int sum_arr[] = new int[arr.length];

        int min = 0, max = 0;
        for (int i = 0; i < sum_arr.length; i++) {
            sum_arr[i] = (int) (sum - arr[i]);

            if (min < sum_arr[i])
                min = sum_arr[i];

            if (max > sum_arr[i])
                max = sum_arr[i];

        }

        System.out.print(min + " " + max);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
