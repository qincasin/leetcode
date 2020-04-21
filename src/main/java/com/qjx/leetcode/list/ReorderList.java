package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

import java.util.Stack;

/**
 * <pre>
 * Created by qincasin on 2020/4/19.
 * 143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * </pre>
 */
public class ReorderList {
    /**
     * 1.找中点
     * 2.l2 翻转
     * 3.l1、l2 重新组建链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //找中点
        ListNode mid = findMid(head);

        ListNode l2 = mid.next;
        mid.next = null;

        //翻转l2
        l2 = reverse(l2);
        ListNode l1 = head;
        //reorder l1 l2
        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
        System.out.println(head);
    }

    //reverse
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    //findMid
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ReorderList solution = new ReorderList();
        solution.reorderList(node);
    }
}
