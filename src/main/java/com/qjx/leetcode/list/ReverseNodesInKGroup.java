package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * <pre>
 * Created by qincasin on 2020/3/31.
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * 25. Reverse Nodes in k-Group
 * </pre>
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        while (dummy.next != null) {
            dummy.next = dummy.next.next;
            len++;
        }

        dummy.next = head;
        for (int i = 0; i < len / k; i++) {
            //处理下标   按照 1 2 3 4 5 6   对应的下标为 1 2 3 4 5 处理
            dummy.next = reverseBetween(dummy.next, k * i + 1, k * (i + 1));
        }

        return dummy.next;

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
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

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode result = reverseKGroup(listNode, 3);
        System.out.println(result);
    }

}
