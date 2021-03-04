package com.qjx.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qincasin on 2021/3/4.
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateNodes {
    /**
     * 虚拟一个头节点 删除使用到set数据结构
     * 空间复杂度O(n)
     * 时间复杂度 O(n)
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next!=null){
            if(!set.contains(pre.next.val)){
                set.add(pre.next.val);
                pre = pre.next;
            }else {
                pre.next = pre.next.next;
            }
        }
        return dummy.next;
    }

    /**
     * 暴力解法
     * 时间复杂度O(n*n)
     * 空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next!=null){
                if(pre.next.val==cur.next.val){
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        return dummy.next;
    }

        public static void main(String[] args) {
        RemoveDuplicateNodes s = new RemoveDuplicateNodes();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        ListNode node1 = s.removeDuplicateNodes2(node);
        System.out.println(node1);
    }



}
