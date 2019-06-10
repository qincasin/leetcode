package leetcode.utils;

/**
 * Title:
 * Description: 二叉树工具类
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/27 11:23
 * Version:1.1.0
 */

public interface Tree<T extends Comparable> {
    /**
     * 空判断
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 二叉树节点个数
     *
     * @return
     */
    int size();

    /**
     * 二叉树的高度或者深度，即节点的最大层数
     *
     * @return
     */
    int height();

    /**
     * 先序遍历
     *
     * @return
     */
    String preOrder();

    /**
     * 非递归实现先序遍历
     *
     * @return
     */
    String preOrderTraverse();

    /**
     * 非递归实现中序遍历
     *
     * @return
     */
    String postOrderTraverse();

    /**
     * 非递归实现后序遍历
     *
     * @return
     */
    String inOrderTraverse();


    /**
     * 中序遍历
     *
     * @return
     */
    String inOrder();

    /**
     * 后序遍历
     *
     * @return
     */
    String postOrder();

    /**
     * 层序遍历
     *
     * @return
     */
    String levelOrder();

    /**
     * 插入数据
     *
     * @param data
     */
    void insert(T data);

    /**
     * 删除
     *
     * @param data
     */
    void remove(T data);

    /**
     * 查找最大值
     *
     * @return
     */
    T findMax();

    /**
     * 查找最小值
     *
     * @return
     */
    T findMin();

    /**
     * 根据值找到节点
     *
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * 是否包含某个值
     *
     * @param data
     * @return
     * @throws Exception
     */
    boolean contains(T data) throws Exception;

    /**
     * 清空
     */
    void clear();

}
