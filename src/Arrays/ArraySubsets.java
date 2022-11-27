package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySubsets {
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(3, 15, 8, 23 );
        List<List<Integer>> ans = new ArrayList<>();
        subsets(input, input, 1, input.size(), ans);
        for (List<Integer> i:ans
             ) {
            for (int s:i
                 ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> subsets(List<Integer> sublist, List<Integer> input, int idx, int size, List<List<Integer>> ans){
        if(idx == size + 1)
            return ans;

        List<Integer> sub = new ArrayList<>();
        for (Integer integer : sublist) {
            sub.add(integer);
            ans.addAll(Collections.singleton(new ArrayList<Integer>(sub)));
        }

        ArrayList<Integer>  subList = new ArrayList<Integer>(input.subList(idx, size));
        return subsets(subList ,input,idx+1, size, ans);
    }
}
