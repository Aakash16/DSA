package HackerrankSI.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class KillingDragons {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());

			int[] ar1 = new int[len];
			int[] ar2 = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");

			for (int f = 0; f < len; f++) {
				ar1[f] = Integer.parseInt(ints[f]);
			}

			ints = br.readLine().trim().split("\\s+");

			for (int f = 0; f < len; f++) {
				ar2[f] = Integer.parseInt(ints[f]);
			}

			int[] eg = new int[len];
			for (int f = 0; f < len; f++) {
				eg[f] = ar2[f] - ar1[f];
			}

			int[] diff = new int[len];
			long sum2 = 0;
			for (int f = 0; f < len - 1; f++) {
				diff[f] = eg[f] + eg[f + 1];
				sum2 += diff[f];
			}

			diff[len - 1] = eg[len - 1] + eg[0];
			sum2 += diff[len - 1];

			// System.out.println("s2 " + sum2);
			// System.out.println(Arrays.toString(diff));

			if (sum2 < 0) {
				out.write("-1\n");
			} else {

				TreeMap<Long, Long> map = new TreeMap<>();
				for (int i = 0; i < len; i++) {
					int idx = Math.abs(i + len - 1) % len;
					long d2 = sum2 - diff[idx];

					// System.out.println("map " + d2 + " " + eg[i] + " " + idx);
					if (d2 >= 0 && eg[i] > 0) {
						// System.out.println("taking " + d2 + " " + (i));

						if (!map.containsKey(d2))
							map.put(d2, (long) (i + 1));
					}
				}

				long key = map.get(map.firstKey());

				// Entry<Long, Long> val =
				// map.ceilingEntry(map.ceilingKey(map.lastKey()));

				out.write(key + "\n");
			}

		}

		out.close();
		br.close();

	}

}