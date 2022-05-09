package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.*;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class Solution111 {
    public static void main(String[] args) {
        Solution111 solution101 = new Solution111();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
//        treeNode.left.right = new TreeNode(20);

        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);
        int resp =  solution101.minDepth(treeNode);
        System.out.println(resp);
    }

    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur.left==null && cur.right==null){
                    return ++depth;
                }
                if (cur.left!=null){
                    deque.add(cur.left);
                }
                if (cur.right!=null){
                    deque.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
