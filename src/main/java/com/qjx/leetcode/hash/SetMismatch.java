package com.qjx.leetcode.hash;

import java.util.*;

/**
 * Created by qincasin on 2020/6/2.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap(nums.length);
        int count = 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                res.add(num);
                if (!map.get(num).equals(count)) {
                    res.add(count);
                }
            }
            map.put(num, count);
            count++;
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 10;
        System.out.println(1);
        SetMismatch  setMismatch  =new SetMismatch();
        int[] nums = new int[]{2,2};
        int[] errorNums = setMismatch.findErrorNums(nums);
        System.out.println(Arrays.toString(errorNums));
    }
}
