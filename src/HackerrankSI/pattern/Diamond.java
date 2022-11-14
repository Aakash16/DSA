package HackerrankSI.pattern;

import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int i = 0; i < count; i++) {
			int n = sc.nextInt();
			diagonalP(n);
		}
		sc.close();
	}

	private static void diagonalP(int n) {
		// n = 1 + 2*(k),

		char[] ar = new char[n];
		int mid = n / 2;

		int p1 = mid, p2 = mid;
		boolean rev = false;
		for (int i = 0; i < n; i++) {

			
				ar[p1] = '*';
				ar[p2] = '*';

				System.out.println(String.valueOf(ar).replaceFirst("\\s++$", ""));

				ar[p1] = ' ';
				ar[p2] = ' ';

				
				
				if (p1 == 0 && p2 == n-1) {
					rev = true;
				}
				if(p2 == 0 && p1 == n-1) {
					rev = false;
				}
				
				if(rev) {
					p1++;
					p2--;
				}else {
					p1--;
					p2++;
				}
			
		}

	}
	
	private static void diagnol2(int n, int i) {
		n = n / 2 + 1;

		System.out.println("Case #" + (i + 1) + ":");
		for (int j = 0; j < n; j++) {

			for (int k = 0; k < n - j - 1; k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int l = 0; l < 2 * j - 1; l++) {
				System.out.print(" ");
			}

			if (j > 0)
				System.out.println("*");
			else
				System.out.println("");

		}
		for (int j = 0; j < n - 1; j++) {

			for (int k = 0; k <= j; k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int l = 0; l < 2 * (n - j) - 5; l++) {
				System.out.print(" ");
			}

			if (j < n - 2)
				System.out.println("*");
			else
				System.out.println("");
		}
	}
}