package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.Node;

import java.util.Queue;
import java.util.Set;

/**
 * Created by qincasin on 2021/3/1.
 */
public class Template {
    /**
     * 队列 q 就不说了，BFS 的核心数据结构；
     * cur.adj() 泛指 cur 相邻的节点，比如说二维数组中，cur 上下左右四面的位置就是相邻节点；
     * visited 的主要作用是防止走回头路，大部分时候都是必须的，但是像一般的二叉树结构，没有子节点到父节点的指针，不会走回头路就不需要 visited。
     */

    // 计算从起点 start 到终点 target 的最近距离
//    int BFS(Node start, Node target) {
//        Queue<Node> q; // 核心数据结构
//        Set<Node> visited; // 避免走回头路

//        q.offer(start); // 将起点加入队列
//        visited.add(start);
//        int step = 0; // 记录扩散的步数

//        while (!q.isEmpty()) {
//            int sz = q.size();
//            /* 将当前队列中的所有节点向四周扩散 */
//            for (int i = 0; i < sz; i++) {
//                Node cur = q.poll();
//                /* 划重点：这里判断是否到达终点 */
//                if (cur is target)
//                return step;
//                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj())
//                    if (x not in visited) {
//                    q.offer(x);
//                    visited.add(x);
//                }
//            }
            /* 划重点：更新步数在这里 */
//            step++;
//        }
//    }
}
