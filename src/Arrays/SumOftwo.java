package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;


public class SumOftwo {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        System.out.println("Indices: " + Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> dup_map = new HashMap<>();
        int c = 0;
        for (Integer a :
                nums) {
            if (map.get(a) != null) {
                dup_map.put(a, c++);
            } else {
                map.put(a, c++);
            }

        }
        Arrays.sort(nums);
        for (int num : nums) {
            int diff = target - num;
            if (map.get(diff) != null) {
                if (Objects.equals(map.get(diff), map.get(num))) {
                    result[1] = dup_map.get(diff);
                    result[0] = map.get(num);
                    break;
                } else {
                    result[0] = map.get(diff);
                    result[1] = map.get(num);
                    break;
                }
            }
        }

        Arrays.sort(result);

        return result;
    }

}
