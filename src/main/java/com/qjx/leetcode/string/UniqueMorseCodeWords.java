package com.qjx.leetcode.string;
import java.util.HashSet;
import java.util.Set;

/**
 * 804. Unique Morse Code Words
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 */
public class UniqueMorseCodeWords {


    /**
     * 运用Set集合去掉重复
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] Morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            for(int j =0;j<word.length();j++){
                sb.append(Morse[word.charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords solution = new UniqueMorseCodeWords();
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(solution.uniqueMorseRepresentations(words));

    }


}
