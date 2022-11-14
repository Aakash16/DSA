package HackerrankSI.matrix;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixRotate2 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
		mat.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		mat.add(new ArrayList<>(Arrays.asList(7, 8, 9, 10)));
		mat.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
		mat.add(new ArrayList<>(Arrays.asList(19, 20, 21, 22)));
		 mat.add(new ArrayList<>(Arrays.asList(25,26,27,28)));

		print(mat);

		
		matrixRotation(mat, 29);

		print(mat);
	}

	static void matrixRotation(ArrayList<ArrayList<Integer>> matrix, int r) {

		int m = matrix.size(), n = matrix.get(0).size();
		int fact = 2*(m-1+n-1);
		int laps = r%(fact);
		
		int loops = m > n ? n/2 : m/2;
		for (int i = 0; i < loops; i++) {
			int lo = i, up = m - 1 - i;
			matrix = rotate(matrix, laps, lo, up, n - i - 1);
		}
	}

	private static ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> mat, int rt, int sr, int er,
			int ec) {
		for (int k = 0; k < rt; k++) {
			for (int i = sr; i <= er; i++) {

				int rem = sr + 1; // from index in row
				int add = sr; // to index in row
				int to = i + 1; // to list
				int from = i; // from list

				if (i == sr)
					rem = sr;

				if (to <= er)
					mat.get(to).add(add, mat.get(from).remove(rem));

				// System.out.println(i + " " + mat.get(i));
			}
			for (int i = sr; i <= er; i++) {

				int to = i;
				int from = i + 1;
				int rem = ec;
				int add = ec;

				if (add == sr)
					add--;

				if (from == er) {
					rem = ec + 1;
				}
				if (from <= er) {
					// System.out.println(to + " " + from + " " + rem + " " + er + " " + ec);
					mat.get(to).add(add, mat.get(from).remove(rem));
				}
			}
		}
		return mat;
	}

	private static void print(ArrayList<ArrayList<Integer>> mat) {

		for (int i = 0; i < mat.size(); i++) {
			for (int j = 0; j < mat.get(i).size(); j++) {
				System.out.print(mat.get(i).get(j) + " ");
			}
			System.out.println("");
		}

		System.out.println("");
	}
}
