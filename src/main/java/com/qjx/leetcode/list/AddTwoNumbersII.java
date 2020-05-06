package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/4/30.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(addTwoNum(l1, l2));
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            dummy.next = new ListNode(sum % 10);
            sum /= 10;
            dummy = dummy.next;
        }
        if (sum == 1) {
            dummy.next = new ListNode(1);
        }
        return cur.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(a.addTwoNumbers(l1, l2));

    }


}
