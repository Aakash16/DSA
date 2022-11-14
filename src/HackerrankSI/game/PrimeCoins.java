package HackerrankSI.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeCoins {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());

			if (num % 6 == 0)
				System.out.println("Banta");
			else
				System.out.println("Santa");
		}
	}
}
