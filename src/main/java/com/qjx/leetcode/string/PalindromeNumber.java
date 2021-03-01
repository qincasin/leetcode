package com.qjx.leetcode.string;

import java.util.Date;

/**
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @ClassName PalindromeNumber
 * @Description 回文数字
 * @Author qincasin
 * @Date 2018/12/13 10:22
 * @Version 1.0
 **/
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String str = x + "";
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x){
        String str = x+"";
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            if(str.charAt(left++)!=str.charAt(right--)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x = 121;
        boolean res = solution.isPalindrome(x);
        System.out.println(res);
        System.out.println(new Date());
    }
}
