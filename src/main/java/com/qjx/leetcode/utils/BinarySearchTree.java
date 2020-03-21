package com.qjx.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import com.qjx.leetcode.ex.EmptyTreeException;

/**
 * Title: Description: 二叉查找树BinarySearchTree Author:qincasin <qinjiaxing@shein.com> Since:2019/5/28
 * 17:09 Version:1.1.0
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {

  protected BinaryNode<T> root;

  public BinarySearchTree() {
    root = null;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  /**
   * 计算节点大小
   */
  @Override
  public int size() {
    return size(root);
  }

  /**
   * 递归实现：定义根节点root后，再用subtree实现递归
   */
  private int size(BinaryNode<T> subtree) {
    if (subtree == null) {
      return 0;
    } else {
      //对比汉诺塔:H(n)=H(n-1) + 1 + H(n-1)
      return size(subtree.left) + 1 + size(subtree.right);
    }
  }


  /**
   * 深度即为最大层的结点所在层次
   */
  @Override
  public int height() {
    return height(root);
  }

  /**
   * 深度即为最大层的结点所在层次 1.从根节点开始寻找 2.分别递归计算左子树、右子树的深度 3.比较左子树和右子树的深度 4.返回深度最大的即可(求出的最大值 + 1     ->
   * 加上当前层数)
   */
  private int height(BinaryNode<T> subtree) {
    if (subtree == null) {
      return 0;
    } else {
      int l = height(subtree.left);
      int r = height(subtree.right);
      //返回并加上当前层
      return (l > r) ? (l + 1) : (r + 1);
    }
  }

  @Override
  public String preOrder() {

    String sb = preOrder(root);
    if (sb.length() > 0) {
      //去掉尾部","号
      sb = sb.substring(0, sb.length() - 1);
    }
    return sb;
  }

  /**
   * 先序遍历  递归实现 根  左  右
   */
  private String preOrder(BinaryNode<T> subtree) {
    StringBuffer sb = new StringBuffer();
    if (subtree != null) {
      sb.append(subtree.data + ",");
      sb.append(preOrder(subtree.left));
      sb.append(preOrder(subtree.right));
    }
    return sb.toString();

  }

  @Override
  public String preOrderTraverse() {
    //构建栈
    //todo 构造linkedStack栈实现先序遍历(非递归实现)
    String sb = preOrderTraverse(root);
    return sb;
  }


  private String preOrderTraverse(BinaryNode<T> subtree) {
    StringBuffer sb = new StringBuffer();
    Stack<BinaryNode> stack = new Stack<>();
    while (subtree != null || !stack.isEmpty()) {
      while (subtree != null) {
        sb.append(subtree.data);
        stack.push(subtree);
        subtree = subtree.left;
      }
      if (!stack.isEmpty()) {
        subtree = stack.pop();
        subtree = subtree.right;
      }
    }

    return sb.toString();

  }





  @Override
  public String inOrder() {
    String sb = inOrder(root);
    if (sb.length() > 0) {
      sb = sb.substring(0, sb.length() - 1);
    }
    return sb;
  }

  private String inOrder(BinaryNode<T> subtree) {
    StringBuffer sb = new StringBuffer();
    if (subtree != null) {
      sb.append(inOrder(subtree.left));
      sb.append(subtree.data + ",");
      sb.append(inOrder(subtree.right));
    }
    return sb.toString();
  }


  @Override
  public String postOrder() {
    String sb = postOrder(root);
    if (sb.length() > 0) {
      sb = sb.substring(0, sb.length() - 1);
    }
    return sb;
  }

  /**
   * 左  右 根
   */
  private String postOrder(BinaryNode<T> subtree) {
    StringBuffer sb = new StringBuffer();
    if (subtree != null) {
      sb.append(postOrder(subtree.left));
      sb.append(postOrder(subtree.right));
      sb.append(subtree.data + ",");
    }
    return sb.toString();
  }

  @Override
  public String postOrderTraverse() {
    //todo 借助栈非递归实现
    return null;

  }

  @Override
  public String inOrderTraverse() {
    //todo 借助栈非递归实现
    return null;
  }

  /**
   * 层序遍历
   */
  @Override
  public String levelOrder() {
    BinaryNode<T> p = this.root;
    Queue<BinaryNode<T>> queue = new LinkedList<>();
    StringBuffer sb = new StringBuffer();
    while (p != null) {
      //记录经过的节点
      sb.append(p.data);

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
    return sb.toString();
  }

  @Override
  public void insert(T data) {
    if (data == null) {
      throw new RuntimeException("data cannot Comparable be null!");
    }
    root = insert(data, root);


  }

  /**
   * 插入操作 递归实现
   */
  private BinaryNode<T> insert(T data, BinaryNode<T> p) {
    if (p == null) {
      p = new BinaryNode<>(data, null, null);
    }
    // 比较插入节点的值，决定向左子树还是右子树搜索
    int compareResult = data.compareTo(p.data);
    if (compareResult < 0) {
      //左
      p.left = insert(data, p.left);
    } else if (compareResult > 0) {
      //右
      p.right = insert(data, p.right);
    } else {
      //已有元素就没必要重复插入了
      ;
    }
    return p;
  }

  private BinaryNode<T> insert2(T data, BinaryNode<T> p) {
    if (p == null) {
      p = new BinaryNode<>(data, null, null);
    }
    int compareResult = data.compareTo(p.data);
    if (compareResult > 0) {
      p.right = insert2(data, p.right);
    } else if (compareResult < 0) {
      p.left = insert2(data, p.left);
    } else {
      ;
    }
    return p;
  }

  @Override
  public void remove(T data) {

    if (data == null) {
      throw new RuntimeException("data cannot Comparable be null!");
    }
    root = remove(data, root);
  }

  /**
   * 对于二叉树来说，删除是一种比较麻烦的操作，因为涉及到了多种情况（设要删除的结点为q，其父母结点为p）：
   *
   * ① 如果要删除的结点q恰好是叶子结点，那么它可以立即被删除
   *
   * ② 如果要删除的结点q拥有一个孩子结点，则应该调整要被删除的父结点(p.left 或 p.right)指向被删除结点的孩子结点（q.left 或 q.right）
   *
   * ③如果要删除的结点q拥有两个孩子结点，则删除策略是用q 的右子树的最小的数据替代要被删除结点的数据，
   * 并递归删除用于替换的结点(此时该结点已为空)，此时二叉查找树的结构并不会被打乱，其特性仍旧生效。
   * 采用这样策略的主要原因是右子树的最小结点的数据替换要被删除的结点后可以满足维持二叉查找树的结构和特性，又因为右子树最小结点不可能有左孩子，删除起来也相对简单些。
   */
  /**
   * 分三种情况 1.删除叶子节点(也就是没有孩子节点) 2.删除拥有一个孩子节点的节点(可能是左孩子也可能是有孩子) 3.删除有用两个孩子节点的节点
   */
  private BinaryNode<T> remove(T data, BinaryNode<T> p) {
    //没有找到删除的元素，递归结束
    if (p == null) {
      return p;
    }
    int compareResult = data.compareTo(p.data);
    if (compareResult < 0) {
      //左边查找删除节点
      p.left = remove(data, p.left);
    } else if (compareResult > 0) {
      //右边查找删除节点
      p.right = remove(data, p.right);
    } else if (p.left != null && p.right != null) {
      //已找到节点并判断是否有两个子节点(情况3)
      //中序替换，找到右子树中最小的元素并替换需要删除的元素值
      p.data = findMin(p.right).data;
      //移除用于替换的节点
      p.right = remove(p.data, p.right);
    } else {
      //拥有一个孩子节点的节点和叶子节点的情况
      p = (p.left != null) ? p.left : p.right;
    }
    return p;

  }

  @Override
  public T findMin() {
    if (isEmpty()) {
      throw new EmptyTreeException("BinarySearchTree is empty! ");
    }
    return findMin(root).data;
  }

  /**
   * 查找最小值节点 从跟节点开始并且只要有左孩子就向左进行即可，其终止点即为最小值的元素
   */
  private BinaryNode<T> findMin(BinaryNode<T> p) {
    if (p == null) {
      return null;
    } else if (p.left == null) {
      //如果没有左节点，那么p就是最小的
      return p;
    }
    return findMin(p.left);
  }

  @Override
  public T findMax() {
    if (isEmpty()) {
      throw new EmptyTreeException("BinarySearchTree is empty!");
    }
    return findMax(root).data;
  }

  /**
   * 查找最大值结点 从跟节点开始并且只要有友孩子，就向右进行搜索即可，终止点即为值最大的元素
   */
  private BinaryNode<T> findMax(BinaryNode<T> p) {
    if (p == null) {
      //结束条件
      return null;
    } else if (p.right == null) {
      return p;
    }
    return findMax(p.right);

  }

  @Override
  public BinaryNode findNode(T data) {
    return null;
  }

  @Override
  public boolean contains(T data) throws Exception {
    return false;
  }

  @Override
  public void clear() {

  }


  public static void main(String[] args) {
    BinaryNode node = new BinaryNode(1);
    node.left = new BinaryNode(2);
    node.right = new BinaryNode(3);
    node.left.left = new BinaryNode(4);
    node.left.right = new BinaryNode(5);
    node.right.left = new BinaryNode(6);
    node.right.right = new BinaryNode(7);
    BinarySearchTree test = new BinarySearchTree();
    test.root = node;
    System.out.println(test.preOrderTraverse());
    System.out.println(test.preOrder());
    System.out.println("查找最大节点" + test.findMax());
    System.out.println("查找最小节点" + test.findMin());
  }
}
