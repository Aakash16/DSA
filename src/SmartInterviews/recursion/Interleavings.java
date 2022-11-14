package SmartInterviews.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Interleavings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		sc.nextLine();

		for (int i = 0; i < count; i++) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();

			char[] ar = new char[s1.length() + s2.length()];
			// interleave(s1, s2, ar, s1.length(), s2.length(), 0);

			printAllInterleavings(s1, s2, "");
		}

		sc.close();
	}

	private static void interleave(String s1, String s2, char[] res, int n1, int n2, int idx) {

		if (n1 == 0 && n2 == 0) {
			System.out.println(Arrays.toString(res));
			return;
		}

		if (n1 > 0 && idx < res.length) {
			res[idx++] = s1.charAt(n1 - 1);
			interleave(s1, s2, res, n1 - 1, n2, idx);
		}

		if (n2 > 0 && idx < res.length) {
			res[idx++] = s2.charAt(n2 - 1);
			interleave(s1, s2, res, n1, n2 - 1, idx);
		}

		return;
	}

	private static void interleave(String s1, String s2, String s3) {

		if (s1 == null) {
			System.out.println(s2);
			return;
		}

		if (s2 == null) {
			System.out.println(s1);
			return;
		}

		if (s1.length() == 0 & s2.length() == 0) {
			System.out.println("p:" + s3);
		}

		if (s1.length() != 0) {
			System.out.println("1:" + s1.substring(1));
			interleave(s1.substring(1), s2, s3 + s1.charAt(0));
		}

		if (s2.length() != 0) {
			System.out.println("2:" + s2.substring(1));
			interleave(s1, s2.substring(1), s3 + s2.charAt(0));
		}
	}

	private static void printAllInterleavings(String str1, String str2, String interleavingString) {

		// If string 1 is null then print string 2 and return
		if (str1 == null) {
			System.out.println(str2);
			return;
		}

		// If string 2 is null then print string 1 and return
		if (str2 == null) {
			System.out.println(str1);
			return;
		}

		// if string 1 and string 2 length became 0, it means all characters from str1
		// and str2 is present in interleaving, print interleavingString.
		if (str1.length() == 0 && str2.length() == 0) {
			System.out.println(interleavingString);
		}

		// pick characters from string 1 until string 1 length is empty.
		if (str1.length() != 0) {
			// pick character from string 1 and append it in interleavingString string. In
			// next recursive call remove picked character from string 1.
			printAllInterleavings(str1.substring(1), str2, interleavingString + str1.charAt(0));
		}

		// pick characters from string 2 until string 2 length is empty.
		if (str2.length() != 0) {
			// pick character from string 2 and append it in interleavingString string. In
			// next recursive call remove picked character from string 2.
			printAllInterleavings(str1, str2.substring(1), interleavingString + str2.charAt(0));
		}
	}

}
