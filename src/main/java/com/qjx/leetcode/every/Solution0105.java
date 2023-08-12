package com.qjx.leetcode.every;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Solution0105 {
    public static void main(String[] args) {
        Solution0105 s = new Solution0105();
        System.out.println(s.oneEditAway("pale", "ple"));

    }
    public boolean oneEditAway(String first, String second) {
        int len = first.length() - second.length();
        if (len>1 || len <-1){
            return false;
        }
        //只有一次机会
        int count = 1;
        for (int i = 0,j=0; i < first.length() && j<second.length(); i++,j++) {
            if (first.charAt(i) !=second.charAt(j)){
                if (len==1){
                    //j-- ，此时 second 不走，只让 first 走，下一次second 仍然将该值进行比较
                    j--;
                }else if (len==-1){
                    i--;
                }
                //每一次不一致 count --
                count--;
            }
            if(count<0){
                return false;
            }
        }
        return true;
    }
}
