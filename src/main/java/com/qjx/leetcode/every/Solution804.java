package com.qjx.leetcode.every;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    public static void main(String[] args) {
        Solution804 s =new Solution804();
        String[] words =  new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(s.uniqueMorseRepresentations(words));

    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        if (words.length == 0) {
            return 0;
        }
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String res = arr[word.charAt(i) - 97];
                sb.append(res);
            }
            set.add(sb.toString());
        }
        return set.size();

    }
}
