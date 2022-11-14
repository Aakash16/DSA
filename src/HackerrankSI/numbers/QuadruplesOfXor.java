package HackerrankSI.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class QuadruplesOfXor {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());

		for (int i = 0; i < tc; tc++) {

			int N = Integer.parseInt(in.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			int[] C = new int[N];
			int[] D = new int[N];

			String[] a = in.readLine().split("\\s+");
			String[] b = in.readLine().split("\\s+");
			String[] c = in.readLine().split("\\s+");
			String[] d = in.readLine().split("\\s+");

			for (int h = 0; h < N; h++) {
				A[h] = Integer.parseInt(a[h]);
			}

			for (int h = 0; h < N; h++) {
				B[h] = Integer.parseInt(b[h]);
			}
			for (int h = 0; h < N; h++) {
				C[h] = Integer.parseInt(c[h]);
			}
			for (int h = 0; h < N; h++) {
				D[h] = Integer.parseInt(d[h]);
			}

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int h = 0; h < N; h++) {
				for (int k = 0; k < N; k++) {
					int xor = A[h] ^ B[k];

					if (map.containsKey(xor)) {
						int v = map.get(xor);
						map.put(xor, v + 1);
					} else {
						map.put(xor, 1);
					}
				}
			}

			int count = 0;
			for (int h = 0; h < N; h++) {
				for (int k = 0; k < N; k++) {
					int xor = C[h] ^ D[k];

					if (map.containsKey(xor)) {

						count = count + map.get(xor);
					}

				}
			}

			System.out.println(count);

		}

	}

}
