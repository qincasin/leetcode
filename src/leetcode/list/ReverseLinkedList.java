package leetcode.list;

import java.util.Date;

/**
 * 翻转单链表
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @ClassName ReverseLinkedList
 * @Description
 * @Author qincasin
 * @Date 2018/12/12 15:17
 * @Version 1.0
 **/
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head !=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev= null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new  ReverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(node);
        ListNode res = solution.reverseList2(node);
        System.out.println(res);
        System.out.println(new Date());
    }

}
