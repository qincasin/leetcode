package com.qjx.leetcode.bit;
/**
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 *
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 * Example 2:
 *
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 *
 *
 *
 *
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    /**
     * n&(n-1)的妙用  (转)
     * 今天无聊拿起《编程之美》看了下，发现原来n&(n-1)还有很多妙用。原理:n与n-1的区别在于,对于n,从右向左数的第一个"1"开始一直到右,和n-1,完全相反
     * n&(n-1)作用：将n的二进制表示中的最低位为1的改为0，先看一个简单的例子：
     * n = 10100(二进制），则(n-1) = 10011 ==》n&(n-1) = 10000
     * 可以看到原本最低位为1的那位变为0。
     * 弄明白了n&(n-1)的作用，那它有哪些应用？
     * 1. 求某一个数的二进制表示中1的个数
     * while (n >0 ) {
     *       count ++;
     *       n &= (n-1);
     * }
     *
     * 2. 判断一个数是否是2的方幂
     * n > 0 && ((n & (n - 1)) == 0 )
     *
     * 3. 计算N!的质因数2的个数。
     * 容易得出N!质因数2的个数 = [N / 2] + [N / 4] + [N / 8] + ....
     * 下面通过一个简单的例子来推导一下过程：N = 10101(二进制表示）
     * 现在我们跟踪最高位的1，不考虑其他位假定为0，
     * 则在
     * [N / 2]    01000
     * [N / 4]    00100
     * [N / 8]    00010
     * [N / 8]    00001
     * 则所有相加等于01111 = 10000 - 1
     * 由此推及其他位可得：(10101)!的质因数2的个数为10000 - 1 + 00100 - 1 + 00001 - 1 = 10101 - 3(二进制表示中1的个数)
     *
     * 推及一般N!的质因数2的个数为N - （N二进制表示中1的个数）
     *
     * 目前看到只有这些应用，但只要理解了n&(n-1)的原理及作用，在碰到相关问题时也会比较容易解决。
     */
    /**
     * 采用n&(n-1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        System.out.println(Integer.toBinaryString(n));
        int count = 0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.bitCount(11));
    }


    public  int bitCount(int n){
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0F0F0F0F;
        return (n * 0x01010101) >>> 24;
    }




}
