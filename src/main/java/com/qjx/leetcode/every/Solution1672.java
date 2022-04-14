package com.qjx.leetcode.every;

public class Solution1672 {
    public static void main(String[] args) {
        Solution1672 s = new Solution1672();
//        int[][] arr = new int[][]{{1,2,3},{3,2,1}};
        int[][] arr = new int[][]{{1,5},{7,3},{3,5}};
        System.out.println(s.maximumWealth(arr));
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
