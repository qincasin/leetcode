package com.qjx.leetcode.common;


import java.util.List;

/**
 * Created by qincasin on 2020/3/21.
 */



public class Node {


    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<com.qjx.leetcode.common.Node> _children) {
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
