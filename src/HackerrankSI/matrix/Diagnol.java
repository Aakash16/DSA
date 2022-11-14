package HackerrankSI.matrix;

public class Diagnol {

	public static void main(String[] args) {
		int[][] mat = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(mat);

		int len = mat[0].length;

		int r = 0;
		int c = len - 1;
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j <= i; j++) {
				
				r = j;
				c = len - 1 - i + j;
				sum += mat[r][c];
				
			}
			
			System.out.print(sum + " ");
			sum = 0;
		}
		
		for (int i = 1; i < mat.length; i++) {

			for (int j = 0; j < mat.length - i; j++) {
				
				r = i + j;
				c = j;
				sum += mat[r][c];
			}
			
			System.out.print(sum + " ");
			sum = 0;
		}
	}


	private static void print(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
