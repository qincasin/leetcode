package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 * Created by qincasin on 2020/3/24.
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        //fast
        ListNode fast = dummy;
        //slow
        ListNode slow = dummy;
        dummy.next = head;

        //fast 先走
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //循环找到需要删除的节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //跳过
        slow.next = slow.next.next;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(listNode, 2));

    }
}
