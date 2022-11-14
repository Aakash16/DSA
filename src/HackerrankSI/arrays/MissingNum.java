package HackerrankSI.arrays;
import java.util.Scanner;

public class MissingNum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();
			
			int sum = getSum(size+1);
			
			for(int i=0; i<size; i++) {
				int n = sc.nextInt();
				sum -= n;
			}
			
			System.out.println(sum);
			
			
		}
		sc.close();
	}
	
	private static int getSum(int num) {
		return num*(num+1)/2;
	}
}
