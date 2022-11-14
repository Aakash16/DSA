package HackerrankSI.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CollectinApples {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");

			int n = Integer.parseInt(ints[0]);
			int m = Integer.parseInt(ints[1]);

			int[][] mat = new int[n][m];

			for (int i = 0; i < n; i++) {
				ints = br.readLine().trim().split("\\s+");
				for (int j = 0; j < m; j++) {
					mat[i][j] = Integer.parseInt(ints[j]);
				}
			}

			long ans = collectMax(mat);
			// print(mat);
			out.write(ans + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	private static long collectMax(int[][] mat) {

		for (int i = 1; i < mat[0].length; i++) {
			mat[0][i] = mat[0][i] + mat[0][i - 1];
		}

		for (int i = 1; i < mat.length; i++) {
			mat[i][0] = mat[i][0] + mat[i - 1][0];
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				mat[i][j] = mat[i][j] + Math.max(mat[i - 1][j], mat[i][j - 1]);
			}

		}

		return mat[mat.length - 1][mat[0].length - 1];
	}

}
