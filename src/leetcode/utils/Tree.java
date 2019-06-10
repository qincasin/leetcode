package leetcode.utils;

/**
 * Title: Description: 二叉树工具类 Author:qincasin <qinjiaxing@shein.com> Since:2019/5/27 11:23
 * Version:1.1.0
 */

public interface Tree<T extends Comparable> {

  /**
   * 空判断
   */
  boolean isEmpty();

  /**
   * 二叉树节点个数
   */
  int size();

  /**
   * 二叉树的高度或者深度，即节点的最大层数
   */
  int height();

  /**
   * 先序遍历
   */
  String preOrder();

  /**
   * 非递归实现先序遍历
   */
  String preOrderTraverse();

  /**
   * 非递归实现中序遍历
   */
  String postOrderTraverse();

  /**
   * 非递归实现后序遍历
   */
  String inOrderTraverse();


  /**
   * 中序遍历
   */
  String inOrder();

  /**
   * 后序遍历
   */
  String postOrder();

  /**
   * 层序遍历
   */
  String levelOrder();

  /**
   * 插入数据
   */
  void insert(T data);

  /**
   * 删除
   */
  void remove(T data);

  /**
   * 查找最大值
   */
  T findMax();

  /**
   * 查找最小值
   */
  T findMin();

  /**
   * 根据值找到节点
   */
  BinaryNode findNode(T data);

  /**
   * 是否包含某个值
   */
  boolean contains(T data) throws Exception;

  /**
   * 清空
   */
  void clear();

}
