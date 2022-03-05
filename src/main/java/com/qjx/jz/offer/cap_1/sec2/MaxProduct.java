package com.qjx.jz.offer.cap_1.sec2;

import java.util.Arrays;

/**
 * ["abcw","foo","bar","fxyz","abcdef"]
 * 3 *  3 =  6
 * fxyz * abcw = 4 * 4 = 16
 *
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * 示例 2:
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct a = new MaxProduct();

        String[] words = new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"};
        int resp = a.maxProduct(words);
        System.out.println(resp);
        a.aaa2();
    }

    public void aaa2() {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.print(" " + i + " " + j + " ;");
            }
            System.out.println();
        }
    }

    /**
     *   总的时间复杂度  O(nk + n^2)
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int[][] flags = new int[words.length][26];
        //第一步 初始化每个字符串对应的hash表 如果字符数组长度为n，每个字符的长度为k，则初始化hash表的时间复杂度是 O(nk)
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                flags[i][words[i].charAt(j) - 'a'] = 1;
            }
        }
        for (int i = 0; i < flags.length; i++) {
            System.out.println(Arrays.toString(flags[i]));
        }
        //第二步 根据hash表判断每个字符串是否包含相同的字符
        //从hash表中两两比较对应的字符串是否存在相同 ---
        // i = 0 ,j = 1 2 3 4
        // i = 1,j = 2 3 4
        // ...
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                //从a---z判断某个字符是否再两个字符串对应的hash表中都出现了；
                for (; k < 26; k++) {
                    if (flags[i][k] == 1 && flags[j][k] == 1) {
                        break;
                    }
                }
                //走到这里说明，数组中的i和j对应的字符串中没有相同的字母，所以需要取个最大值
                if (k == 26) {
                    int tmp = words[i].length() * words[j].length();
                    result = Math.max(tmp, result);
                }
            }
        }
        return result;
    }

}
