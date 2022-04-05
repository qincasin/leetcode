package com.qjx.jz.offer.cap_8_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {

    public List<Integer> inorderTraversal(TreeNode node){
        List<Integer> list =new LinkedList<>();
        dfs(node,list);
        return list;
    }

    /**
     * 递归方式
     * @param node
     * @param list
     */
    private void dfs(TreeNode node, List<Integer> list) {
        if (node==null){
            return;
        }
        dfs(node.left,list);
        list.add(node.val);
        dfs(node.right,list);
    }

    public List<Integer> inorderTraversal2(TreeNode node){
        List<Integer> resp = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(stack);
                cur = cur.left;
            }
            System.out.println("--------------------");
            cur = stack.pop();
            resp.add(cur.val);
            cur = cur.right;
        }
        return resp;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right  = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        DFS d = new DFS();
        List<Integer> list = d.inorderTraversal2(node);
        System.out.println(list);

    }


}
