package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/4/22.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return (head.val == val) ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        ListNode node1 = r.removeElements2(node, 6);
        System.out.println(node1);
    }


    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return (head.val == val) ? head.next : head;
    }


}
