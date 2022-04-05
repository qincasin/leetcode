package com.qjx.leetcode.every;

import java.util.HashMap;

/**
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 update 和 sumRange 方法次数不大于 3 * 104 
 */
public class Solution307_2 {
    public static void main(String[] args) {
        int[] req = new int[]{1, 3, 5};
        NumArray2 numArray = new NumArray2(req);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}

/**
 * 解题思路
 * 针对不同的题目，我们有不同的方案可以选择（假设我们有一个数组）：
 *
 * 数组不变，求区间和：「前缀和」、「树状数组」、「线段树」
 * 多次修改某个数（单点），求区间和：「树状数组」、「线段树」
 * 多次修改某个区间，输出最终结果：「差分」
 * 多次修改某个区间，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
 * 多次将某个区间变成同一个数，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
 * 这样看来，「线段树」能解决的问题是最多的，那我们是不是无论什么情况都写「线段树」呢？
 *
 * 答案并不是，而且恰好相反，只有在我们遇到第 4 类问题，不得不写「线段树」的时候，我们才考虑线段树。
 *
 * 因为「线段树」代码很长，而且常数很大，实际表现不算很好。我们只有在不得不用的时候才考虑「线段树」。
 *
 * 总结一下，我们应该按这样的优先级进行考虑：
 *
 * 简单求区间和，用「前缀和」
 * 多次将某个区间变成同一个数，用「线段树」
 * 其他情况，用「树状数组」
 *
 */

class NumArray2 {

    int length;

    int[] preSum;

    int[] nums;

    public NumArray2(int[] nums) {
        this.length = nums.length;;
        preSum = new int[nums.length + 1];
        this.nums = nums;
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }


//        for (int i = 0; i < num.length; i++) {
//            for (int j = i; j < num.length; j++) {
//                int sum = 0;
//                for (int k = i; k <=j; k++) {
//                    sum +=nums[k];
//                }
//                num[i][j] = sum;
//            }
//        }
    }


    /**
     * void update(int index, int val) 将 nums[index] 的值 更新 为 val
     *
     * @param index
     * @param val
     */
    public void update(int index, int val) {
        //更新数据
        if (index > length) {
            return;
        }
        nums[index] = val;
        preSum = new int[preSum.length];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

    }

    /**
     * int sumRange(int left, int right)
     * 返回数组nums中索引left和索引right之间（包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}