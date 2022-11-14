package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SumOfPairs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int size = Integer.parseInt(br.readLine());
			long sum = 0;
			int[] ar = new int[size];
			String[] ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < size; p++) {
				ar[p] = Integer.parseInt(ints[p]);
				sum += ar[p];
			}

			boolean is = false;

			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			for (int i = 0; i < size; i++) {
				
				long key = sum - 2*ar[i];
				if(!map.containsKey(key))
					map.put(key, ar[i]);

			}
			
			for (int i = 0; i < size; i++) {
				
				long k = sum - 2*ar[i];
				
				if(map.containsKey(k))
					is = true;
			}

			if (is)
				System.out.println("Yes");
			else
				System.out.println("No");

		}
	}

}
