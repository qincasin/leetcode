package com.qjx.leetcode.common;

import lombok.Data;

/**
 * Created by qincasin on 2020/3/21.
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

