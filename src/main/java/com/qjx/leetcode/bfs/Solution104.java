package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 求二叉树的最大深度
 */
public class Solution104 {
    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
//        treeNode.left.left = new TreeNode(4);

        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(solution104.maxDepth(treeNode));


    }

    /**
     * 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，
     * 此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
     * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
     * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，
     * 最后我们用一个变量 ans 来维护拓展的次数，该二叉树的最大深度即为 ans。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //双向队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        if (root == null) {
            return 0;
        }
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur == null) {
                    continue;
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
