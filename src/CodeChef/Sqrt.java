package CodeChef;

import java.util.Scanner;

class Sqrt {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 0;
		count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			int num = sc.nextInt();

			System.out.println((int) Math.sqrt(num));

		}
		sc.close();

	}

}
