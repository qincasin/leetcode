package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 */
public class Solution102 {
    public static void main(String[] args) {
        Solution102 solution101 = new Solution102();
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
        List<List<Integer>> result = new ArrayList<>();
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
            result.add(list);
        }
        return result;
    }
}
