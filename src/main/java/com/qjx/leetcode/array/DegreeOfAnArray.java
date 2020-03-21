package com.qjx.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目给了我们一个 nums array， 让我们首先找到 出现最多次数的数字（可能多于1个），然后在这些数字中，找到一个 长度最小的 数字。返回它的长度。
 *
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *
 * @author casin
 * @create 2018-10-12 11:23
 **/
public class DegreeOfAnArray {

    /**
     * 定义 HashMap<num,int[firstIndex,lastIndex,Occurrence]>
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {

        Map<Integer,Integer[]> map = new HashMap<>();
        //频率最大数据的值
        int maxFre = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            //包含
            if(map.containsKey(nums[i])){
                map.get(nums[i])[1]=i;
                map.get(nums[i])[2]++;
            }else {
                //不包含
                //firstIndex、lastIndex、出现频率
                map.put(nums[i],new Integer[]{i,i,1});
            }
            //
            maxFre = Math.max(maxFre,map.get(nums[i])[2]);
        }
        for(int num:map.keySet()){
            if(maxFre==map.get(num)[2]){
                minLen=Math.min(minLen,map.get(num)[1]-map.get(num)[0]+1);
            }
        }
        return minLen;
    }




    public static void main(String[] args) {
        Integer num = Integer.MAX_VALUE;
        System.out.println(num-1);
        int[] nums = {1,2,2,3,1,4,2};
//        Map<Integer,Integer[]> result =  findShortestSubArray(nums);
//        result.forEach((p,v)->{
//            System.out.println(p+ Arrays.toString(v));
//        });



    }

}
