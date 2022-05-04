package com.qjx.leetcode.every;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Solution905 {
    public static void main(String[] args) {
        Solution905 s = new Solution905();
        int[] req = new int[]{3, 1, 2, 4};
        long l = ~(-1L << 11);
        System.out.println(l);
        System.out.println("------------------");
        int x = 1 << 1;
        int y = 1 >>6;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toUnsignedString(y,2));
//        for (int i = 0; i < 5000; i++) {
//            System.out.println(i & l);
//        }

//        int[] resp = s.sortArrayByParity(req);
//        System.out.println(Arrays.toString(resp));
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                swap(nums, j, i);
                i++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
