package HackerrankSI.numbers;

import java.util.Scanner;

class APowerB2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int c = 0; c < count; c++) {
			int b = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(pow(b, e));
		}
		sc.close();
	}

	private static long pow(int a, int N) {
		long ans = 1;
		long x = a;
		while (N != 0) {
			if ((N & 1) == 1) {
				ans = (ans * x) % 1000000007;
			}
			x = (x * x) % 1000000007;
			N = N >> 1;
		}
		return ans;
	}

}
