package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

import java.util.Date;

/**
 * 翻转单链表
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @ClassName ReverseLinkedList
 * @Description
 * @Author qincasin
 * @Date 2018/12/12 15:17
 * @Version 1.0
 **/
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);
        ListNode res = solution.reverseList3(node);
        System.out.println(res);
        System.out.println(new Date());
    }

}
