package HackerrankSI.numbers;

import java.util.Scanner;

public class RevBits {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		int[] bin = new int[32];
		for (int c = 0; c < count; c++) {
			long num = sc.nextLong();

			for (int i = 0; i < bin.length; i++) {
				bin[i] = (int) (num % 2);
				num /= 2;

			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < bin.length; i++) {
				sb.append(bin[i]);
			}
			
			System.out.println(Long.valueOf(sb.toString(),2));
		}
		sc.close();
	}

}
