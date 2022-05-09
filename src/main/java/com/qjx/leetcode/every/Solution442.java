package com.qjx.leetcode.every;

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 */
public class Solution442 {
    public static void main(String[] args) {
        Solution442 s  = new Solution442();
        System.out.println(s.findDuplicates(new int[]{3}));
    }

    public List<Integer> findDuplicates(int[] nums) {
//        return method1(nums);
        return method2(nums);
    }

    private List<Integer> method2(int[] nums) {
        List<Integer> resp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num-1]>0){
                nums[num - 1] *= -1;
            }else {
                resp.add(num);
            }
        }
        return resp;
    }

    private List<Integer> method1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resp =new ArrayList<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                resp.add(num);
            }
        }

        return resp;
    }


}
