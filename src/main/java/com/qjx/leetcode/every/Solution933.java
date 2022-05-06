package com.qjx.leetcode.every;

import java.util.*;

public class Solution933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }


    /**
     * 队列的思维解决
     * 时间复杂度O(1),time O(n)
     * @param t
     * @return
     */
    public int ping(int t) {
        queue.add(t);
        if (t < 3000) {
            return queue.size();
        }
        int start = t - 3000;
        //当且仅当 队列中有值 && 最早入队列的数要 小于 start 时 ，将其 出队
        while (t > 3000 && queue.peek() != null && queue.peek() < start) {
            queue.poll();
        }
        return queue.size();
    }
}
