package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = solution.twoSum(arr, 9);
        System.out.println(Arrays.toString(result));

        /**
         *
         * 2/8 --  5s
         *
         * 4/7  40s
         *
         * 3/9 1'30s
         *
         * 1/5/6 60s
         *
          */


    }


}
