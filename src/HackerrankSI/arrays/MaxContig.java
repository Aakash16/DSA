package HackerrankSI.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class MaxContig {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			final int size = sc.nextInt();

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < size; j++) {
				int c = -1;
				int num = sc.nextInt();

				if (map.get(num) == null)
					map.put(num, num);

				int n = num;
				while (map.get(n++) != null)
					c++;

				n = num;
				while (map.get(n--) != null)
					c++;

				if (c > max)
					max = c;

			}

			System.out.println(max);
		}

		sc.close();
	}
}
