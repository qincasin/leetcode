package com.qjx.leetcode.math;

/**
 * 343. Integer Break
 * 大概意思就是,给一个n(n>=2),求相加等于n且乘积最大的一组整数的积
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    /**
     * 数学题目解法
     * 参考https://www.cnblogs.com/zywscq/p/5415303.html
     * 解法二（当成数学题来做就好）：
     * <p>
     * 由均值不等式(n个数的算术平均数大于等于它们的几何平均数)：
     * <p>
     * \mathbf{A}_n =  \frac{x_1 + x_2 + \cdots + x_n}{n}    >=   \mathbf{G}_n = \sqrt[n]{x_1 \cdot x_2 \cdots x_n}
     * <p>
     * 得：当把输入的n拆分成几个相等的数时它们的积最大。
     * <p>
     * 那么问题来了，拆分成几个呢？
     * <p>
     * 为了方便使用导数，我们先假设我们可以把n拆分成实数。那么设每一个数为x,则一共有n/x个数。
     * <p>
     * 设它们的积为f(x),则f(x)=x(n/x)，那么怎么求f(x)最大值呢？求导数！
     * <p>
     * f′(x)=(n/x2)  *  x(n/x)  * (1-lnx)
     * <p>
     * 当x=e时取极大值。
     * <p>
     * 而我们题目里规定x为整数，那么我们只需要取的x越靠近e越好。那么2<e<3，而且e=2.71828...，所以取3是最好的，如果取不到3就取2。
     * <p>
     * 幂运算复杂度为O(lgn)，所以这个算法复杂度为O(lgn)。
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        //A more mathematic solution
        //We can prove that when N is even, N/2 * N/2 is largest; when N is odd, (N - 1)/2 * (N + 1)/2 is the largest
        //Also we have N/2 * N/2 > N --> N > 4
        //             (N - 1)/2 * (N + 1)/2 > N --> N >= 5
        //So when N > 4, we can do the calculation

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;


//        if (n == 2) {
//            return 1;
//        } else if (n == 3) {
//            return 2;
//        } else if (n % 3 == 0) {
//            return new Double(Math.pow(3, n / 3)).intValue();
//        } else if (n % 3 == 1) {
//            return new Double(2 * 2 * Math.pow(3, (n - 4) / 3)).intValue();
//        } else {
//            return new Double(Math.pow(3, n / 3)).intValue();
//        }
    }

    public static void main(String[] args) {
        Integer n = 5;
        IntegerBreak solution = new IntegerBreak();
        int result = solution.integerBreak(n);
        System.out.println(result);

    }


}
