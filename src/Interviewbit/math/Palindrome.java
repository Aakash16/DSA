package Interviewbit.math;

public class Palindrome {

	public static void main(String[] args) {

		System.out.println(isPalindrome(2147447412));
	}

	public static int isPalindrome(int A) {

		int sum = 0;
		int s = A;
		while (A > 0) {

			sum = (sum * 10) + A % 10;
			A /= 10;
		}

		if (sum == s)
			System.out.println("True");
		else
			System.out.println("False");
		return sum;
	}

}
