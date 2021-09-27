//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5975 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
//        int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
//        System.out.println(abcabcbb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

//            return solutionByHashMap(s);
            return solutionByHashMap2(s);
        }

        /**
         * 同样是快慢指针做法，只是hashSet更方便一些
         * 当遇到重复的值之后，set中的值直接remove掉 j的下标对应的值 也就是  set.remove(j);
         * 因为set中是不重复的，所以res的值取   res = Math.max(res,set.size());
         *
         * @param s
         * @return
         */
        private int solutionByHashSet(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int res = 0;
            Set<Character> set = new HashSet();
            for (int i = 0, j = 0; i < s.length(); i++) {
                //注意这个地方是while
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j++));
                    System.out.println("remove:" + s.charAt(j));
                }
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
            return res;

        }

        /**
         * 快慢指针， 快指针指向当前节点
         * j = Math.max(j,s.charAt(i)+1); j指向不重复节点的下一个节点位置
         * res 的值 也就是等于  res = Math.max(res,当前指向的节点的下标(i)-j+1)
         *
         * @param s
         * @return
         */
        private int solutionByHashMap(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Integer res = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                res = Math.max(res, i - j + 1);
            }
            return res;
        }

        /**
         * 2021-09-27
         *
         * @param s
         */
        public int solutionByHashMap2(String s) {
            Map<Character, Integer> map = new HashMap<>();
            Integer res = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                res = Math.max(res, i - j + 1);
            }
            return res;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}