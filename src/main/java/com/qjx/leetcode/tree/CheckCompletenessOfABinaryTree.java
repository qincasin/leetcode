package com.qjx.leetcode.tree;

import com.qjx.leetcode.common.TreeNode;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 * 校验二叉树是否是完全二叉树
 * 958. Check Completeness of a Binary Tree
 *
 * Given a binary tree, determine if it is a complete binary tree.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 *
 *
 *
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 */
public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if(null == root) {
            return false;
        }
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        boolean left = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode head = queue.poll();
            leftChild = head.left;
            rightChild = head.right;
            //右孩子不等于空，左孩子等于空  -> false
            boolean flag1 = (null != rightChild && null == leftChild);
            //开启叶节点判断标志位时，如果层次遍历中的后继结点不是叶节点 -> false
            boolean flag2 = (left && (null != rightChild || null != leftChild));
            if(flag1 || flag2) {
                return false;
            }
            if(null != leftChild) {
                queue.offer(leftChild);
            }
            if(null != rightChild) {
                queue.offer(rightChild);
            }else {
                left = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree solution = new CheckCompletenessOfABinaryTree();
        System.out.println(new Date());


    }

}
