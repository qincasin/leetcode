package com.qjx.leetcode.string;


/**
 *
 * 344. Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {


    /**
     * 对撞指针方式
     *  time:O(n)
     *  space:O(n)
     * @param s
     * @return
     */
    public  String reverseString(String s) {
        char[] strs=s.toCharArray();
        int i=0,j=strs.length-1;
        while (i<j){
            swap(strs,i++,j--);
        }
        return new String(strs);
    }
    public  void swap(char[] chars,int i,int j){
        char temp =chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        String s = "A man, a plan, a canal: Panama";
        String result  = solution.reverseString(s);
        System.out.println(result);
    }

}
