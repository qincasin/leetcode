package com.qjx.leetcode.bit;
import java.util.Date;

/**
 * 到达一个目标数字的最少步数
 * 754. Reach a Number
 * You are standing at position 0 on an infinite number line. There is a goal at position target.
 *
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 *
 * Return the minimum number of steps required to reach the destination.
 *
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example 2:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 */
public class ReachANumber {

    public int reachNumber(int target) {

        target = Math.abs(target);
        int sum = 0;
        int n = 0;
        while (target > sum){
            n++;
            sum +=n;
        }
        System.out.println(sum);

        if(sum == target){
            return n;
        }
        int res = target - sum;
        if((res & 1) ==0){
            //偶数
            return n;
        }else {
            //在判断 是偶数则为n+1 奇数则是n+2
            return n + ((n & 1) == 0 ? 1 :2);
        }
    }


    public int reachNumber2(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0){
            target -= ++k;
        }
        return (target & 1) == 0 ? k : k + 1 + k%2;
    }

    public static void main(String[] args) {
        ReachANumber solution = new ReachANumber();
        int target = 3;
        int res = solution.reachNumber2(target);
        System.out.println(res);
        System.out.println(new Date());


    }


}
