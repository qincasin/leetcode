package com.qjx.leetcode.array;

import java.util.Arrays;

/**
 * 数组分区1
 *
 * @author casin
 * @create 2018-09-13 12:41
 **/
public class ArrayPartitionI {
    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     * @param nums
     * @return
     */
    /**
     * Input: [1,4,3,2]
     *
     * Output: 4
     * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        //将数组排序，然后取0,2,3,4,6 即可
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i+=2) {
            result +=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num ={1,4,3,2};
        System.out.println(arrayPairSum(num));

    }

}
