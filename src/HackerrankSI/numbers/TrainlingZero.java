package HackerrankSI.numbers;
import java.util.Scanner;

public class TrainlingZero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		long[] nums = new long[count];
		for (int i = 0; i < count; i++) {

			nums[i] = sc.nextLong();
			long zeros = 0;
			long fiveFact = 5;

			while (fiveFact <= nums[i]) {
				zeros = zeros + nums[i] / fiveFact;
				fiveFact *= 5;
			}

			System.out.println(zeros);
		}

		sc.close();

	}
}
