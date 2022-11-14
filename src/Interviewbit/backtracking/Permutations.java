package Interviewbit.backtracking;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		return ans;
	}

	private static void getPermut(ArrayList<Integer> A, int N, int idx, ArrayList<ArrayList<Integer>> ans) {

		if (idx == N - 1)
			return;

		for (int i = idx; i < A.size(); i++) {

			getPermut(A, N, idx + 1, ans);
			
			int t = A.remove(i);
			A.add(0, t);

			System.out.println(A);
			ans.add(new ArrayList<Integer>(A));

			
		}

		return;
	}

}
