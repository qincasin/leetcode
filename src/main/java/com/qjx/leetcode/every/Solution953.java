package com.qjx.leetcode.every;


public class Solution953 {
    public static void main(String[] args) {
        Solution953 s  = new Solution953();
        String[] words = new String[]{"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        boolean alienSorted = s.isAlienSorted(words, order);
        System.out.println(alienSorted);
    }
    int[] alpha = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i)-'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if (compare(words[i],words[i+1])>0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 大于 0 代表 str1 > str2
     * 小于或者等于0 代表 str2 <=str2
     * @param str1
     * @param str2
     * @return
     */
    private int compare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int min = Math.min(l1, l2);
        for (int i = 0; i < min; i++) {
            // 数据中的值越靠前代表字母越大
            if (str1.charAt(i) != str2.charAt(i)){
                return alpha[str1.charAt(i)-'a']-alpha[str2.charAt(i)-'a'];
            }
        }
        return l1 - l2;
    }
}
