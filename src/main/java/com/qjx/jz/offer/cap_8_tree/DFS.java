package com.qjx.jz.offer.cap_8_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {

    /**
     * 二叉树的中序遍历
     *
     * @param node
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        dfs(node, list);
        return list;
    }

    /**
     * 递归方式
     *
     * @param node
     * @param list
     */
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }

    /**
     * 迭代方式
     *
     * @param node
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    /**
     * 二叉树的 前序遍历  递归写法  根 左  右
     *
     * @param treeNode
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        preDFS(treeNode, list);
        return list;
    }

    private void preDFS(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            preDFS(treeNode.left, list);
            preDFS(treeNode.right, list);
        }
    }

    /**
     * 二叉树的 前序遍历  迭代写法  根 左  右
     *
     * @param treeNode
     * @return
     */
    public List<Integer> preOrderTraversal2(TreeNode treeNode) {
        List<Integer> list = new LinkedList<>();
        //栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = treeNode;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 转向
            cur = cur.right;
        }
        return list;
    }

    /**
     * 后续遍历 递归实现
     *
     * @param nodes
     * @return
     */
    public List<Integer> posterOrderTraversal(TreeNode nodes) {
        List<Integer> list = new LinkedList<>();
        posterDFS(nodes, list);
        return list;
    }

    private void posterDFS(TreeNode nodes, List<Integer> list) {
        if (nodes != null) {
            posterDFS(nodes.left, list);
            posterDFS(nodes.right, list);
            list.add(nodes.val);
        }
    }

    /**
     * 后续遍历 非递归实现
     *
     * @param node
     * @return
     */
    public List<Integer> postDFS(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //peek ，but not remove element
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                //遍历其 右子树
                cur = cur.right;
            } else {
                //当前节点出站
                stack.pop();
                list.add(cur.val);
                //prev 节点 代表 上一个已经遍历过的节点,代表下一次遍历的节点一定是 其父亲节点
                prev = cur;
                //将cur 设置为 null,  父亲节点 不能再次进入栈中了，下次直接将其遍历
                cur = null;
            }
        }
        return list;

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        DFS d = new DFS();
        System.out.println("中序遍历---------递归实现");
        List<Integer> list = d.inorderTraversal(node);
        System.out.println(list);

        System.out.println("中序遍历---------非递归实现");
        List<Integer> list1 = d.inorderTraversal2(node);
        System.out.println(list1);


        System.out.println("前序遍历---------递归写法");
        List<Integer> list2 = d.preOrderTraversal(node);
        System.out.println(list2);


        System.out.println("前序遍历---------非递归写法");
        List<Integer> list3 = d.preOrderTraversal2(node);
        System.out.println(list3);

        System.out.println("后序遍历---------递归写法");
        List<Integer> list4 = d.posterOrderTraversal(node);
        System.out.println(list4);

        System.out.println("后序遍历---------非递归写法");
        List<Integer> list5 = d.postDFS(node);
        System.out.println(list5);


    }


}
