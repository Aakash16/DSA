package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoOfIslands {

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
				String num = br.readLine();

				for (int j = 0; j < m; j++) {
					mat[i][j] = num.charAt(j) - '0';
				}
			}

			int c = countIslands(mat, n, m);
			out.write(c + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	private static int countIslands(int[][] mat, int n, int m) {
		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 1) {
					c++;
					dfs(i, j, mat);
				}
			}
		}

		return c;
	}

	private static void dfs(int i, int j, int[][] mat) {

		if (!isValidCell(i, j, mat)) {
			return;
		}
		mat[i][j] = 0;

		int[] di = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dj = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };

		for (int k = 0; k < 8; k++) {
			dfs(i + di[k], j + dj[k], mat);
		}
	}

	private static boolean isValidCell(int i, int j, int[][] mat) {

		int n = mat.length;
		int m = mat[0].length;

		if (i < 0 || j < 0 || i >= n || j >= m)
			return false;

		else if (mat[i][j] == 0)
			return false;
		else
			return true;

	}

}
