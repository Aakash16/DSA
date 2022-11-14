package CodeForces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution{
    
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			
			String[] ints = br.readLine().trim().split("\\s+");
			
			int len = ints.length;

			long sum = 0;
			
			for (int p = 0; p < len; p++) {
				sum += Long.parseLong(ints[p]);
			}
			
			long ans = sum/2;
			out.write(ans+"");
			
		}

		out.flush();
		br.close();
		out.close();
	}
	
}