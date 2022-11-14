package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CollectingMngoe {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int n = Integer.parseInt(br.readLine());
			
			Stack<Integer> st = new Stack<Integer>();
			Stack<Integer> maxSt = new Stack<Integer>();

			int max = Integer.MIN_VALUE;
			
			out.write("Case " + (t + 1) + ":\n");
			for (int i = 0; i < n; i++) {

				String[] sub = br.readLine().trim().split("\\s+");

				String opr = sub[0];

				switch (opr) {

				case "A":

					int val = Integer.parseInt(sub[1]);

					st.push(val);
					
					if(max < val) {
						max = Math.max(max, val);
						maxSt.push(max);
						//System.out.println("pushed " + max);
					}
					

					break;

				case "Q":
					
					if(!st.isEmpty()) {
						out.write(maxSt.peek()+"\n");
					}else {
						out.write("Empty\n");
					}
					
					break;

				case "R":
					if(!st.isEmpty()) {
						
						int v = st.pop();
						
						if(!maxSt.isEmpty() && maxSt.peek() == v) {
							maxSt.pop();
							
							
							if(maxSt.isEmpty()) {
								max = Integer.MIN_VALUE;
							}else {
								max = maxSt.peek();
							}
						}
						
					}
					break;
				}

			}
		}

		br.close();
		out.close();
	}

}
