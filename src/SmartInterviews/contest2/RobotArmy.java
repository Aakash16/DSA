package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class RobotArmy {

	static int N = 10000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			Arrays.sort(ar);

			System.out.println(Arrays.toString(ar));

			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			HashMap<Long, Integer> map2 = new HashMap<Long, Integer>();

			int max = ar[0];
			for (int i = 0; i < len; i++) {
				max = Math.max(max, ar[i]);
			}

			for (int p = 1; p < len; p++) {

				if (!map.containsKey((long) ar[p - 1])) {
					//System.out.println("adding " + ar[p - 1]);
					map.put((long) ar[p - 1], ar[p - 1]);
				}

				Iterator<Long> itr = map.keySet().iterator();
				map2.clear();
				while (itr.hasNext()) {

					long n = itr.next();
					long sum = 0;

					sum = n + ar[p];

					//System.out.println("old " + n);
					//System.out.println("new  " + sum);
					if (!map.containsKey(sum)) {
						map2.put(sum, ar[p]);
						//System.out.println("put: " + sum);
					}
				}

				map.putAll(map2);
			}

			/*
			 * Iterator<Long> itr = map.keySet().iterator(); while (itr.hasNext()) {
			 * System.out.println(itr.next()); }
			 */

			Iterator<Long> itr = map.keySet().iterator();
			boolean found = false;
			long c = ar[0];
			while (itr.hasNext()) {
				long n = itr.next();
				// System.out.println(n + " " + c);
				if (c != n) {
					found = true;
					out.write(c+"\n");
					break;
				}
				c++;
			}
			
			if(!found)
			out.write(c+"\n");
			//}

		}

		br.close();
		out.close();
	}
}
