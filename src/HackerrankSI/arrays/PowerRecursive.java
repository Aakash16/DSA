package HackerrankSI.arrays;
import java.math.BigInteger;
import java.util.Scanner;

public class PowerRecursive {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int c = 0; c < count; c++) {

			long b = sc.nextLong();
			long pow = sc.nextLong();
			
			System.out.println(getPow(b, pow).mod(new BigInteger("1000000007")));

		}

		sc.close();
	}

	public static BigInteger getPow(long base, long pow) {

		if (pow == 1) {
			return new BigInteger(String.valueOf(base));
		}

		if (pow % 2 == 0)
			return getPow(base, pow / 2).mod(new BigInteger("1000000007")).multiply(getPow(base, pow / 2).mod(new BigInteger("1000000007")));
		else {
			return getPow(base, (pow - 1) / 2).mod(new BigInteger("1000000007")).multiply(getPow(base, (pow - 1) / 2)).mod(new BigInteger("1000000007"))
					.multiply(new BigInteger(String.valueOf(base)));
		}

	}

}
