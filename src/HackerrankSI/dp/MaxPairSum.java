package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxPairSum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");
			int len = Integer.parseInt(ints[0]);
			int k = Integer.parseInt(ints[1]);

			int[] ar1 = new int[len];
			int[] ar2 = new int[len];

			ints = br.readLine().trim().split("\\s+");

			for (int t2 = 0; t2 < len; t2++) {
				ar1[t2] = Integer.parseInt(ints[t2]);
			}

			ints = br.readLine().trim().split("\\s+");
			for (int t2 = 0; t2 < len; t2++) {

				ar2[t2] = Integer.parseInt(ints[t2]);
			}

			int[] ans = getMax(ar1, ar2, len, k);
			out.write(Arrays.toString(ans) + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	static int[] getMax(int ar1[], int ar2[], int n, int k) {

		Arrays.sort(ar1);
		Arrays.sort(ar2);

		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		int[] ans = new int[k];
		// ans[0] = ar1[n - 1] + ar2[n - 1];

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.offer(ar1[n - 1]);
		pq.offer(ar1[n - 2]);
		pq.offer(ar2[n - 1]);
		pq.offer(ar2[n - 2]);

		int c = 0;
		
		while (c < (n-3) && c < k - 4) {
			int a = pq.poll();
			int b = pq.poll();

			ans[c++] = a + b;

			pq.offer(ar1[n - 3 - c]);
			pq.offer(ar2[n - 3 - c]);
			// ans[i] = Math.max(ar1[n-1] + ar2[n - 1 -i], ar2[n-1] + ar1[n - 1 - i]);
		}

		// System.out.println(Arrays.toString(ans));
		return ans;

	}

}
