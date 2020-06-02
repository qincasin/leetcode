package com.qjx.leetcode.list;

import java.util.Stack;

/**
 * Created by qincasin on 2020/5/29.
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberINALinkedListToInteger {

    /**
     * 方法一 ：  使用栈  入栈 ，然后pop出来 ，每次pop时 ^运算
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }

        int sum = 0;
        int index = 0;
        while (!stack.empty()) {
            Integer pop = stack.pop();
            if (pop == 1) {
                sum += (int) Math.pow(2, index);
            }
            index++;
        }
        return sum;
    }
    /**
     * 方法二 ： 使用<< | 运算  左移一位 等于乘以 2
     * ans = ans * 2 + head.val;
     * 参考这个链接 https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/451815/JavaPython-3-Simulate-binary-operations.
     * @param head
     * @return
     */
    public int getDecimalValue2(ListNode head) {
        if (head == null) {
            return 0;
        }
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ConvertBinaryNumberINALinkedListToInteger s = new ConvertBinaryNumberINALinkedListToInteger();
        ListNode node = new ListNode(1,new ListNode(0,new ListNode(1)));
        int result = s.getDecimalValue2(node);
        System.out.println(result);
    }
}
