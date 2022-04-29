package com.qjx.leetcode.every;

import java.util.Arrays;

public class Solution821 {
    public static void main(String[] args) {
        Solution821 solution821 = new Solution821();
        String s = "loveleetcode";
        char c = 'e';
        int[] ints = solution821.shortestToChar(s, c);
    }

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n + 1);
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = i - j;
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) j = i;
            if (j != -1) ans[i] = Math.min(ans[i], j - i);
        }
        return ans;
    }
}
