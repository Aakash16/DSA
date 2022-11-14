package Recursion;

public class Recursion {

	public static void main(String[] args) {

		//printBinary(Integer.MAX_VALUE - 1);
		//System.out.println();

		printFibs(5, 0, 1, 1);
	}

	static int printBinary(int n) {

		if (n == 0)
			return n;

		int r = n % 2;
		n = n >> 1;

		printBinary(n);
		System.out.print(r + "");

		return n;
	}

	static char[] printBinary(int n, int i, char[] num) {

		if (i == 0)
			return num;

		int r = n % 2;
		num[i] = r == 1 ? '1' : '0';
		n = n >> 1;

		printBinary(n, i - 1, num);

		return num;
	}

	static void printFibs(int n, int i, int n1, int n2) {

		if (i == n)
			return;
		
		System.out.print(n1 + " ");
		
		int temp = n1;
		n1 = n1 +  n2;
		n2 = temp;

		printFibs(n, i + 1, n1, n2);

		return;
	}

}
