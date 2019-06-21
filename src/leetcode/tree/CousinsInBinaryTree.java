package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 堂兄弟节点判断
 *In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 * @author: qincasin
 * @date: 2019/6/21/ 14:34
 */
public class CousinsInBinaryTree {

  /**
   * 定义深度和父节点
   */
  Map<Integer,Integer> depth;
  Map<Integer,TreeNode> parent;

  /**
   * 当且仅当一对节点深度相同而父节点不相同时，它们是堂兄弟节点。一种非常直接的方法就是通过某种方法求出每一个节点的深度与父节点。
   * 我们用深度优先搜索标记每一个节点，对于每一个节点 node，它的父亲为 par，深度为 d，我们将其记录到 Hashmap 中：parent[node.val] = par 且 depth[node.val] = d
   * 时间复杂度：O(N)，其中 N 是给定树中节点的数量
   * 空间复杂度：O(N)
   * @param root
   * @param x
   * @param y
   * @return
   */
  public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap<>();
    parent = new HashMap<>();
    dfs(root,null);
    return (depth.get(x).equals(depth.get(y))&&(parent.get(x)!=parent.get(y)));
  }

  private void dfs(TreeNode root, TreeNode par) {

    if (root != null) {
      //深度  直接说去子节点的父节点的深度，然后在+1
      depth.put(root.val,par!=null?1+depth.get(par.val):0);
      //父节点
      parent.put(root.val,par);
      dfs(root.left,root);
      dfs(root.right,root);

    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
//    node.left.left = new TreeNode(1);
    node.left.right =new TreeNode(4);
//    node.right.left = new TreeNode(6);
    node.right.right= new TreeNode(5);
    CousinsInBinaryTree solution = new CousinsInBinaryTree();
    boolean result = solution.isCousins(node, 5, 4);
    System.out.println(result);
  }
}
