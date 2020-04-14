package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/3/29.
 */
public class LinkedListCycle {

    /**
     * 快慢指针 方式 快指针 走两步 慢指针 走一步，如果两指针相遇 则代表有环
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }




































    /**
     * 快慢指针 方式 快指针 走两步 慢指针 走一步，如果两指针相遇 则代表有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast == null){
                return false;
            }
            fast = fast.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }



}
