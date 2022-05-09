package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 */
public class Solution101 {
    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);

        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        boolean symmetric = solution101.isSymmetric(treeNode);
        System.out.println(symmetric);

    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.getLeft());
        queue.offer(root.getRight());
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left==null && right==null){
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val !=right.val){
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
