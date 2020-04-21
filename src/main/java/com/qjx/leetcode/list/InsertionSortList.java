package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/4/21.
 * 插入排序 链表实现
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null && cur.next != null) {
            //小于
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            }else {
                //需要调换 从dummy.next开始遍历
                pre = dummy;
                tmp = cur.next; //先保存
                cur.next = cur.next.next;
                //比较 如果 小于 则继续 ，否则 insert 后面
                while (pre.next.val <= tmp.val) {
                    pre = pre.next;
                }
                //insert
                tmp.next = pre.next;
                pre.next = tmp;
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        ListNode result = solution.insertionSortList(node);
        System.out.println(result);
    }
}
