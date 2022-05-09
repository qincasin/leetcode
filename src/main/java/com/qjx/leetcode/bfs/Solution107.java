package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 */
public class Solution107 {
    public static void main(String[] args) {
        Solution107 solution101 = new Solution107();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
//        treeNode.left.right = new TreeNode(20);

        treeNode.right = new TreeNode(20);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);
        List<List<Integer>> symmetric = solution101.levelOrder(treeNode);
        System.out.println(symmetric);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    continue;
                }
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.addFirst(list);
        }
        return result;
    }
}
