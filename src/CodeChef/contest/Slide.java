package CodeChef.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Slide {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			String[] ints = br.readLine().trim().split("\\s+");

			long len = Integer.parseInt(br.readLine());

			
			int[] a = new int[(int)len];
			
			double sum = 0;
			HashMap<Double, Integer> map = new HashMap<Double, Integer>();
			for (int p = 0; p < len; p++) {

				a[p] = Integer.parseInt(ints[p]);
				sum += a[p];
			}
			
			double avg = sum / len;
			double den = len-1;
			//System.out.println(df.format(sum) + " " + df.format(avg) + " " + df.format(den));
			
			
			for (int p = 0; p < len; p++) {
				double num = (sum - a[p]);
				double key = num / den;
				
				//System.out.println(df.format(key) + " " + df.format(num));
				if (!map.containsKey(key)) {
					map.put(key, p);
				}
			}

			if (map.containsKey(avg)) {
				out.write((map.get(avg) + 1) + "\n");
			} else {
				out.write("Impossible" + "\n");
			}

		}

		br.close();
		out.close();
	}

}
