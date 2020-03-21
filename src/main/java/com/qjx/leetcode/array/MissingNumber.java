package com.qjx.leetcode.array;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * 268. Missing Number
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 *
 *
 * 给定一个数组，求出数组中缺失的数字
 * 确实的数字
 */
public class MissingNumber {
    /**
     *  方法一 ： 数组的个数n 对其n个数字求和，然后减去数组中的个数
     *  时间复杂度O(n) 空间复杂度 O(1)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        return (n+1)*n/2-sum;
    }


    /**
     *  方法二 ： 利用bit方法 亦或
     *  a^0 = 0^a =a
     *  a^b^a = b
     *  a^b = b^a
     *  首先把0-n所有的数全部亦或一遍，
     *  接着再把这个数组中的数字亦或一遍，
     *  这样出现过两次的都被置为零
     *  时间复杂度 O(n) 空间复杂度(1)
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res^=i;
            res^=nums[i];
        }

        return res;
    }

    /**
     * 方法三 直接求
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 0 && nums[i] < len && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return len;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        System.out.println(Arrays.toString(A));
    }


    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = new int[]{3,0,1};
        System.out.println(solution.missingNumber(nums));
        System.out.println(solution.missingNumber2(nums));
        System.out.println(solution.missingNumber3(nums));

    }


}
