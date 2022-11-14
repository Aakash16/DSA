package HackerrankSI.numbers;

import java.util.Scanner;

public class Cuberoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			long num = sc.nextLong();
			boolean neg = false;
			if (num < 0) {
				neg = true;
				num *= -1;
			}

			int n = (int) Math.round(cRoot(num));

			if (neg)
				n *= -1;
			System.out.println(n);

		}
		sc.close();
	}

	private static double dif(double n, double mid) {
		if (n > (mid * mid * mid))
			return (n - (mid * mid * mid));
		else
			return ((mid * mid * mid) - n);
	}

	private static double cRoot(double n) {

		double start = 0, end = n;

		double e = 0.0000001;

		while (true) {
			double mid = (start + end) / 2;
			double error = dif(n, mid);

			if (error <= e)
				return mid;

			if ((mid * mid * mid) > n)
				end = mid;

			else
				start = mid;
		}
	}
}
