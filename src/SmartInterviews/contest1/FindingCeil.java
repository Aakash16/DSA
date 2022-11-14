package SmartInterviews.contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingCeil {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		int[] ar = new int[len];

		String[] ints = br.readLine().trim().split("\\s+");
		for (int p = 0; p < len; p++) {
			ar[p] = Integer.parseInt(ints[p]);
		}

		int q = Integer.parseInt(br.readLine());
		int[] qr = new int[q];
		for (int i = 0; i < q; i++) {

			qr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ar);

		System.out.println(Arrays.toString(ar));

		int mval = ar[len - 1];
		for (int i = 0; i < q; i++) {
			int k = qr[i];

			int max = binsearch2(ar, k);
			System.out.println("F: " + max);

			if (max >= 0 && max < len) {
				System.out.println(ar[max]);
			} else {
				if (k < mval && max < Integer.MAX_VALUE)
					System.out.println(ar[max + 1]);
				else {
					System.out.println(Integer.MAX_VALUE);
				}
			}
		}

	}

	private static int binsearch2(int[] ar, int k) {

		int start = 0;
		int end = ar.length - 1;
		int ans = Integer.MAX_VALUE;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (k > ar[middle]) {

				start = middle + 1;
			}

			else {
				ans = middle;
				end = middle - 1;

			}

		}
		return ans;

	}

}
