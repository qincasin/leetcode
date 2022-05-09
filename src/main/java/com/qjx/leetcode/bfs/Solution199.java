package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;
import com.qjx.leetcode.utils.CreateTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 */
public class Solution199 {
    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode tree = new CreateTree().createTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println(solution199.rightSideView(tree));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (i == size - 1) {
                    ans.add(cur.val);
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return ans;
    }
}
