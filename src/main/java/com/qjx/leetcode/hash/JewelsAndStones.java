package com.qjx.leetcode.hash;


import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 */
public class JewelsAndStones {
    /**
     * 简单讲就是，给你一个代表不同宝石的字符串，和一个代表石头的字符串，从石头字符串里找出属于宝石的石头，并返回个数。
     * 注意，区分大小写即a和A不一样。
     * 时间复杂度 O(s+j)  s是S的长度，j是J的长度
     * 空间复杂度O(J)
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int res = 0;

        Set<Character> set = new HashSet<>();

        for(int i=0;i<=J.length()-1;i++){
            char c=J.charAt(i);
            set.add(c);
        }
        for (int j =0;j<=S.length()-1;j++){
            if(set.contains(S.charAt(j))){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();

        String J = "aA";
        System.out.println(solution.numJewelsInStones(J,"aAAbbbb"));
    }



}
