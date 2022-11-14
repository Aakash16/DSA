package HackerrankSI.matrix;
import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		if (count <= 0) {
			sc.close();
			return;
		}

		for (int d = 0; d < count; d++) {
			int row1 = sc.nextInt();
			int col1 = sc.nextInt();

			int[][] mat1 = new int[row1][col1];

			for (int j = 0; j < row1; j++) {

				for (int k = 0; k < col1; k++) {
					mat1[j][k] = sc.nextInt();
				}
			}

			int row2 = sc.nextInt();
			int col2 = sc.nextInt();

			int[][] mat2 = new int[row2][col2];

			for (int j = 0; j < row2; j++) {

				for (int k = 0; k < col2; k++) {
					mat2[j][k] = sc.nextInt();
				}
			}

			for (int i = 0; i < row1; i++) {

				for (int j = 0; j < col2; j++) {

					int sum = 0;
					for (int k = 0; k < row2; k++) {

						sum += mat1[i][k] * mat2[k][j];
					}
					System.out.print(sum + " ");

				}
				System.out.println();

			}
		}

	}

}
