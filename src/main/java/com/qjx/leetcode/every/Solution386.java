package com.qjx.leetcode.every;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= n <= 5 * 104
 */
public class Solution386 {
    public static void main(String[] args) {
        Solution386 s = new Solution386();
        System.out.println(s.lexicalOrder2(13));
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        List<Integer> resp = list.stream().sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList());
        System.out.println(resp);

//        PriorityQueue<Integer> queue = new PriorityQueue<>(16, Comparator.comparing(String::valueOf));
//        for (int i = 0; i < n; i++) {
//            queue.add(i+1);
//        }
//        System.out.println(queue);
        return null;
    }
    List<Integer> res ;

    /**
     * 字典树搜索，从左边递归
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        res = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            dfs(i,n);
        }

        return res;
    }

    /**
     * dfs
     * @param cur
     * @param n
     */
    private void dfs(int cur, int n) {
        if(cur > n){
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            int nextNumber = cur * 10 + i;
            if (nextNumber > n){
                break;
            }else {
                dfs(nextNumber,n);
            }
        }
    }


}
