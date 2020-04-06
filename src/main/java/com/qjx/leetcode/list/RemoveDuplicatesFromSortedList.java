package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Created by qincasin on 2020/4/3.
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Return the linked list sorted as well.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedList {
    //    public ListNode deleteDuplicates(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = slow.next;
//        while (fast != null) {
//            快指针先走一步
//            if (fast.val == slow.val) {
//                slow.next = fast;
//                slow = fast;
//            } else {
//                slow = slow.next;
//            }
//            fast = fast.next;
//        }
//        slow.next = fast;
//        return head;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        //快指针
        ListNode fast = slow.next;
        while (fast != null) {
            //不相等 慢指针的下一个节点指向快指针，慢指针走一步
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
//        listNode.next.next.next.next.next.next = new ListNode(5);
        ListNode result = solution.deleteDuplicates(listNode);
        System.out.println(result);
    }

}
