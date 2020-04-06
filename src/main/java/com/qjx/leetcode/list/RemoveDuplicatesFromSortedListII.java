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
public class RemoveDuplicatesFromSortedListII {
    //    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = head;
//        while (dummy.next != null) {
//            dummy = dummy.next;
//        }
//        if (head.val == dummy.val) {
//            return null;
//        }
//        dummy = head;
//        ListNode pre = new  ListNode(0);
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            pre.next = head;
//            fast = fast.next;
//            if (slow.val == fast.val) {
//                pre.next = fast.next;
//                slow = fast.next;
//                fast = fast.next;
//                continue;
//            }
//            pre = slow;
//            slow = slow.next;
//        }
//        return head;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode preNode = dummy;
        ListNode realNode = dummy;
        ListNode cur = head;

        while (cur != null) {
            //需要保留值 当前值不和前后节点一样
            if ((preNode == dummy || cur.val != preNode.val) && (cur.next == null || cur.val != cur.next.val)) {
                //指向需要保留的节点
                realNode.next = cur;
                realNode = cur;
            }
            //pre 往后走一步 ，cur 往后走一步
            preNode = cur;
            cur = cur.next;
            //pre的下一个节点指向null
            preNode.next = null;
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next.next = new ListNode(4);
        ListNode result = solution.deleteDuplicates(listNode);
        System.out.println(result);
    }

}
