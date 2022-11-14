package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];
			int[] ans = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");
			
			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}
			
			Stack<Integer> st = new Stack<Integer>();
			st.push(0);
			ans[0] = 1;
			
			for(int i = 1; i<len;i++) {
				
				while(!st.isEmpty() && ar[i] >= ar[st.peek()]) {
					st.pop();
				}
				
				if(st.isEmpty())
					ans[i] = i+1;
				else
					ans[i] = i - st.peek();
				
				st.push(i);
			}
			
			System.out.println(Arrays.toString(ans));
			
		}

		br.close();
		out.close();
	}

}
