package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * @author qincasin
 * @date 2020/4/29
 */
public class OddEvenLinkedList {

    /**
     * 将链表隔一个元素取一个元素，拆分成奇链表和偶链表，然后将偶链表全部链到奇链表的尾部
     * space o 1
     * time o n
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }

        //split odd and even
        // 奇
        ListNode odd = head;
        //偶
        ListNode even = head.next;

        ListNode evenList = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenList;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode result = solution.oddEvenList(node);
        System.out.println(result);
    }

}
