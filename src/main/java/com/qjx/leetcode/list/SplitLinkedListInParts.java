package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * Created by qincasin on 2020/5/5.
 * If there are N nodes in the list, and k parts, then every part has N/k elements, except the first N%k parts have an extra one.
 * <p>
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * <p>
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 * <p>
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 * <p>
 * Return a List of ListNode's representing the linked list parts that are formed.
 * <p>
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Note:
 * <p>
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {

        if(root ==null){
            return null;
        }
        int len = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            len++;
        }
        head = root;
        ListNode pre = null;

        int partitionNum = len / k;
        int r = len % k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++, r--) {
            res[i] = head;
            int l = partitionNum + (r > 0 ? 1 : 0);
            for (int j = 0; j < l; j++) {
                pre = head;
                head = head.next;
            }
            if (pre != null) {
                pre.next = null;
            }
        }
        return res;
    }


    public ListNode[] splitListToParts2(ListNode root, int k) {

        ListNode[] res = new ListNode[k];
        int len = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            len++;
        }
        ListNode pre = null;
        //node for every k partition
        int partitionElement = len / k;
        //except the first len%k parts have an extra one
        int r = len % k;
        for (int i = 0; i < k; i++) {
            res[i] = head;
            int l = partitionElement + (r > 0 ? 1 : 0);
            for (int j = 0; j < l; j++) {
                pre = head;
                head = head.next;
            }
            // 断开连接
            if (pre != null) {
                pre.next = null;
            }
            r--;
        }
        return res;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        SplitLinkedListInParts solution = new SplitLinkedListInParts();
        ListNode[] result = solution.splitListToParts(node, 6);
        System.out.println(Arrays.toString(result));
    }
}
