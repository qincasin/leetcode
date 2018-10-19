package leetcode.string;

/**
 * 709. To Lower Case
 * 实现一个转换小写字符串的函数
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = Character.toLowerCase(str.charAt(i));
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "LOVELY";
        System.out.println(new ToLowerCase().toLowerCase(str));
    }

}
