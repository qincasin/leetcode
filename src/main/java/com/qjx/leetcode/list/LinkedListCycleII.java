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
     *  O(n)
     * @param head
     * @return
     */
    public ListNode hasCycle(ListNode head) {
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
}
