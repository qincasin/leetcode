package com.qjx.jz.offer.cap_1.sec2;

import java.util.Arrays;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 * <p>
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class CountBits {
    public static void main(String[] args) {
        CountBits c = new CountBits();
        int[] ints = c.countBits2(4);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 最普通的方式   循环遍历每一个数字，然后转变为 该数字 包含1 的个数的问题
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j != 0) {
                res[i]++;
                j = j & (j - 1);
            }
        }
        return res;
    }


    /**
     * 由前面分析 可知道 i&(i-1) 是将i 的二进制形式中的最右边的1变成0，也就是说整数i的二进制形式中的1
     * 的个数比 i&(i-1) 的二进制形式中的1的个数 多1;
     *
     * @param n
     * @return
     */
    public int[] countBits2(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
