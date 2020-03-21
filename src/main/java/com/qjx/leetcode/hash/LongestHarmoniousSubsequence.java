package com.qjx.leetcode.hash;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 594. Longest Harmonious Subsequence
 *
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        /**
         * key : num
         * value : num的次数
         */
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int max = 0;
        for (Integer num : map.keySet()) {
            if(map.containsKey(num+1)){
                max=Math.max(max,map.get(num)+map.get(num+1));
            }
        }

        return max;

    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        int result = solution.findLHS(nums);
        System.out.println(result);
        System.out.println(new Date());

    }

}
