package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 * 897. Increasing Order Search Tree
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 *
 * @author: qincasin
 * @date: 2019/6/18/ 13:35
 */
public class IncreasingOrderSearchTree {
  public TreeNode increasingBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(root,list);
    TreeNode res = new TreeNode(list.get(0));
    TreeNode cur =res;
    for (int i = 1; i < list.size(); i++) {
      //给右子树进行赋值
      cur.right = new TreeNode(list.get(i));
      //得到的右子树再赋值给原节点
      cur = cur.right;
    }
    return res;
  }

  private void inorder(TreeNode root, List<Integer> list){

    if(root==null){
      return;
    }

    inorder(root.left,list);
    list.add(root.val);
    inorder(root.right,list);
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(5);
    node.left = new TreeNode(3);
    node.right = new TreeNode(6);
    node.left.left= new TreeNode(2);
    node.left.right = new TreeNode(4);
    node.left.left.left = new TreeNode(1);
    node.right.right = new TreeNode(8);
    node.right.right.left= new TreeNode(7);
    node.right.right.right = new TreeNode(9);
    IncreasingOrderSearchTree solution = new IncreasingOrderSearchTree();
    solution.increasingBST(node);



  }


}
