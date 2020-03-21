package com.qjx.leetcode.list;

/**
 * 21. Merge Two Sorted Lists
 *Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * @author casin
 * @create 2018-10-16 12:48
 **/

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * dummy list，新建一个链表，然后两个链表中从头各取一个元素进行比较，小的写入新链表，直到结束，返回dummy.next。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode flag = new ListNode(0);
        ListNode firstFlag  = flag;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                flag.next=l1;
                l1=l1.next;
            }else {
                flag.next=l2;
                l2=l2.next;
            }
            flag=flag.next;
        }
        flag.next = l1 != null ? l1 : l2;
        return firstFlag.next;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        System.out.println(mergeTwoLists(l3,l4));

    }



    }
