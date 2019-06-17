package leetcode.tree;

import java.util.ArrayList;
import java.util.List;



class Node {

  public int val;
  public List<Node> children;

  public Node() {
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", children=" + children +
        '}';
  }
};

/**
 * 树的先序遍历
 *
 * 589. N-ary Tree Preorder Traversal
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
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
 *
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 * @author: qincasin
 * @date: 2019/6/12/ 18:33
 */
public class NAryTreePreorderTraversal {


  public List<Integer> preorder(Node root) {
    List<Integer> ans = new ArrayList<>();
    return preorderUtil(root, ans);
  }

  private List<Integer> preorderUtil(Node root, List<Integer> ans) {
    if (root == null) {
      List<Integer> arr = new ArrayList<>();
      return arr;
    }
    ans.add(root.val);
    for (Node child : root.children) {
      preorderUtil(child, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Node> arr = new ArrayList<>();
    Node n1 = new Node(5, null);
    Node n2 = new Node(6, null);

    Node n4 = new Node(2, null);
    Node n5 = new Node(4, null);
    arr.add(n1);
    arr.add(n2);
    Node n3 = new Node(3, arr);
    System.out.println(n3.toString());
    List<Node> arr2 = new ArrayList<>();
    arr2.add(n3);
    arr2.add(n4);
    arr2.add(n5);

    System.out.println(arr);
    Node n = new Node(1,arr2);

    System.out.println(n);

    NAryTreePreorderTraversal solution = new NAryTreePreorderTraversal();
    List<Integer> result = solution.preorder(n);
    System.out.println(result);

  }

}
