package com.qjx.leetcode.every;

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
public class Solution303 {
    public static void main(String[] args) {
        int[] req = new int[]{-2,0,3,-5,2,-1};
        NumArray3 numArray = new NumArray3(req);
        System.out.println(numArray.sumRange(0, 2));
//        numArray.update(1,2);
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}

class NumArray3 {

    int length;

//    int[][] num;
    int[] preSum ;

    /**
     * preNum [i] = preNum[i-1]+num[i]
     * @param nums
     */
    public NumArray3(int[] nums) {
        preSum = new int[nums.length+1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] +nums[i];
        }
    }

    /**
     * int sumRange(int left, int right)
     * 返回数组nums中索引left和索引right之间（包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）
     *
     * nums[i]+…+nums[j]=preSum[j+1]−preSum[i]
     *
     * 于是，我们将preSum[i]定义改成：
     *
     * preSum[i+1] = nums[0] + nums[1] +…+nums[i]
     * preSum[i+1]=nums[0]+nums[1]+…+nums[i]
     *
     * 则有：
     *
     * nums[i] = preSum[i+1] - preSum[i ]
     * nums[i]=preSum[i+1]−preSum[i]
     *
     * 则有：
     *
     * nums[i] +…+nums[j]=preSum[j+1] - preSum[i]
     * nums[i]+…+nums[j]=preSum[j+1]−preSum[i]
     *
     * 即：sumRange(i, j)=preSum[j+1] - preSum[i]sumRange(i,j)=preSum[j+1]−preSum[i]
     *
     * 当 i = 0 时，只有让preSum[0]为0，才能让通式成立：nums[0]+…+nums[j]=preSum[j+1]
     *
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}