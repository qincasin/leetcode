package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

import java.util.Date;

/**
 * 翻转单链表
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
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
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(node);
        ListNode res = solution.reverseList4(node);
        System.out.println(res);
        System.out.println(new Date());
    }


    /**
     * 迭代解法
     * 时间复杂度O(n) n为链表的长度
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next; //保存下一个节点
            head.next = pre;  //让每一次的当前节点的下一个节点都指向pre  也就是 1-->null   原来是 1-->2-->3  ；下一次的时候 也就是 2-->pre  也就是==> 2-->1-->null
            pre = head;  //pre 前进一位
            head = next; //当前节点往下走一位
        }
        return pre;
    }

    /**
     * 递归解法
     * 时间复杂度和空间复杂度均为:O(n)
     * @return
     */
    public ListNode reverseList5(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        //cur 代表最后一个节点
        ListNode cur = reverseList5(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;



    }


}
