package com.qjx.leetcode.string;

/**
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {

    /**
     *  对撞指针方式
     *  time:O(n)
     *  space:O(n)
     * @param s
     * @return
     */
    public  String reverseVowels(String s) {
        char[] strs =s.toCharArray();
        int i=0,j=strs.length-1;
        while (i<j){
            if(isVowels(strs[i])&&isVowels(strs[j])){
                swap(strs,i++,j--);
            }else if(!isVowels(strs[i])){
                i++;
            }else if(!isVowels(strs[j])){
                j--;
            }
        }
        return new String(strs);
    }
    boolean isVowels(char s){
        if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u'||s=='A'||s=='E'||s=='I'||s=='O'||s=='U'){
            return true;
        }else {
            return false;
        }
    }
    void swap(char[] chars,int i,int j){
        char temp =chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public static void main(String[] args) {

        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        String s = "hello";
        String result = solution.reverseVowels(s);

        System.out.println(result);
    }

}
