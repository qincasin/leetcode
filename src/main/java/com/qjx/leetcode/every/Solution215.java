package com.qjx.leetcode.every;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/by-feifeisha-fhi3/
 *
 */
public class Solution215 {
    public static void main(String[] args) {
        Solution215 s = new Solution215();
        System.out.println(s.findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int maxIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>nums[maxIndex]){
                    maxIndex = j;
                }
            }
            if (maxIndex!=i){
                int temp = nums[i];
                nums[i] = nums[maxIndex];
                nums[maxIndex] = temp;
            }
        }
        return nums[k-1];
    }
}
