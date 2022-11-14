package HackerrankSI.numbers;

import java.util.Scanner;

public class PowerOfTwo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			long num = sc.nextLong();

			int c = 0;
			while (num >= 1) {

				int n = (int) num % 2;
				c += n;
				num = num >> 1;
			}

			if (c == 1) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}

		}
		sc.close();

	}
}
