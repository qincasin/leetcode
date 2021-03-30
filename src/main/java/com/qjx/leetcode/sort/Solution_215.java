package com.qjx.leetcode.sort;

import java.util.Collections;

/**
 * Created by qincasin on 2021/3/30.
 */
public class Solution_215 {
    public int findKthLargest(int[] nums,int k){
        if (nums.length ==0){
            return 0;
        }
        return quickSort(nums,0,nums.length-1,nums.length-k);

    }

    private int quickSort(int[] nums, int l, int r, int k) {
        if(l==r){
            return nums[l];
        }
        int p = partition(nums,l,r);
        if(p==k){
            return nums[p];
        } else if (k < p) {
           return quickSort(nums,l,p-1,k);
        }else {
            return quickSort(nums,p+1,r,k);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l-1;
        for (int j = l; j < r; j++) {
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,r,i+1);
        return i+1;
    }
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        Solution_215 solution = new Solution_215();
        int kthLargest = solution.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}
