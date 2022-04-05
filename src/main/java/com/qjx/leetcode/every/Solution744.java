package com.qjx.leetcode.every;

public class Solution744 {
    public static void main(String[] args) {
        Solution744 solution744 = new Solution744();
        char[] chars = new char[]{'c', 'f', 'j'};
        char target = 'g';
        char resp = solution744.nextGreatestLetter2(chars, target);
        System.out.println(resp);


    }

    /**
     * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        char lasterLetter = letters[0];
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
            lasterLetter = letter;
        }
        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int l = 0;
        int res = 0;
        int r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m = letters[mid];
            if (m > target) {
                res = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return letters[res];
    }


}
