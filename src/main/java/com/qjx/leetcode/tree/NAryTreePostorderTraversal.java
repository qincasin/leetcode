package com.qjx.leetcode.tree;

import com.qjx.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 三叉树后续遍历
 *
 *Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * @author: qincasin
 * @date: 2019/6/17/ 16:46
 */
public class NAryTreePostorderTraversal {
  public List<Integer> postorder(Node root) {

    List<Integer> ans = new ArrayList<>();
    return postorderUtils(root,ans);
  }

  private List<Integer> postorderUtils(Node root, List<Integer> ans) {
    if (root == null) {
      List<Integer> arr= new ArrayList<>();
      return arr;
    }
    for (Node child : root.children) {
      postorderUtils(child,ans);
    }
    ans.add(root.val);
    return ans;

  }


}
