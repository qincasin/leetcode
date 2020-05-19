package com.qjx.leetcode.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by qincasin on 2020/5/18.
 */
public class NextGreaterNodeInLinkedList {
    int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        System.out.println(list);

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }


    /**
     * O(n^2)
     * @param head
     * @return
     */
    int[] nextLargerNodes2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int best = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > list.get(i)) {
                   best = list.get(j);
                   break;
               }
            }
            res[i] = best;
        }
        return res;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(2, new ListNode(1,new ListNode(5)));
        ListNode node = new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5)))));
        NextGreaterNodeInLinkedList solution = new NextGreaterNodeInLinkedList();
        int[] result = solution.nextLargerNodes(node);
        System.out.println(Arrays.toString(result));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Integer peek = stack.peek();
        System.out.println(stack);
        System.out.println(peek);
        Integer pop = stack.pop();
        System.out.println(stack);
        System.out.println(pop);
    }
}
