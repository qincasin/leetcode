package com.qjx.leetcode.bfs;

import com.qjx.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by qincasin on 2021/5/18.
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur==null?null:cur.val);
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null){
                    q.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        n1.left = new TreeNode(9);
        n1.right = new TreeNode(20);
        n1.right.left = new TreeNode(15);
        n1.right.left.right =  new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> resp = levelOrder.levelOrder(n1);
        System.out.println(Arrays.toString(new List[]{resp}));
    }
}
