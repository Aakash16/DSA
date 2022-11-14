package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MaxSubArrCircul {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];
			int[] rev = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");
			
			long maxSum = 0;
			int max = Integer.MIN_VALUE;
			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
				max = Math.max(max, ar[p]);
				maxSum += ar[p];
				rev[p] = -ar[p];
			}
			
			System.out.println("max " + max);
			
			long ans = getMax(ar, len);
			long neg = getMax(rev, len);
			
			ans = Math.max(ans, maxSum + neg);
			
			if(ans == 0)
				ans = Math.min(ans, max);
			out.write(ans+"\n");
			
		}

		out.flush();
		br.close();
		out.close();
	}

	private static long getMax(int[] ar, int len) {
		long ans = ar[0];
		long x = Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++) {
			x = Math.max(x, 0) + ar[i];
			ans = Math.max(x, ans);
		}
		
		return ans;
	}
}
