package SmartInterviews.contest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RangeSum {

	static int A = 0, B = 0, count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints1 = br.readLine().trim().split("\\s+");
			int len = Integer.parseInt(ints1[0]);
			A = Integer.parseInt(ints1[1]);
			B = Integer.parseInt(ints1[2]);

			int[] ar = new int[len];

			String[] ints2 = br.readLine().trim().split("\\s+");

			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints2[p]);
			}

			getSubArrays(ar, 0, 0);

			out.write(count + "\n");
			count = 0;

		}

		br.close();
		out.close();
	}

	static void getSubArrays(int[] arr, int s, int e) {
		if (e == arr.length)
			return;

		else if (s > e)
			getSubArrays(arr, 0, e + 1);

		else {
			long sum = 0;
			for (int i = s; i < e; i++) {
				// System.out.print(arr[i]+", ");
				sum += arr[i];
			}

			sum += arr[e];
			// System.out.println(arr[e] + ", ");
			if (sum >= A && sum <= B)
				count++;

			getSubArrays(arr, s + 1, e);
		}

		return;
	}
}
