package com.qjx.leetcode.every;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class Solution713 {
    public static void main(String[] args) {
        Solution713 s = new Solution713();
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        int resp = s.numSubarrayProductLessThanK(nums, k);
        System.out.println(resp);

    }

    /**
     * 两个指针之间的子数组的乘积小于等于k，p2 ++; ----> right
     * 两个指针之间的子数组的乘积大于或者等于k，left ++; ----- left ++;
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }
}
