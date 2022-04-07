package com.qjx.leetcode.every;

import java.util.*;

/**
 * 最小高度树  ---- 本题目可以 转换为 求 树的 中心节点
 * 1.当组成的树是最小高度树时，其根必然是树的中心节点              ----- 结论
 * 2.每一棵树的中心节点至多2个，也就是说 可能是一个可能是两个       ---- 结论
 * 而且 中心节点 是任意两个node(节点)之间 路径是最长的           ----- 结论
 */
public class Solution310 {
    public static void main(String[] args) {
        Solution310 solution_310 = new Solution310();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        //初始化一个图
        int[] degree = new int[n];// 每个节点的邻居数量
        Map<Integer, List<Integer>> map = new HashMap<>();  //每个节点的邻居们
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            degree[a]++;
            degree[b]++;

            map.computeIfAbsent(a, k -> new ArrayList<>());  //key 节点，value 邻居们

            if (map.get(b) == null) {
                map.put(b, new ArrayList<>());  //key 节点，value 邻居们
            }

            map.get(a).add(b);
            map.get(b).add(a);
        }

        //其实就是一个q
        LinkedList<Integer> leafNodes = new LinkedList<>(); //此时此刻叶子结点们

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                leafNodes.add(i);
            }
        }

        while (leafNodes.size() > 0) {
            res.clear();

            int size = leafNodes.size();
            for (int i = 0; i < size; i++) {
                int leaf = leafNodes.poll();
                res.add(leaf);

                List<Integer> neighbors = map.get(leaf); //某个叶子结点的邻居们

                for (Integer neighbor : neighbors) {
                    degree[neighbor]--; // 邻居的邻居数量-1
                    if (degree[neighbor] == 1) { // 这个时候基本上就已经结束了，下一轮就会将1 和 3 加入到最终的结果中
                        leafNodes.add(neighbor);
                    }
                }
            }
        }


        return res;
    }
}
