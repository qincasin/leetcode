package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @ClassName PalindromeLinkedList
 * @Description
 * @Author qincasin
 * @Date 2018/12/12 14:54
 * @Version 1.0
 **/
public class PalindromeLinkedList {
    /**
     * 快慢指针
     * Time:O(n)
     * Space:O(1)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }



    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        ListNode node = new ListNode(10);
        node.next = new ListNode(11);
        System.out.println(solution.reverse(node));

    }


}
