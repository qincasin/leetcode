package leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 500. Keyboard Row
 * <p>
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * <p>
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * @ClassName KeyboardRow
 * @Description 键盘行数
 * @Author qincasin
 * @Date 2019/1/9 14:21
 * @Version 1.0
 **/
public class KeyboardRow {
    //lowercase letters on the first line of the keyboard.
    String firstRow = "qwertyuiop";

    //lowercase letters on the second line of the keboard.
    String secondRow = "asdfghjkl";

    //lowercase letters on the third line of the keyboard
    String thirdRow = "zxcvbnm";


    boolean[] first = new boolean[26], second = new boolean[26], third = new boolean[26];

    public String[] findWords(String[] words) {

        if (words == null || words.length == 0) {
            return new String[0];
        }

        List<String> validWords = new ArrayList<>();

        for (int i = 0; i < firstRow.length(); i++) {
            first[firstRow.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < secondRow.length(); i++) {
            second[secondRow.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < thirdRow.length(); i++) {
            third[thirdRow.charAt(i) - 'a'] = true;
        }

        for (String word : words) {
            if (isValid(word)) {
                validWords.add(word);
            }
        }

        String[] res = new String[validWords.size()];

        int index = 0;

        for (String word : validWords) {
            res[index++] = word;
        }

        return res;
    }

    private boolean isValid(String word) {
        return contains(first, word) || contains(second, word) || contains(third, word);
    }


    private boolean contains(boolean[] row, String word) {
        for (char c : word.toLowerCase().toCharArray()) {
            // is the letter in this line ?
            if (!row[c - 'a']) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        KeyboardRow solution = new KeyboardRow();

        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};

        String[] result = solution.findWords(words);

        System.out.println(Arrays.toString(result));
        System.out.println(new Date());

    }

}
