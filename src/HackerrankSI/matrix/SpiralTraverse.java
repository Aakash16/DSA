package HackerrankSI.matrix;

import java.util.Scanner;

public class SpiralTraverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int d = 0; d < count; d++) {
			int size = sc.nextInt();

			int[][] mat = new int[size][size];
			for (int j = 0; j < size; j++) {

				for (int k = 0; k < size; k++) {
					mat[j][k] = (k + 1) + j * size;
				}
			}

			print(mat);

			printMatrixSpiral(mat);
			// sp(mat);
		}

		sc.close();
	}

	public static void printMatrixSpiral(int[][] matrix) {
		int numRows = matrix.length;
		int numColumns = matrix[0].length;
		int totalNodes = numRows * numColumns;
		int nodesVisted = 0;
		int startRow = 0;
		int startColumn = 0;
		while (nodesVisted < totalNodes) {
			int column = startColumn;
			while (column < numColumns - 1) {
				System.out.print(matrix[startRow][column] + " ");
				column++;
				nodesVisted++;
			}
			int row = startRow;
			while (row < numRows - 1) {
				System.out.print(matrix[row][column] + " ");
				row++;
				nodesVisted++;
			}
			while (column > startColumn) {
				System.out.print(matrix[row][column] + " ");
				column--;
				nodesVisted++;
			}
			while (row >= startRow) {
				System.out.print(matrix[row][column] + " ");
				row--;
				nodesVisted++;
			}
			startRow++;
			startColumn++;
			numColumns--;
			numRows--;
		}
	}

	static void spiral(int m, int n, int a[][]) 
    { 
        int i, k = 0, l = 0; 
        
        while (k < m && l < n) 
        { 
            for (i = l; i < n; ++i) 
            { 
                System.out.print(a[k][i]+" "); 
            } 
            k++; 

            for (i = k; i < m; ++i) 
            { 
                System.out.print(a[i][n-1]+" "); 
            } 
            n--; 

            if ( k < m) 
            { 
                for (i = n-1; i >= l; --i) 
                { 
                    System.out.print(a[m-1][i]+" "); 
                } 
                m--; 
            } 

            if (l < n) 
            { 
                for (i = m-1; i >= k; --i) 
                { 
                    System.out.print(a[i][l]+" "); 
                } 
                l++;     
            }         
        }
    } 
	private static void sp(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int len = m * n;
		int rs = 0, re = m - 1, cs = 0, ce = n - 1;
		int r = rs;
		int c = cs;

		boolean left = false, right = false, down = false, up = false;
		int loop = -1;
		for (int i = 0; i < len; i++) {

			if (loop == 3) {

				cs++;
				ce--;
				rs++;
				re--;

				if (up)
					cs--;

				if (left)
					re++;

				if (down)
					ce++;

				if (right)
					rs--;

				loop = -1;
			}
			// System.out.println("r:" +r + " c:" + c + " cs:" + cs + " ce:" + ce + " rs:" +
			// rs + " re:" + re);
			if (r == rs && c == cs) {
				left = false;
				right = true;
				down = false;
				up = false;
				loop++;
			}

			else if (r == rs && c == ce) {
				left = false;
				right = false;
				down = true;
				up = false;
				loop++;

			}

			else if (r == re && c == ce) {
				left = true;
				right = false;
				down = false;
				up = false;
				loop++;

			}

			else if (r == re && c == cs) {
				left = false;
				right = false;
				down = false;
				up = true;
				loop++;

			}

			if (i == 0)
				System.out.print(mat[r][c]);
			else
				System.out.print(" " + mat[r][c]);
			if (right) {
				c++;
			}
			if (down) {
				r++;
			}
			if (left) {
				c--;
			}
			if (up) {
				r--;
			}

		}
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