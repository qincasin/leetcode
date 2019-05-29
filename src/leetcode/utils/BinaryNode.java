package leetcode.utils;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Author:qincasin <qinjiaxing@shein.com>
 * Since:2019/5/28 16:38
 * Version:1.1.0
 */
public class BinaryNode<T extends Comparable> implements Serializable {

    public BinaryNode<T> left;

    public BinaryNode<T> right;

    public T data;

    public BinaryNode(T data,BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryNode(T data) {
        this.data = data;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }
}
