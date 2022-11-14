package HackerrankSI.arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RepeatedNums {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		ArrayList<Integer> com = new ArrayList<Integer>();		
		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();

			com.clear();
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for (int j = 0; j < size; j++) {

				int num = sc.nextInt();
				
				if(hm.get(num) == null || hm.get(num) == 0) {
					hm.put(num, 1);
				}else {
					com.add(num);
				}
				
			}
			
			Collections.sort(com);
			
			for(int n: com) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
