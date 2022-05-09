package com.qjx.leetcode.every;

import java.util.Arrays;

public class Solution942 {

    public static void main(String[] args) {
        Solution942 s = new Solution942();
        int[] resp = s.diStringMatch("IDID");
        System.out.println(Arrays.toString(resp));
    }

    public int[] diStringMatch(String s) {
        int len = s.length();
        int k = 0;
        int j = len;
        int[] resp = new int[len+1];
        for (int i = 0; i < len; i++) {
            if ('I'==s.charAt(i)){
                resp[i] = k++;
            }else {
                resp[i] =  j--;
            }
        }
        resp[s.length()] = k;
        return resp;
    }
}
