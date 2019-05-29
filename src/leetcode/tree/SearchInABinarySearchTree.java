package leetcode.tree;

import java.util.Date;

/**
 * Title:
 * Description: bst中查找
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/29 15:22
 * Version:1.1.0
 */
public class SearchInABinarySearchTree {

    /**
     * 700. Search in a Binary Search Tree
     * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
     * <p>
     * For example,
     * <p>
     * Given the tree:
     * 4
     * / \
     * 2   7
     * / \
     * 1   3
     * <p>
     * And the value to search: 2
     * You should return this subtree:
     * <p>
     * 2
     * / \
     * 1   3
     * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
     * <p>
     * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
     *
     * @param root
     * @param val
     * @return
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}
