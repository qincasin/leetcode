package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 */
public class Solution103 {
    public static void main(String[] args) {
        Solution103 solution101 = new Solution103();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);

        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
//        treeNode.right.left = new TreeNode(15);
        List<List<Integer>> symmetric = solution101.zigzagLevelOrder(treeNode);
        System.out.println(symmetric);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        boolean ordered = true;
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (ordered){
                    //尾插发
                    list.addLast(cur.val);
                }else {
                    //头插法
                    list.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(new LinkedList<>(list));
            //变换顺序
            ordered = !ordered;
        }
        return result;
    }
}
