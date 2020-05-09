package com.qjx.leetcode.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by qincasin on 2020/5/9.
 */
class Node2 {
   public int val;
   public Node2 prev;
   public Node2 next;
   public Node2 child;
}
public class FlattenAMultilevelDoublyLinkedList {
   /**
    * 1.如果当前节点有孩子节点，push 当前节点的next节点
    * child 节点指向当前节点 如果child节点不为空 链表追加当前节点
    *
    * 2.如果当前节点为空 并且 stack 不为空， pop 指向当前节点的next节点 , 链表追加当前节点
    * @param head
    * @return
    */
   public Node2 flatten(Node2 head){
      if (head == null) {
         return null;
      }

      Deque<Node2> stack = new ArrayDeque<>();
      Node2 cur = head;
      while (cur != null) {
         if (cur.child != null) {

            if (cur.next != null) {
               stack.push(cur.next);
            }
            cur.next = cur.child;
            if (cur.next != null) {
               cur.next.prev = cur;
            }
            cur.child = null;
         } else if (cur.next == null && !stack.isEmpty()) {
            cur.next = stack.pop();
            cur.next.prev = cur;
         }
         cur = cur.next;
      }

      return head;

   }
}
