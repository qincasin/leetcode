//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4029 👎 0


package leetcode.editor.cn;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "aaaaaaaa";
//        System.out.println(s.substring(1, 5));
        System.out.println(solution.doLongestPalindromeByDp(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return doLongestPalindromeByDp(s);
//        return null;
        }

        /**
         * dp 解法
         *
         * @param s
         * @return
         */
        private String doLongestPalindromeByDp(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            String res = "";
            int max = 0;
            boolean[][] dp = new boolean[s.length()][s.length()];
            // i [0---s.length-1]
            // j [0----i]
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((i - j <=2) || dp[j + 1][i - 1]);
                    if (dp[i][j]) {
                        if (i - j + 1 >= max) {
                            max = i - j + 1;
                            //区间截取 [i,j]
                            res = s.substring(j, i + 1);
                        }
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}