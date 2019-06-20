package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 三叉树的层序遍历
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 429. N-ary Tree Level Order Traversal
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * @author: qincasin
 * @date: 2019/6/20/ 14:23
 */
public class NAryTreeLevelOrderTraversal {



  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root==null){
      return res;
    }
    levelOrder(root,0,res);
    return res;
  }

  private void levelOrder(Node root, int depth, List<List<Integer>> res) {
    if(res.size()<=depth){
      res.add(new ArrayList<>());
    }
    res.get(depth).add(root.val);
    for (Node child : root.children) {
      if (child != null) {
        levelOrder(child,depth+1,res);
      }
    }
  }
}
