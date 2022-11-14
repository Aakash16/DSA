package HackerrankSI.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ImplDeque {
	private static int N = 10000;
	private static int[] arr = new int[N];
	private static int f = -1;
	private static int r = -1;

	 private static final String PUF = "push_front";
	 private static final String POF = "pop_front";
	 private static final String PUB = "push_back";
	 private static final String POB = "pop_back";

	//private static final String PUF = "a";
	//private static final String POF = "b";
	//private static final String PUB = "c";
	//private static final String POB = "d";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		int count = 0;
		for (int t = 0; t < tc; t++) {

			String[] sub = br.readLine().trim().split("\\s+");

			String opr = sub[0];

			switch (opr) {

			case PUB:

				int val = Integer.parseInt(sub[1]);

				if (count < N) {
					r = (r + 1) % N;
					arr[r] = val;
					count++;
				} else {
					System.out.println("Full");
				}

				//System.out.println("ins " + arr[r] + " " + r + " " + f + " " + (r - f));
				break;

			case PUF:

				val = Integer.parseInt(sub[1]);

				if (count < N) {
					
					if (f < 0) {
						f = N + f;
					}
					
					arr[f] = val;
					count++;
					
					f = (f - 1);

					
				} /*else {
					System.out.println("Full");
				}*/

				//System.out.println("ins " + arr[f] + " " + r + " " + f + " " + (r - f));

				break;

			case POF:

				if (count > 0) {
					f = (++f) % N;
					System.out.println(arr[f]);
					arr[f] = 0;
					count--;
				} else {
					System.out.println("Empty");
				}

				break;

			case POB:
				
				if (count > 0) {
					
					if (r < 0) {
						r = N + r;
					}
					
					System.out.println(arr[r]);
					arr[r] = 0;
					count--;
					
					r = (r - 1);

					
				} else {
					System.out.println("Empty");
				}

				break;

			}

			//System.out.println(f + " " + r);
			//System.out.println(Arrays.toString(arr));

		}

		br.close();
		out.close();
	}

}
