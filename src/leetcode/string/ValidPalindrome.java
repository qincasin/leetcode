package leetcode.string;

/**
 * 125. Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 *
 * @ClassName ValidPalindrome
 * @Description 回文串
 * @Author qincasin
 * @Date 2018/12/11 12:44
 * @Version 1.0
 **/
public class ValidPalindrome {
    /**
     * 双指针判断
     * Time:O(n)
     * Space:O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println(result);
    }
}
