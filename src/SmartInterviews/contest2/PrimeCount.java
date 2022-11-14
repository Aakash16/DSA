package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeCount {

	private static int N = 1000001;
	private static boolean[] visited = new boolean[N];
	private static int[] pCountArr = new int[N];

	static {

		visited[0] = true;
		visited[1] = true;

		int sqr = (int) Math.ceil(Math.sqrt(N - 1));

		pCountArr[0] = 0;
		pCountArr[1] = 0;
		pCountArr[2] = 0;

		for (int i = 2; i < sqr; i++) {

			if (!visited[i]) {

				int j = 2;
				while (j * i < N) {
					visited[i * j] = true; // True means index is not prime
					j++;
				}

			}
		}
		
		
		for(int i=2;i<pCountArr.length;i++) {
			
			if(!visited[i])
				pCountArr[i] = pCountArr[i-1] + 1;
			else
				pCountArr[i] = pCountArr[i-1];
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			
			int[] ar = new int[2];

			String[] ints = br.readLine().trim().split("\\s+");

			for (int p = 0; p < 2; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			int n = ar[0];
			int m = ar[1];
			
			int pp = 0;
			if(!visited[n])
				pp = 1;
			long c = pCountArr[m] - pCountArr[n] + pp;
			
			out.write(c + "\n");
			
		}

		br.close();
		out.close();
	}
}
