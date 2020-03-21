package com.qjx.leetcode.array;

import java.util.Arrays;

/**
 * 695. Max Area of Island
 * 找出给定数组中最大连续1的个数
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 */
public class MaxConsecutiveOnes {

    /**
     *  遍历一遍数组，用cnt来记1的个数，用res来计算最终结果
     *  如果出现了0，则cnt为0，否则自增，最后比对cnt和res的值
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {

        int res = 0,cnt =0;
        for(int i:nums){
            cnt=(i==0)?0:cnt+1;
            res=Math.max(res,cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(num));
//        Arrays.equals()
        Arrays.hashCode(num);

    }
}
