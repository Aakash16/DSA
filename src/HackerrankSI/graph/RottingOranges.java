package HackerrankSI.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class RottingOranges {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			String[] ints = br.readLine().trim().split("\\s+");

			int n = Integer.parseInt(ints[0]);

			int[][] mat = new int[n][n];

			ArrayList<Integer[]> list = new ArrayList<Integer[]>();

			int rc = 0;
			for (int i = 0; i < n; i++) {
				String num = br.readLine();

				for (int j = 0; j < n; j++) {
					mat[i][j] = num.charAt(j) - '0';
					if (mat[i][j] == 2)
						list.add(new Integer[] { i, j });

					if (mat[i][j] == 1) {
						rc++;
					}
				}
			}

			int c = countDays(mat, n, list, rc);
			if (c == 0)
				c = -1;
			out.write(c + "\n");
		}

		out.flush();
		br.close();
		out.close();
	}

	private static int countDays(int[][] mat, int n, ArrayList<Integer[]> list, int rc) {
		int c = 0;
		int or = list.size();
		System.out.println("or " + or);
		ArrayList<Integer[]> list2 = new ArrayList<Integer[]>();

		while (rc > 0) {
			
			list2.clear();
			while (list.size() > 0) {
				int i = list.get(0)[0];
				int j = list.get(0)[1];
				if (mat[i][j] == 2) {

					c += dfs(i, j, mat, list2, rc);
					list.remove(0);
				}

				System.out.println("rem1 " + i + " " + j + " " + list2.size() + " " + rc);
				
				if(list.size() == 0) {
					System.out.println("cleared");
					list.addAll(list2);
				}
			}
			
			System.out.println("rc " + rc);
			
		}

		System.out.println("com " + c);

		return c - or;
	}

	private static int dfs(int i, int j, int[][] mat, ArrayList<Integer[]> list, int rc) {

		int[] di = new int[] { 0, 1, 0, -1 };
		int[] dj = new int[] { 1, 0, -1, 0 };

		int c = 0;
		for (int k = 0; k < 4; k++) {

			if (isValidCell(i + di[k], j + dj[k], mat) && mat[i + di[k]][j + dj[k]] == 1) {
				mat[i + di[k]][j + dj[k]] = 2;
				System.out.println("adding " + (i + di[k]) + " " + (j + dj[k]));
				list.add(new Integer[] { i + di[k], j + dj[k] });
				c++;
				rc--;
			}
		}

		return c;
	}

	private static boolean isValidCell(int i, int j, int[][] mat) {

		int n = mat.length;
		int m = mat[0].length;

		if (i < 0 || j < 0 || i >= n || j >= m)
			return false;

		else if (mat[i][j] == 1)
			return true;
		else
			return false;

	}

	static void print(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
