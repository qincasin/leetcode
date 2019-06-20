package leetcode.tree;

/**
 * 从根到叶的二进制数之和
 * 1022. Sum of Root To Leaf Binary Numbers
 *
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 *
 * @author: qincasin
 * @date: 2019/6/20/ 19:26
 */
public class SumOfRootToLeafBinaryNumbers {

  private int sumRootToLeaf(TreeNode root) {
    return dfs(root,0);
  }

  private int dfs(TreeNode root, int sum) {
    if(root==null){
      return 0;
    }
    System.out.println(root.val);
    sum =sum*2+root.val;
    if(root.left==null&& root.right==null){
      return sum;
    }
    return dfs(root.left,sum)+dfs(root.right,sum);
  }


  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(0);
    node.right = new TreeNode(1);
    node.left.left = new TreeNode(0);
    node.left.right = new TreeNode(1);
    node.right.left = new TreeNode(0);
    node.right.right = new TreeNode(1);
    SumOfRootToLeafBinaryNumbers solution = new SumOfRootToLeafBinaryNumbers();
    solution.sumRootToLeaf(node);
  }

}
