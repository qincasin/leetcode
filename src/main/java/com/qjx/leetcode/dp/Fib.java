package com.qjx.leetcode.dp;

/**
 * Created by qincasin on 2021/3/1.
 */
public class Fib {
    /**
     * 递归法
     * @param n
     * @return
     */
    public int fib(int n){
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     *
     * dp table  数组迭代解法
     * 自底向上
     * @param n
     * @return
     */
    public int fib2(int n){
        if(n==1||n==2) return 1;
        int[] arr = new int[31];
        arr[1] = arr[2] = 1; //base
        for (int i = 3; i <= n; i++) {
            arr[i] =arr[i-2] + arr[i-1]; //dp 状态转换
        }
        return arr[n];
    }

    /**
     * dp 自顶向下
     * @param n
     * @return
     */
    public int fib4(int n){
        if(n==0) return 0;
        int[] arr = new int[31];
        return helper(arr,n);


    }

    private int helper(int[] arr, int n) {
        if (n==1||n==2) return 1;
        if (arr[n]!=0) return arr[n];
        arr[n] = helper(arr,n-1)+ helper(arr,n-2);
        return arr[n];
    }


    /**
     * 替换法
     * @param n
     * @return
     */
    public int fib3(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        int cur = 1,pre = 1;
        for (int i = 3; i <=n; i++) {
            int sum = cur + pre;
            pre = cur;
            cur = sum;
        }
        return cur;
    }




    public static void main(String[] args) {
        Fib f = new Fib();
        System.out.println(f.fib4(20));
        System.out.println(f.fib3(20));
    }
}
