package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class AreaUnderHist {

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
			
			int[] P1 = new int[len];
			int[] P2 = new int[len];
			long ans = 0;
			Stack<Integer> st = new Stack<Integer>();

			for (int i = 0; i < len; i++) {
				
				while (!st.isEmpty() && ar[i] <= ar[st.peek()]) {
					st.pop();
				}
				
				if (st.isEmpty()) {
					P1[i] = -1;
				} else {
					P1[i] = st.peek();
				}

				st.push(i);

			}

			st.clear();

			for (int i = len - 1; i >= 0; i--) {

				while (!st.isEmpty() && ar[i] <= ar[st.peek()]) {
					st.pop();
				}

				if (st.isEmpty()) {
					P2[i] = len;
				} else {
					P2[i] = st.peek();
				}

				st.push(i);

			}
			
			for (int i = 0; i < len; i++) {
				
				ans = Math.max(ans, (P2[i] - P1[i] - 1) * ar[i]);
			}

			System.out.println(Arrays.toString(P1));
			System.out.println(Arrays.toString(P2));
			out.write(ans+"\n");

		}

		out.close();
	}

}
