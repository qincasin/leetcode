package com.qjx.jz.offer.cap_8_tree;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root==null){
            return root;
        }
         root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left==null && root.right==null && root.val==0){
            return null;
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
