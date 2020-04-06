package com.qjx.leetcode.list;

import com.qjx.leetcode.common.ListNode;

/**
 * Created by qincasin on 2020/3/29.
 * 86 Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    /**
     * 整体思路   添加两个临时节点， 小于x的 存储到 lessHead ， >= 的存储在moreHead节点，
     * 最后在连接两个节点为一个节点即可
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        //临时 头节点
        ListNode moreHead = new ListNode(0);
        ListNode lessHead = new ListNode(0);
        ListNode more = moreHead;
        ListNode less = lessHead;

        while (head != null) {
            if (head.val < x) {
                //小于则插入到less之后
                less.next = head;
                //链接完成后，less节点向后移动，指向head
                less = head;
            } else {
                more.next = head;
                more = head;
            }
            head = head.next;
        }
        //链接两个链表
        less.next = moreHead.next;
        //tail.next  设置为null
        more.next = null;
        return lessHead.next;
    }


    /**
     * 使用两个临时节点，smallNode 存储 < x ,bigNode 存储 >= x的 节点
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode smallNode = new ListNode(0);
        ListNode bigNode = new ListNode(0);
        ListNode small = smallNode;
        ListNode big = bigNode;

        while (head!=null){
            if(head.val<x){
                small.next = head;
                small = head;
            }else {
                //最后一轮 big 为 5 -> 2 -> null
                big.next = head;
                big = head;
            }
            head = head.next;
        }

        //big.next: 2->null,   -->   5->null
        big.next = null;
        small.next = bigNode.next;

        return smallNode.next;
    }












    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode partition = partition2(listNode, x);
        System.out.println(partition);
    }


}
