package com.qjx.leetcode.list;


/**
 * Created by qincasin on 2020/5/17.
 */
public class MyLinkedList {

    private ListNode head;

    int size ;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode pre = head;
        head = new ListNode(val);
        head.next = pre;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode tail = new ListNode(val);
        size++;
        if (head == null) {
            head = tail;
        } else {
            ListNode cur = head;
            //find tail
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = tail;
        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size) {
            return;
        }
        if (size == 0 || index == 0) {
            //无节点时 直接在头节点插入
            addAtHead(val);
        }else {
            size++;
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            ListNode node = new ListNode(val);
            node.next = cur.next;
            cur.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }
        if (index == 0) {
            //删除头节点
            delHead();
        }else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
            size--;
        }
    }

    public void delHead(){
        if(size>0){
            head = head.next;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        m.addAtHead(1);
        m.addAtTail(3);
        m.addAtIndex(1,2);
        m.get(1);
        m.deleteAtIndex(0);
        m.get(0);
    }
}
