package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenSplit {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			long num = Long.parseLong(br.readLine());

			if (num % 2 != 0) {
				System.out.println("No");

			} else if (num > 3) {

				System.out.println("Yes");

			} else {
				System.out.println("No");
			}

		}
	}

}
