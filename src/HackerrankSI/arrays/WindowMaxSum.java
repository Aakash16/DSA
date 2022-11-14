package HackerrankSI.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class WindowMaxSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			long sum = 0;
			String[] ints = br.readLine().trim().split("\\s+");

			int len = Integer.parseInt(ints[0]);
			int k = Integer.parseInt(ints[1]);
			int[] ar = new int[len];

			ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

			for (int i = 0; i < k; i++) {

				if (map.containsKey(ar[i])) {
					int val = map.get(ar[i]);
					map.put(ar[i], val + 1);
				} else {
					map.put(ar[i], 1);
				}
			}

			System.out.println(map.lastKey());
			sum += map.lastKey();

			for (int i = k; i < len; i++) {

				int key = ar[i - k];
				System.out.println("rem: " + key + " " + map.toString());
				System.out.println("max: " + map.lastKey() + " " + map.size());

				if (map.containsKey(key)) {

					int val = map.get(key);

					if (val > 1) {
						map.put(key, val - 1);
					} else {
						map.remove(key);
					}
				}
				
				if (map.containsKey(ar[i])) {
					int val = map.get(ar[i]);
					map.put(ar[i], val + 1);
				} else {
					map.put(ar[i], 1);
				}
				
				sum += map.lastKey();
				System.out.println(map.lastKey());
			}

			out.write(sum + "\n");

		}

		br.close();
		out.close();
	}

}
