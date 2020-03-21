package com.qjx.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。 不考虑答案输出的顺序。 示例 1:
 *
 * 输入: s: "cbaebabacd" p: "abc"
 *
 * 输出: [0, 6]
 *
 * 解释: 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。  示例 2:
 *
 * 输入: s: "abab" p: "ab"
 *
 * 输出: [0, 1, 2]
 *
 * 解释: 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。 起始索引等于 2 的子串是 "ab",
 * 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: qincasin
 * @date: 2019/9/9/ 18:42
 */
public class FindAllAnagramsInAString {


  /**
   * 单向滑动窗口即可
   * 滑动过程中以p.length为整体滑动，同时执行s.charAt(i-p.length)--操作
   * @param s
   * @param p
   * @return
   */
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    int[] pCount = new int[26];
    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }
    int[] sCount = new int[26];

    char[] sArray = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
      sCount[s.charAt(i) - 'a']++;
      //首先小于p.length的不考虑，直接考虑大于p.length
      if (i >= p.length()) {
        sCount[s.charAt(i - p.length()) - 'a']--;
      }
      //比较两个数组中的值是否相等
      if (Arrays.equals(sCount, pCount)) {
        result.add(i - p.length() + 1);
      }
    }
    return result;
  }


}
