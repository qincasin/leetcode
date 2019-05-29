package leetcode.utils;

import leetcode.ex.EmptyTreeException;

/**
 * Title:
 * Description: 二叉查找树BinarySearchTree
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/28 17:09
 * Version:1.1.0
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
     *  计算节点大小
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    /**
     * 递归实现：定义根节点root后，再用subtree实现递归
     * @param subtree
     * @return
     */
    private int size(BinaryNode<T> subtree) {
        if (subtree == null) {
            return 0;
        } else {
            return size(subtree.left) + 1 + size(subtree.right);
        }
    }


    /**
     * 深度即为最大层的结点所在层次
     *
     * @return
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * 深度即为最大层的结点所在层次
     * 1.从根节点开始寻找
     * 2.分别递归计算左子树、右子树的深度
     * 3.比较左子树和右子树的深度
     * 4.返回深度最大的即可
     *
     * @param subtree
     * @return
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
        return null;
    }

    @Override
    public String inOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String levelOrder() {
        return null;
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
     *
     * @param data
     * @param p
     * @return
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
     * 分三种情况
     * 1.删除叶子节点(也就是没有孩子节点)
     * 2.删除拥有一个孩子节点的节点(可能是左孩子也可能是有孩子)
     * 3.删除有用两个孩子节点的节点
     *
     * @param data
     * @param p
     * @return
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
     * 查找最小值节点
     *
     * @param p
     * @return
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
     * 查找最大值结点
     *
     * @param p
     * @return
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
}
