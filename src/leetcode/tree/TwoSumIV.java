package leetcode.tree;

/**
 * Title: 653. Two Sum IV - Input is a BST
 * Description: 653. Two Sum IV - Input is a BST
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/27 11:08
 * Version:1.1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TwoSumIV {
    /**
     * 转换为Two Sum II - Input array is sorted 来计算
     * time o(N)
     * space o(N)
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int l = 0 ,r = list.size()-1;
        while (l<r){
            int sum = list.get(l)+list.get(r);
            if(sum==k) {
                return true;
            }
            if(sum<k){
                l++;
            }else {
                r--;
            }
        }

        return false;
    }

    /**
     * 中序遍历，升序列
     * 左节点、当前节点、右节点
     * @param root
     * @param list
     */
    private void inorder(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }


//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(10);
//    }


}
