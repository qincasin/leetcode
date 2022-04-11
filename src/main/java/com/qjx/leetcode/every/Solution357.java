package com.qjx.leetcode.every;

import org.apache.xmlbeans.impl.xb.xsdschema.Facet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 */
public class Solution357 {
    public static void main(String[] args) {
        Solution357 s = new Solution357();
        //3 -- 776  ; 4 6148;5 49384; 6 418240;7 3819520;8  36925120
        // 3 --- 739

        long start = System.currentTimeMillis();
        int resp = s.countNumbersWithUniqueDigits(8);
        long l = System.currentTimeMillis();
        long end1 = l - start;
        System.out.println("end1 "+end1);
        int resp2 = s.countNumbersWithUniqueDigits2(8);
        long end2 = System.currentTimeMillis() - l;
        System.out.println(end1 + "  " + end2);
        System.out.println(resp);
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
//        int[] num = new int[]{1,1, 91, 739,5275 , 32491, 168571, 712891, 2345851};
//        return num[n];
        int[] num = new int[]{0, 1, 99, 999, 9999, 99999, 999999, 9999999, 99999999};
        int number = num[n];
        int sum = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i <= number; i++) {
            if (map.get(i)!=null) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int j = i;
            boolean flg = true;
            while ((j % 10) > 0 || j / 10 != 0) {
                if (set.contains(j % 10)) {
                    flg = false;
                    map.put(i, true);
//                    System.out.println(i);
                    break;
                } else {
                    set.add(j % 10);
                }
                j = j / 10;
                if (map.get(j)!=null) {
                    map.put(i, true);
                    break;
                }
            }
            if (flg) {
                sum++;
            }
        }

        return sum;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
//        int[] num = new int[]{1,1, 91, 739,5275 , 32491, 168571, 712891, 2345851};
//        return num[n];
        int[] num = new int[]{0, 1, 99, 999, 9999, 99999, 999999, 9999999, 99999999};
        int number = num[n];
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            Set<Integer> set = new HashSet<>();
            int j = i;
            boolean flg = true;
            while ((j % 10) > 0 || j / 10 != 0) {
                if (set.contains(j % 10)) {
                    flg = false;
                    break;
                } else {
                    set.add(j % 10);
                }
                j = j / 10;
            }
            if (flg) {
                sum++;
            }
        }

        return sum;
    }
}
