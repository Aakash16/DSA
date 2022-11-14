package HackerrankSI.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class DiffOfPairs {

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
				int diff1 = num - k;
				int diff2 = k - num;
				//20 -  (x1) = 60;
				//x2 - 20 = 60

				if (map.get(num) == null) {
					map.put(diff1, num);
					map.put(diff2, num);
				} else if (diff1 == map.get(num) || diff2 == map.get(num)) {
					found = true;
				} else {
					found = false;
				}
			}

			if (found)
				System.out.println("true");
			else
				System.out.println("false");
		}
		sc.close();

	}

}
