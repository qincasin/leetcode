package com.qjx.leetcode.sort;

import java.util.*;

/**
 * 通过删除给定的字符串找到字典中的单词
 * 如果有多个,则返回最小字典顺序的最长单词,如果没有返回空字符串
 * 524. Longest Word in Dictionary through Deleting
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 *
 */
public class LongestWordInDictionaryThroughDeleting {
    /**
     * 排序+判断
     * Time:O(nk) + n log(n) n代表字符串长度,k代表字典中的个数
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        /**
         * 按照长度逆序排序
         */
        Collections.sort(d,(a,b)->a.length()!=b.length()?-Integer.compare(a.length(),b.length()):a.compareTo(b));

        for (String dicWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if(i<dicWord.length()&& c == dicWord.charAt(i) ){
                    i++;
                }
            }
            if(i==dicWord.length()){
                return dicWord;
            }
        }

        return "";
    }

    /**
     * 不排序
     * Time:O(nk)   n代表字符串长度,k代表字典中的个数
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord2(String s, List<String> d) {
        /**
         * 按照长度逆序排序
         */
        String longest = "";
        for (String dicWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if(i<dicWord.length()&& c == dicWord.charAt(i) ){
                    i++;
                }
            }
            if(i==dicWord.length() && dicWord.length()>=longest.length()){
                if(dicWord.length()>longest.length()||dicWord.compareTo(longest)<0){
                    longest = dicWord;
                }

            }
        }

        return longest;
    }


    public static void main(String[] args) {
        /*"bab"
["ba","ab","a","b"]*/
        LongestWordInDictionaryThroughDeleting solution = new LongestWordInDictionaryThroughDeleting();
        String s = "bab";
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
//        d.add("monkye");
//        d.add("plea");

        String res = solution.findLongestWord2(s, d);
        System.out.println(res);



        System.out.println(d);
//        Collections.sort(d,(a,b)->
//            a.length() != b.length() ? Integer.compare(a.length(),b.length()):a.compareTo(b)
//        );
//        Collections.sort(d, (a,b) ->
//
//            a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b)
//        );

        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
//                System.out.println(a+" "+b);
                if(a.length()!=b.length()){
                    return -Integer.compare(a.length(),b.length());
                }else {
                    return a.compareTo(b);
                }
            }
        });
        System.out.println(d);
        System.out.println(s);
        for (String dicWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dicWord.length() && c == dicWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dicWord.length()) {
                System.out.println("找到了:" + dicWord);
            }

        }

        System.out.println("-------------------------");
        System.out.println(new Date());

        System.out.println("ab".compareTo("ba"));




    }



}



