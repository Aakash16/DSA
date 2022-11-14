package HackerrankSI.numbers;

import java.math.BigInteger;
import java.util.Scanner;

class APowerB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int c = 0; c < count; c++) {
			int b = sc.nextInt();
			int e = sc.nextInt();
			pow(b, e);
		}
		sc.close();
	}

	static void pow(int x, int n) {

		if (n == 0) {
			System.out.print("1");
			return;
		}
		int res[] = new int[100000];
		int res_s = 0;
		int temp = x;

		while (temp != 0) {
			res[res_s++] = temp % 10;
			temp = temp / 10;
		}
		for (int i = 2; i <= n; i++) {
			res_s = mult(x, res, res_s);
		}
		StringBuilder sb = new StringBuilder();
		for (int j = res_s - 1; j >= 0; j--)
			sb.append(res[j]);

		BigInteger b = new BigInteger(sb.toString()).mod(new BigInteger("1000000007"));
		System.out.println(b);
	}

	static int mult(int num, int res_st[], int res_s) {

		int cr = 0;

		for (int j = 0; j < res_s; j++) {
			int prod = (res_st[j] * num + cr);

			res_st[j] = prod % 10;

			cr = prod / 10;
		}

		while (cr > 0) {
			res_st[res_s] = cr % 10;
			cr = cr / 10;
			res_s++;
		}
		return res_s;
	}

}
