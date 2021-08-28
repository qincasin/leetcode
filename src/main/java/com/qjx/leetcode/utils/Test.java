package com.qjx.leetcode.utils;

/**
 * Created by qincasin on 2021/4/1.
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,3,2,0};
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(nums));
    }

}

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;

    }
//    public int findMin(int[] nums) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low < high) {
//            if (nums[low] < nums[high]) {
//                return nums[low];
//            }
//            int mid = low + ((high - low) >> 1);
//            if (nums[mid] > nums[low]) {
//                low = mid + 1;
//            } else if (nums[mid]==nums[low]){
//                low++;
//            }else {
//                high = mid;
//            }
//        }
//        return nums[low];
//    }
}
