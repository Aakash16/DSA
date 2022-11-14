package HackerrankSI.arrays;

import java.util.Hashtable;
import java.util.Scanner;

public class TripleTrouble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		sc.nextLine();
		Hashtable<Integer, Boolean> h = 
                new Hashtable<Integer, Boolean>();
		for (int i = 0; i < count; i++) {
			int len = sc.nextInt();

			h.clear();
			
			int sum = 0;
			for (int j = 0; j < len; j++) {

				int num = sc.nextInt();
				
				if (h.get(num)==null  || !h.get(num)) {
					h.put(num, true);
					sum += num * 2;

				}

				else {
					sum -= num;
				}
			}

			System.out.println(sum / 2);
		}

		sc.close();
	}

}
