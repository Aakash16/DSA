package HackerrankSI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputTemplate {

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
			
		}

		out.flush();
		br.close();
		out.close();
	}

}
