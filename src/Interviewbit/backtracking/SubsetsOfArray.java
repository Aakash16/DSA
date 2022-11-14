package Interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetsOfArray {

	public static void main(String[] args) {

		
		System.out.println(subsets(new ArrayList<Integer>(Arrays.asList(1,2,3))));

	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

		Collections.sort(A);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		printSubs(A, A.size(), -1, new ArrayList<Integer>(), list);
		return list;
    }
    
    private static void printSubs(ArrayList<Integer> A, int n, int index, 
        ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (index == n) {
            return ;
        }

         
        ans.add(new ArrayList<Integer>(list));
        
        for (int i = index + 1; i < n; i++) {

            list.add(A.get(i));
            printSubs(A, n, i, list, ans);
            list.remove(list.size() - 1);
        }
        return;
    }

}
