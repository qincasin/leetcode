package com.qjx.leetcode.every;

import java.util.*;

public class Solution433 {
    /**
     * "AACCTTGG"
     * "AATTCCGG"
     * ["AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"]
     * @param args
     */

    public static void main(String[] args) {
        Solution433 s = new Solution433();
        int resp = s.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"});
        System.out.println(resp);
    }

    public int minMutation(String start, String end, String[] bank) {
        //定义一个双向队列
        Deque<String> queue = new LinkedList<>();
        //是否访问过
        Set<String> visited = new HashSet<>();
        if (!contains(bank, end) && !start.equals(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        queue.addLast(start);
        visited.add(start);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.removeFirst();
                if (cur.equals(end)) {
                    return res;
                }
                for (String str : bank) {
                    if (canMutate(str, cur) && !visited.contains(str)) {
                        queue.addLast(str);
                        visited.add(str);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    /**
     * 判断是否变异的条件  当且仅当str1 和 str2 的字符相差1 的时候才可以进行变异
     *
     * @param str1
     * @param str2
     * @return
     */
    private boolean canMutate(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    /**
     * 返回这个str 是否包含在给定的bank中
     *
     * @param bank
     * @param toFind
     * @return
     */
    private boolean contains(String[] bank, String toFind) {
        for (String b : bank) {
            if (b.equals(toFind)) {
                return true;
            }
        }
        return false;
    }


}
