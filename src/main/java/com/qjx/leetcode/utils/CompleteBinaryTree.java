package com.qjx.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: Description: 完全二叉树构造代码 利用程序遍历构造原理构造完全二叉树 Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/6/10 16:10 Version:1.1.0
 */
public class CompleteBinaryTree<T extends Comparable> extends BinarySearchTree<T> {

  public CompleteBinaryTree() {
    super();
  }

  public CompleteBinaryTree(T[] levelOrderArray) {
    this.root = create(levelOrderArray, 0);
  }

  /**
   * 层序遍历构造完全二叉树
   */
  public BinaryNode<T> create(T[] levelOrderArray, int i) {
    if (levelOrderArray == null) {
      throw new RuntimeException("the param 'array' of create method cannot be bull!");
    }
    BinaryNode<T> p = null;
    if (i < levelOrderArray.length) {
      //递归结束条件
      p = new BinaryNode<>(levelOrderArray[i], null, null);
      //根据完全二叉树的性质 2 *i +1 为左孩子节点
      p.left = create(levelOrderArray, 2 * i + 1);
      //2*i+2为右孩子节点
      p.right = create(levelOrderArray, 2 * i + 2);
    }

    return p;
  }

  @Override
  public boolean contains(T data) {
    Queue<BinaryNode<T>> queue = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
    BinaryNode<T> p = this.root;
    while (p != null) {
      //判断p是否存在data
      if (data.compareTo(p.data) == 0) {
        return true;
      }
      //先按照层序遍历节点，左节点一定在右节点之前访问
      if (p.left != null) {
        //孩子节点入队
        queue.add(p.left);
      }
      if (p.right != null) {
        queue.add(p.right);

      }
      //访问下一个节点
      p = queue.poll();
    }
    return false;
  }

  public static void main(String[] args) {
    String[] levelOrderArray = {"A", "B", "C", "D", "E", "F"};
    CompleteBinaryTree<String> cbtree = new CompleteBinaryTree<>(levelOrderArray);
    System.out.println("先序遍历:" + cbtree.preOrder());
    System.out.println("中序遍历:" + cbtree.inOrder());
    System.out.println("后序遍历:" + cbtree.postOrder());
    System.out.println("层序遍历:" + cbtree.levelOrder());
    System.out.println("查找最大节点:" + cbtree.findMax());
    System.out.println("查找最小节点:" + cbtree.findMin());
  }


}
