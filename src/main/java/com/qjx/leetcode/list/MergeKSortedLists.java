package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *  建议使用 PriorityQueue 方法解决该类题目
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * Created by qincasin on 2020/3/26.
 */
public class MergeKSortedLists {

    /**
     * 分治思想
     * time O(nlogk) where k is the number of linked lists   n is element
     * space O(n)
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);
    }
    /**
     * 二分法
     */
    private static ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = (high - low) / 2 + low;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return mergeKLists2(l1, l2);
    }

    /**
     * 同21. Merge Two Sorted Lists
     */
    private static ListNode mergeKLists2(ListNode l1, ListNode l2) {
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
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 递归merge
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeKLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeKLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeKLists(l1, l2.next);
        return l2;
    }

    /**
     * 针对这种题目 建议使用该方法解题
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //排序
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;


    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);

        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = n1;
        listNodes[1] = n2;
        listNodes[2] = n3;

        System.out.println(Arrays.toString(listNodes));

        ListNode listNode = mergeKLists2(listNodes);
        System.out.println(listNode);


    }
}
