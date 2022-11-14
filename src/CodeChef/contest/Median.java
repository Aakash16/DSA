package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Median {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			long N = Long.parseLong(br.readLine());
			String[] ints = br.readLine().trim().split("\\s+");

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			long sum = 0;

			for (int i = 0; i < ints.length; i++) {
				int x = Integer.parseInt(ints[i]);
				sum += x;
				map.put(x, 1);
				max = Math.max(max, x);
				min = Math.min(min, x);

				if (i > 1) {
					int del = (int) sum - min - max;
					map.remove(del);
					sum -= del;
				}
			}

			Set<Integer> set = map.keySet();
			Iterator<Integer> itr = set.iterator();

			while (itr.hasNext()) {
				out.write(itr.next() + "\n");
			}
			
			out.flush();
		}

		out.write(System.lineSeparator());
		br.close();
		out.close();
	}

}
