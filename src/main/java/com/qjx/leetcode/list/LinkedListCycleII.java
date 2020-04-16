package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/3/29.
 */
public class LinkedListCycleII {
    /**
     * 快慢指针 方式 快指针 走两步 慢指针 走一步，如果两指针相遇 则代表有环
     * 相遇后 快指针 从meet 节点开始走，慢指针从 head节点开始走，当再次相遇 则就是 环的初始位置
     * 参考 https://www.cnblogs.com/hiddenfox/p/3408931.html  链接地址
     * 单链表中的环的问题还有许多扩展，比如求环的长度，或者是如何解除环等等，
     * O(n)
     * Input: head = [3,2,0,-4], pos = 1
     * Output: tail connects to node index 1
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null) {
            return null;
        }
        //再次相遇 求 起始点问题
        while (head != null) {
            if (meet == head) {
                return head;
            }
            meet = meet.next;
            head = head.next;
        }
        return null;
    }

    /**
     * o(n)
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            //第一次相遇点
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        //第二次相遇时就是其实位置
        // 求相遇点  head从头开始走，meet从当前节点开始走，当再次相遇时则就是环的起始位置点
        while (head != null) {
            if (meet == fast) {
                return meet;
            }
            fast = fast.next;
            meet = meet.next;
        }


        return null;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = new ListNode(2);
        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode result = solution.detectCycle2(node);
        System.out.println(result);
    }
}
