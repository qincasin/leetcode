//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6624 👎 0


package leetcode.editor.cn;

import com.qjx.leetcode.common.ListNode;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode resp = solution.addTwoNumbers(l1, l2);
        System.out.println(resp);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /**
         * 2021-09-26
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            int t = 0;
            ListNode cur = dummy;
            ListNode p1 = l1, p2 = l2;
            while (p1 != null || p2 != null || t != 0) {
                if (p1 != null) {
                    t += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    t += p2.val;
                    p2 = p2.next;
                }
                //求进位
                cur.next = new ListNode(t % 10);
                t = t / 10;
                cur = cur.next;
            }
            return dummy.next;
        }

//        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
//            ListNode dummy = new ListNode(0);
//            ListNode cur = dummy;
//            int sum = 0;
//            ListNode p1 = l1, p2 = l2;
//            while (p1 != null || p2 != null) {
//                if (p1 != null) {
//                    sum += p1.val;
//                    p1 = p1.next;
//                }
//                if (p2 != null) {
//                    sum += p2.val;
//                    p2 = p2.next;
//                }
//                cur.next = new ListNode(sum % 10);
//                sum = sum / 10;
//                cur = cur.next;
//            }
//            if (sum == 1) {
//                cur.next = new ListNode(1);
//            }
//            return dummy.next;


//            ListNode dummy = new ListNode(0);
//            ListNode cur = dummy;
//            int sum = 0;
//            //暂存
//            ListNode p1 = l1, p2 = l2;
//            while (p1 != null || p2 != null) {
//                //处理p1
//                if (p1 != null) {
//                    sum += p1.val;
//                    p1 = p1.next;
//                }
//                //处理p2
//                if (p2 != null) {
//                    sum += p2.val;
//                    p2 = p2.next;
//                }
//                //cur 当前节点是 0 ，从下一个节点开始
//                cur.next = new ListNode(sum % 10);
//                sum = sum / 10;
//                cur = cur.next;
//            }
//            if (sum == 1) {
//                cur.next = new ListNode(1);
//            }
//
//            return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
