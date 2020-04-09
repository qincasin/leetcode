package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * 翻转单链表2
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @ClassName ReverseLinkedList
 * @Description
 * @Author qincasin
 * @Date 2018/12/12 15:17
 * @Version 1.0
 **/
public class ReverseLinkedList2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        //计算需要逆置的节点个数
        int change_len = n - m + 1;
        //初始化开始逆置的节点的前驱
        ListNode preHead = null;
        //最终转换后的链表节点,非特殊情况就是 head
        ListNode result = head;
        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }

        ListNode modifyListTail = head;
        ListNode newHead = null;
        while (head != null && change_len > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            change_len--;
        }
        modifyListTail.next = head;
        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }
        return result;
    }


    public ListNode reverseBetween2(ListNode head, int m, int n) {
        int len = n - m + 1;

        ListNode result = head;
        ListNode pre = null;
        while (head != null && --m > 0) {
            pre = head;
            head = head.next;
        }

        ListNode tail = head;
        ListNode mid = null;
        while (head != null && len-- > 0) {
            ListNode next = head.next;
            head.next = mid;
            mid = head;
            head = next;
        }
        tail.next = head;
        if (pre != null) {
            pre.next = mid;
        } else {
            result = mid;
        }
        return result;
    }


    public static void main(String[] args) {
        ReverseLinkedList2 solution = new ReverseLinkedList2();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode res = solution.reverseBetween2(node, 3, 5);
        System.out.println(res);
    }


}
