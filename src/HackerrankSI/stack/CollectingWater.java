package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CollectingWater {

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
			
			int[] LM = new int[len];
			int[] RM = new int[len];
			
			LM[0] = ar[0]; 
	        for (int i = 1; i < len; i++) 
	           LM[i] = Math.max(LM[i-1], ar[i]); 
	       
	        RM[len-1] = ar[len-1]; 
	        for (int i = len-2; i >= 0; i--) 
	           RM[i] = Math.max(RM[i+1], ar[i]);
			
			long ans = 0;
			for(int i=0;i<len;i++) {
				int d = Math.min(LM[i],RM[i]) - ar[i];
				ans += d;
			}
			
			out.write(ans + "\n");
		
		}
		
		out.close();
	}

}
