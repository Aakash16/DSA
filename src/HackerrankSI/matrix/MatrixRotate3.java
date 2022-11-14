package HackerrankSI.matrix;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixRotate3 {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
		mat.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		mat.add(new ArrayList<>(Arrays.asList(7, 8, 9, 10)));
		mat.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
		mat.add(new ArrayList<>(Arrays.asList(19, 20, 21, 22)));
		print(mat);

		int len = mat.get(0).size();

		for (int i = 0; i < len/2; i++) {

			for (int j = i; j < len -1 - i; j++) {
				int temp = mat.get(i).get(j);
				mat.get(i).set(j,mat.get(len-1-j).get(i));
				mat.get(len-1-j).set(i,mat.get(len-1-i).get(len-1-j));
				mat.get(len-1-i).set(len-1-j,mat.get(j).get(len-1-i));
				mat.get(j).set(len-1-i,temp);
			}
		}

		print(mat);
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
