package CodeForces.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class String118A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		int len = s.length();
		StringBuilder sb = new StringBuilder();

		ArrayList<Character> list = new ArrayList<Character>(
				Arrays.asList('A', 'a', 'I', 'i', 'o', 'O', 'u', 'U', 'e', 'E', 'y', 'Y'));
		for (int i = 0; i < len; i++) {

			char c = s.charAt(i);

			if (!list.contains(c)) {
				sb.append(".");
				sb.append(String.valueOf(c).toLowerCase());
			}
		}

		System.out.println(sb.toString());
		sc.close();
	}

}
