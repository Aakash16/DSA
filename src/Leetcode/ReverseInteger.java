package Leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int res = 0;
        boolean neg = x <= 0;
        while (x != 0) {
            int rem = x % 10;
            long temp = res * 10L + rem;
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            res = res * 10 + rem;
            x = x / 10;
        }
        return res;
    }
}
