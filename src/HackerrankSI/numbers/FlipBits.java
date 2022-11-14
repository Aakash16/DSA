package HackerrankSI.numbers;

import java.util.Scanner;

public class FlipBits {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int c = 0; c < count; c++) {
			
			long num1 = sc.nextLong();
			long num2 = sc.nextLong();
			
			int n1 = -1;
			int n2 = -1;
			int cc = 0;
			
			bin(num1);
			System.out.println();
			bin(num2);
			System.out.println();
			while(num1 > 0 && num2 > 0) {
			 n1 = (int)num1%2;
			 n2 = (int)num2%2;
			
			 if(n1 !=n2)
				 cc++;
			 
			 num1 /= 2;
			 num2 /= 2;
			 
			}
			
			bin(num1);
			System.out.println();
			bin(num2);
			System.out.println();
			
			num1 = num1>num2?num1:num2;
			
			while(num1 > 0) {
				int n = (int)num1%2;
				num1 /= 2;
				
				if(n == 1)
					cc++;
			}
			
			System.out.println(cc);
		}
		sc.close();
	}
	private static void bin(long num) {
		if (num>0) {
			bin(num/2);
	        System.out.print(num%2);
	    }
	}
}