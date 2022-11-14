package HackerrankSI.numbers;
import java.util.Scanner;

public class BinRep {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int c = 0; c < count; c++) {
			long num = sc.nextLong();
			System.out.println(bin(num,""));
		}
		sc.close();
	}
	
	
	private static void bin(long num) {
		
		long rem = 0;
		
		if(num <= 1) {
			System.out.print(num);
			return;
		}
		
		rem = num%2;
		num = num>>1;
		bin(num);
		System.out.print(rem);
		
		return;
	}
	
private static String bin(long num, String snum) {
		if(num <= 1) { return (num + snum );}
		snum = num%2 + snum;
		num = num>>1;
		return bin(num,snum);}}