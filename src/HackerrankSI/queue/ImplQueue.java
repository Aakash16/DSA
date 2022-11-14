package HackerrankSI.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ImplQueue {
	private static int N = 10000;
	private static int[] arr = new int[N];
	private static int f = -1;
	private static int r = -1;

	private static final String E = "Enqueue";
	private static final String D = "Dequeue";

	// private static final String E = "e";
	// private static final String D = "d";
 
	public static void main(String[] sd) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		int count = 0;
		for (int t = 0; t < tc; t++) {

			String[] sub = br.readLine().trim().split("\\s+");

			String opr = sub[0];

			// System.out.println("opr: " + opr);

			switch (opr) {

			case E:

				int val = Integer.parseInt(sub[1]);

				if (count < N) {
					r = (r + 1) % N;
					arr[r] = val;
					count++;
				} /*
					 * else{ System.out.println("Full"); }
					 */

				// System.out.println("ins " + arr[r] + " " + r + " " + f + " " + (r-f));
				break;

			case D:

				if (count > 0) {
					f = (++f) % N;
					System.out.println(arr[f]);
					arr[f] = 0;
					count--;
				} else {
					System.out.println("Empty");
				}

				break;

			}
			// System.out.println(f + " " + r);
			// System.out.println(Arrays.toString(arr));

		}

		br.close();
		out.close();
	}

}
