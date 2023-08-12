package com.qjx.leetcode.every;

import org.apache.commons.math3.analysis.function.Min;

public class Solution668 {
    public static void main(String[] args) {
        Solution668 s = new Solution668();
        int kthNumber = s.findKthNumber(3, 3, 5);
        System.out.println(kthNumber);
    }

    public int findKthNumber(int m, int n, int k) {
        //二分查找
        int left = 1;
        int right = m*n;
        while (left<right){
            int mid = left + (right-left)/2;
            if (count(m,n,mid)>=k){
                //乘法表里面小于等于 mid 的数字大于 k，不符合要求， right 左移
                right = mid;
            }else {
                //代表乘法表里面小于等于mid的数字  <k ,left 右移
                left = mid+1;
            }
        }
        return left;
    }

    // 统计乘法表中有多少个等于k的数目
    /**
     * ∑i=1 m min(x/i,n)   统计 从1 开始 ，sum (min(x/i,m)) 的和
     * @param m
     * @param n
     * @param k
     * @return
     */
    private int count(int m,int n ,int k){
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(k/i,n);
        }
        return res;
    }
}

/**
 *         //二分查找
 *         int left = 1;
 *         int right = m * n;
 *         while (left<right){
 *             int mid = left + (right-left)/2;
 *             if (count(m,n,mid)>=k){
 *                 //乘法表里面小于 mid 的数字大于 k，不符合要求， right 左移
 *                 right = mid;
 *             }else {
 *                 left = mid+1;
 *             }
 *         }
 *         return left
 */