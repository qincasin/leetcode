package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;
import com.qjx.leetcode.utils.CreateTree;
import org.apache.commons.math3.stat.descriptive.summary.Sum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 *
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution112 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode tree = new CreateTree().createTree(arr);
        Solution112 s = new Solution112();
        boolean b = s.hasPathSum(tree, 22);
        System.out.println(b);
    }

    /**
     * 首先我们可以想到使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
     *
     * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> queVal = new LinkedList<>();
        deque.offer(root);
        queVal.offer(root.val);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                Integer temp = queVal.poll();
                if (cur.left==null && cur.right==null){
                    if (temp==targetSum){
                        return true;
                    }
                    continue;
                }
                if (cur.left!=null){
                    deque.offer(cur.left);
                    queVal.offer(cur.left.val+temp);
                }
                if (cur.right!=null){
                    deque.offer(cur.right);
                    queVal.offer(cur.right.val+temp);
                }
            }
        }
        return false;
    }
}
