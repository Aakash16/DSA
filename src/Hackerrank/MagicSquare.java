package Hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class MagicSquare {

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {

		
		int[] s_ar = new int[8];
		int s_index = 0;
		for (int i = 0; i < 3; i++) {

			int s1 = 0, s2 = 0;
			for (int j = 0; j < 3; j++) {
				s1 += s[i][j];
				s2 += s[j][i];

			}
			
			s_ar[s_index++] = s1;
			s_ar[s_index++] = s2;
		}
		s_ar[s_index++] = s[0][0] + s[1][1] + s[2][2];
		s_ar[s_index++] = s[2][0] + s[1][1] + s[0][2];

		print(s_ar);
		System.out.print(getFrequent(s_ar));
		return 0;
	}
	
	private static void print(int[] a) {
		for(int i : a) {
			
			System.out.print(i+ " ");
		}
		System.out.println("");
	}

	private static int getFrequent(int[] a) {
		int count = 1, tempCount;
		int freq = a[0];
		int temp = 0;
		for (int i = 0; i < (a.length - 1); i++) {
			temp = a[i];
			tempCount = 0;
			for (int j = 1; j < a.length; j++) {
				if (temp == a[j])
					tempCount++;
			}
			if (tempCount > count) {
				freq = temp;
				count = tempCount;
			}
		}
		return freq;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter();

		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		scanner.close();
	}
}
