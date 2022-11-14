package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
	final private static int mod = (int) (1e9 + 7);
	final private static long[] facts = new long[1000000];
	static {
		facts[0] = 1;
		for (int i = 1; i < 1000000; i++) {
			facts[i] = (facts[i - 1] * i) % mod;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());

			System.out.println(facts[num]);
		}

	}

}
