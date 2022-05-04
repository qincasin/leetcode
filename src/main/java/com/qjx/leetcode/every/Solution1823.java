package com.qjx.leetcode.every;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution1823 {
    public static void main(String[] args) {
        Solution1823 s = new Solution1823();
        int resp = s.findTheWinner3(6, 5);
        System.out.println(resp);
    }

    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = k;
        while (queue.size() > 1) {
            while (--count > 0) {
                queue.add(queue.poll());
            }
            queue.poll(); //删除队头的元素
            count = k;
        }
        return queue.poll();
    }

    public int findTheWinner2(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                q.add(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }

    /**
     * 约瑟夫环问题 解法
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner3(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }
}
