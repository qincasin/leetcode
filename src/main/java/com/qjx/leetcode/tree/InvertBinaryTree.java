package com.qjx.leetcode.tree;

import com.qjx.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 * 226. Invert Binary Tree
 *Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 * @author: qincasin
 * @date: 2019/6/20/ 17:26
 */
public class InvertBinaryTree {

  /**
   * 递归实现
   * time:o(n)
   * space:o(h)
   * @param root
   * @return
   */
  public TreeNode invertTree(TreeNode root) {
    if(root==null){
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left =right;
    root.right = left;

    return root;
  }

  /**
   * 迭代实现 bfs
   * time:o(n)
   * space:o(h)
   * @param root
   * @return
   */
  public TreeNode invertTreeIterative(TreeNode root) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
      TreeNode current = queue.poll();
      TreeNode tmp = current.left;
      current.left = current.right;
      current.right = tmp;
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(7);
    node.left.left = new TreeNode(1);
    node.left.right =new TreeNode(3);
    node.right.left = new TreeNode(6);
    node.right.right= new TreeNode(9);
    InvertBinaryTree solution = new InvertBinaryTree();
    solution.invertTreeIterative(node);

  }



}
