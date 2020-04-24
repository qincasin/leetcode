package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/4/24.
 */
public class SortList {

    /**
     * 归并排序思想
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            tmp = slow;
            fast = fast.next.next;
            slow = slow.next;

        }
        tmp.next = null;

        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);

        return merge(leftSide, rightSide);
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sortedTemp = new ListNode(0);
        ListNode currentNode = sortedTemp;

        while (l1 != null && l2 != null) {
            if(l1.val<l2.val){
                currentNode.next = l1;
                l1 = l1.next;
            }else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }

        if (l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
        }
        if(l2 !=null){
            currentNode.next = l2;
            l2 = l2.next;
        }


        return sortedTemp.next;
    }

    //TODO 三路快排思想


    public static void main(String[] args) {
        ListNode node = new ListNode(-1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(0);
        SortList solution = new SortList();
        ListNode result = solution.sortList(node);
        System.out.println(result);
    }

}
