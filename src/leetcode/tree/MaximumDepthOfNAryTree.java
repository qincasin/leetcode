package leetcode.tree;

/**
 * 三叉树中树的深度
 * 559. Maximum Depth of N-ary Tree
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 *
 * We should return its max depth, which is 3.
 *
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * @author: qincasin
 * @date: 2019/6/17/ 17:19
 */
public class MaximumDepthOfNAryTree {
  public int maxDepth(Node root) {
    if(root==null){
      return 0;
    }
    int res= 0;
    for (Node child : root.children) {
      res = Math.max(res,maxDepth(child));
    }
    return res+1;
  }

}
