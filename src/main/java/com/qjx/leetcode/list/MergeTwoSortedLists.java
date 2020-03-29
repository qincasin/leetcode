package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author casin
 * @create 2018-10-16 12:48
 **/

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //dummy list，新建一个链表，然后两个链表中从头各取一个元素进行比较，小的写入新链表，直到结束，返回dummy.next
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        head.next = (l1 == null) ? l2 : l1;

        return dummy.next;

    }

    /**
     * 递归方式 merge 两个 linked list
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists3(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoLists3(l1, l2));

    }


    /**
     * dummy list，新建一个链表，然后两个链表中从头各取一个元素进行比较，小的写入新链表，直到结束，返回dummy.next。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode flag = new ListNode(0);
        ListNode firstFlag = flag;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                flag.next = l1;
                l1 = l1.next;
            } else {
                flag.next = l2;
                l2 = l2.next;
            }
            flag = flag.next;
        }
        flag.next = l1 != null ? l1 : l2;
        return firstFlag.next;
    }

//    public static void main(String[] args) {
//        ListNode l3 = new ListNode(1);
//        ListNode l4 = new ListNode(2);
//        System.out.println(mergeTwoLists(l3, l4));
//
//    }



}
