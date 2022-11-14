package HackerrankSI.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ValidSubarrays {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			int len = Integer.parseInt(br.readLine());
			int[] ar = new int[len];

			String[] ints = br.readLine().trim().split("\\s+");
			for (int p = 0; p < len; p++) {
				ar[p] = Integer.parseInt(ints[p]);
			}

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int c = getSubarrays(ar, map);
			System.out.println(c);
		}

	}

	private static int getSubarrays(int[] ar, HashMap<Integer, Integer> map) {

		int rsum = 0;
		int count = 0;
		for (int i = 0; i < ar.length; i++) {

			if (ar[i] == 0)
				ar[i] = -1;

			rsum += ar[i];

			if (rsum == 0)
				count++;

			if (map.containsKey(rsum)) {
				count += map.get(rsum);
			}

			if (!map.containsKey(rsum)) {
				map.put(rsum, 1);

			} else {
				map.put(rsum, map.get(rsum) + 1);
			}

		}

		return count;

	}

	private static boolean isValid(int[] ar) {

		int c = -1;
		for (int i = 0; i < ar.length; i++) {

			if (ar[i] == 1) {
				c++;
			} else {
				c--;
			}
		}

		if (c == -1) {
			return true;
		}
		return false;

	}

	private static void getSubsAr(int[] ar, int N, int idx, HashMap<String, Integer> map) {

		if (idx == N)
			return;

		for (int i = idx; i < N; i++) {

			int[] arr = Arrays.copyOfRange(ar, idx, i + 1);
			String str = Arrays.toString(arr);

			if (str.length() > 2) {
				if (map.containsKey(str))

					if (isValid(arr)) {
						map.put(str, 1);
					}
			}
		}

		getSubsAr(ar, N, idx + 1, map);

		return;
	}

}
