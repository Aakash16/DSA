package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();

			int p1 = 0;
			int p2 = len - 1;

			while (p1 < p2 && s.charAt(p1) == s.charAt(p2)) {

				p1++;
				p2--;
			}

			if (p1 == p2 || p1 > p2)
				System.out.println("Yes");
			else
				System.out.println("No");
		}

	}

}
