package com.qjx.leetcode.every;

import com.qjx.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1305 {
    public static void main(String[] args) {
        TreeNode treeNode  = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        Solution1305 s = new Solution1305();
        System.out.println(s.getAllElements(treeNode, treeNode));
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 =new ArrayList<>();
        List<Integer> list2 =new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
//        return list1.stream().sorted().collect(Collectors.toList());
        return merge(list1,list2);
    }

    /**
     * 归并排序 借助 将两个排好序的list 合并到一个list当中
     * @param l1
     * @param l2
     * @return
     */
    public List<Integer> merge(List<Integer> l1,List<Integer> l2){
        List<Integer> resp = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<l1.size() || j<l2.size()){
            Integer a = i < l1.size() ? l1.get(i) : Integer.MAX_VALUE;
            Integer b = j < l2.size() ? l2.get(j) : Integer.MAX_VALUE;
            if (a<=b){
                resp.add(a);
                i++;
            }else {
                resp.add(b);
                j++;
            }
        }
        return resp;
    }

    /**
     * 中序遍历 有序
     * @param root
     * @param resp
     */
    private void dfs(TreeNode root,List<Integer> resp) {
        if (root==null){
            return;
        }
        dfs(root.left,resp);
        resp.add(root.val);
        dfs(root.right,resp);
    }
}
