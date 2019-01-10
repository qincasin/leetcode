package leetcode.hash;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 *
 *
 * 884. Uncommon Words from Two Sentences
 *
 * @ClassName UncommonWordsfromTwoSentences
 * @Description 两句话中不常见的词汇
 * @Author qincasin
 * @Date 2019/1/9 15:23
 * @Version 1.0
 **/
public class UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] str = A.split(" ");

        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String[] str2 = B.split(" ");
        for (String s : str2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Integer count = map.values().stream().mapToInt(v -> v.intValue()).filter(v -> v == 1).sum();

        String[] res = new String[count];
        int index = 0;

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                res[index++] = key;
            }
        }


        return res;
    }

    public static void main(String[] args) {

        //A this apple is sweet
        //B this apple is sour

        String A = "apple apple";
        String B = "banana";

        UncommonWordsfromTwoSentences solution = new UncommonWordsfromTwoSentences();
        String[] result = solution.uncommonFromSentences(A, B);
        System.out.println(Arrays.toString(result));

        System.out.println(new Date());

    }

}
