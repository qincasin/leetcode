package com.qjx.leetcode.every;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 */
public class Solution380 {
    public static void main(String[] args) {
        Solution380 solution380 = new Solution380();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        Integer remove = map.remove(1);

    }
   static class RandomizedSet {

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return false;
        }

        public boolean remove(int val) {
            return true;
        }

        public int getRandom() {
            return 0;
        }
    }

}
