package Interviewbit.math;

public class ExcelColumn {

	public static void main(String[] args) {

		System.out.println(titleToNumber("AAA"));
	}

	public static int titleToNumber(String A) {

		int val = 0;

		int len = (A.length() - 1);
		for (int i = 1; i <= len; i++) {
			val += Math.pow(26, i);
		}

		val += (A.charAt(A.length() - 1) - 'A');

		return val + 1;

	}

}
