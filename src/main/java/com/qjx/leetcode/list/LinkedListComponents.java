package com.qjx.leetcode.list;

import java.util.HashSet;

/**
 * 817. Linked List Components
 * <pre>
 * Created by qincasin on 2020/5/17.
 *
 * We are given head, the head node of a linked list containing unique integer values.
 *
 * We are also given the list G, a subset of the values in the linked list.
 *
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 *
 * Example 1:
 *
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 *
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 *
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 * </pre>
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G.length == 0) {
            return 0;
        }

        HashSet set  = new HashSet(G.length);
        for (int i : G) {
            set.add(i);
        }

        ListNode cur = head;

        int count = 0;
        while (cur != null ) {

            //set 不存在 包含当前值 且 (当前节点为空||不包含当前节点的下一个节点)
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                count++;
            }
            set.remove(cur.val);
            cur = cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListComponents  solution = new LinkedListComponents();
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(node);
        int[] g = new int[]{0,5};
        int result = solution.numComponents(node, g);
        System.out.println(result);
        HashSet set = new HashSet();
        set.add(0);
        set.add(1);
        System.out.println(set);
        set.remove(0);
        System.out.println(set);
    }
}
