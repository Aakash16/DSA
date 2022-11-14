package CodeForces.strings;

import java.util.Scanner;

public class TooLongwords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		sc.nextLine();

		for (int i = 0; i < count; i++) {
			String s = sc.nextLine();

			int len = s.length();
			if (len >= 10) {
				System.out.println(String.valueOf(s.charAt(0)) + (len-2) + String.valueOf(s.charAt(len - 1)));
			} else
				System.out.println(s);
		}

		sc.close();
	}

}
