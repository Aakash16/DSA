package HackerrankSI.matrix;
public class MatrixRotate {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3, 4}, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {13, 14, 15, 16} };
		print(mat);

		int len = mat[0].length;

		for (int i = 0; i < 2; i++) {

			for (int j = i; j < len -1 - i; j++) {

				int temp = mat[i][j];
				mat[i][j] = mat[j][len-1-i];
				mat[j][len-1-i] = mat[len-1-i][len-1-j];
				mat[len-1-i][len-1-j] = mat[len-1-j][i];
				mat[len-1-j][i] = temp;
			}
		}

		print(mat);
	}

	private static void print(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("");
	}
}
