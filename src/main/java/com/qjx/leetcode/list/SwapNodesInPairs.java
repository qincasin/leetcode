package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/3/29.
 * <p>
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * l1 -> 1    2    3         4
 *       l2
 *               nextStart
 *
 * l1->  2 1 3 4
 *
 * 2 1  3  4
 *   l1 l2
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if ((head == null || head.next == null)) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode l1 = dummy;
        ListNode l2 = head;

        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            //l1 -->2
            l1.next = l2.next;
            // 2-->1
            l2.next.next = l2;
            //1 --> 3
            l2.next = nextStart;
            //l1 重新指向 1
            l1 = l2;
            //l2 重新指向 3
            l2= l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
