package com.qjx.leetcode.every;

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。 
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * 通过
 */
public class Solution796 {
    public static void main(String[] args) {
        String s = "01234";
        System.out.println(s.substring(1));
        Solution796 solution796 = new Solution796();
        boolean b = solution796.rotateString("abcde", "abced");
        System.out.println(b);
    }

    public boolean rotateString(String s, String goal) {
        int len = s.length();
        String str = s;
        if (str.equals(goal)) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            int index = 1;
            if (i == len - 1) {
                str = s;
            } else {
                str = str.substring(index) + cur;
            }
            if (str.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }


}
