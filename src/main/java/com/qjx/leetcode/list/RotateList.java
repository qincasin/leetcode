package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * <pre>
 * 61. Rotate List
 * Created by qincasin on 2020/4/1.
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 * </pre>
 */
public class RotateList {

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        while (dummy.next != null) {
            len++;
            dummy = dummy.next;
        }
        //求余数
        k = k % len;
        ListNode slow = head;
        ListNode fast = head;

        //走到 3 节点
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //fast 继续走，slow 从头开始走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //处理后续节点
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }


    public static void main(String[] args) {
        RotateList solution = new RotateList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode res = solution.rotateRight(node, 2);
        System.out.println(res);
//        System.out.println(10 % 3);

//        int i = 3;
//        ListNode l = null;
//
//        while (node != null && --i > 0) {
//            l = node;
//            l.next =
//            node = node.next;
//        }
//        System.out.println(l);
//        System.out.println(node);


        for (int i = 0; i < 0; i++) {
            System.out.println(i);
        }

    }
}
