package com.qjx.leetcode.hash;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 540. Single Element in a Sorted Array
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray {
    /**
     * map key value方法
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        if(nums.length<1) {
            return -1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        System.out.println(map);
        for (Integer integer : map.keySet()) {
            if(map.get(integer).equals(1)){
                return integer;
            }
        }
        return -1;

    }

    /**
     * 0 ^ 1 = 1
     * 1 ^ 1 = 0
     * 0 ^ 0 = 0
     * 1 ^ 0 = 1
     * 利用相同值^运算为0
     * @return
     */
    public int singleNonDuplicate2(int[] nums){
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }

    /**
     * 双指针法 O(logN)
     * @param nums
     * @return
     */
    public int singleNonDuplicate3(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid - 1]){
                    hi = mid;
                }else{
                    lo = mid;
                }

            }else{
                if(nums[mid] == nums[mid - 1]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        SingleElementInASortedArray solution = new SingleElementInASortedArray();
        int[] nums = new int[]{3,3,7,7,10,11,11};
        int result = solution.singleNonDuplicate3(nums);
        System.out.println(result);
        System.out.println(new Date());
    }

}
