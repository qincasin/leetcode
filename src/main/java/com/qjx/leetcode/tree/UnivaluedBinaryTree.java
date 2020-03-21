package com.qjx.leetcode.tree;

import com.qjx.leetcode.common.TreeNode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 965. Univalued Binary Tree
 * Title:
 * Description: 唯一二叉树
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/29 10:47
 * Version:1.1.0
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *
 */


public class UnivaluedBinaryTree<puv> {
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer>  set = new HashSet<>();
        inOrder(root,set);

        return set.size()==1;
    }

    private void inOrder(TreeNode root,Set<Integer> set){
        if(root==null){
            return;
        }
        inOrder(root.getLeft(),set);
        set.add(root.getVal());
        inOrder(root.getRight(),set);
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
