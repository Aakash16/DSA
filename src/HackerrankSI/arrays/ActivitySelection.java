package HackerrankSI.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class ActivitySelection {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int lim = Integer.parseInt(br.readLine());

		for (int c = 0; c < lim; c++) {

			int len = Integer.parseInt(br.readLine());
			String[] st = br.readLine().trim().split("\\s+");
			String[] en = br.readLine().trim().split("\\s+");

			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			for (int p = 0; p < len; p++) {
				map.put(Integer.parseInt(st[p]), Integer.parseInt(en[p]));
			}
			
		}

		out.flush();
		out.close();
		br.close();

	}
}