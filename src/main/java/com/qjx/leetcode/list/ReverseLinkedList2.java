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

    public static void main(String[] args) {
        ReverseLinkedList2 solution = new ReverseLinkedList2();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(node);
//        ListNode res = solution.reverseList2(node);
//        System.out.println(res);
//        System.out.println(new Date());
    }




}
