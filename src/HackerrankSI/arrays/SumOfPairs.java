package HackerrankSI.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();
			int k = sc.nextInt();
			boolean found = false;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < size; i++) {
				int num = sc.nextInt();
				int diff = k - num;

				if (map.get(num) == null) {
					map.put(diff, num);
				} else if (diff == map.get(num)) {
					found = true;
				} else {
					found = false;
				}
			}

			if (found)
				System.out.println("True");
			else
				System.out.println("False");
		}
		sc.close();

	}

}
