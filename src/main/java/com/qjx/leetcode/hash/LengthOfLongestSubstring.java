package com.qjx.leetcode.hash;

import lombok.var;

/**
 * Created by qincasin on 2021/3/4.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    /**
     * 能想到的解决方案 ： 滑动窗口 hash 双指针
     */

    /**
     * 滑动窗口的右边界不断的右移，只要没有重复的字符，就持续向右扩大窗口边界。
     * 一旦出现了重复字符，就需要缩小左边界，直到重复的字符移出了左边界，然后继续移动滑动窗口的右边界。
     * 以此类推，每次移动需要计算当前长度，并判断是否需要更新最大长度，最终最大的值就是题目中的所求。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 ){
            return 0;
        }
        int[] fre = new int[256];
        int left = 0,result = 0;
        int right = -1;
        while (left < s.length()) {
            if(right+1<s.length()&&fre[s.charAt(right+1)]==0){
                fre[s.charAt(right+1)] ++;
                right++;
            }else {
//                fre[s.charAt(left)]--;
//                left++;
                fre[s.charAt(++left)]--;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
    public int max(int a,int b){
        if (a>b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        String str ="b";
        var i = str.charAt(0) - 'a';
        System.out.println(i);
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
//        String req  = "abcabcbb";
//        String req  = "pwwkew";
//        String req  = "abbcdb";
//        String req  = " ";
        String req  = "aabaab!bb";
        Integer result =0;
        result = s.lengthOfLongestSubstring(req);

        System.out.println(result);
    }

}
