package com.qjx.leetcode.tree;

import com.qjx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *二叉树的层平均值
 *Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 * @author: qincasin
 * @date: 2019/6/20/ 15:26
 */
public class AverageOfLevelsInBinaryTree {


  /**
   * bfs 广度优先搜索
   * @param root
   * @return
   */
  public List<Double> averageOfLevels(TreeNode root){
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      //每层的数据之和
      long sum = 0;
      //每层的节点个数
      int count = 0;
      //临时队列
      Queue<TreeNode> tmp =new LinkedList<>();
      while (!queue.isEmpty()){
        TreeNode n= queue.poll();
        sum+=n.val;
        count++;
        if (n.left != null) {
          tmp.add(n.left);
        }
        if (n.right != null) {
          tmp.add(n.right);
        }
      }
      queue = tmp;
      //计算结果 并将值推到list中
      res.add(sum*1.0/count);
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(3);
    node.left = new TreeNode(9);
    node.right = new TreeNode(20);
    node.right.left = new TreeNode(15);
    node.right.right = new TreeNode(7);
    AverageOfLevelsInBinaryTree solution = new AverageOfLevelsInBinaryTree();
    solution.averageOfLevels(node);
  }

}
