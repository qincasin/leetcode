package com.qjx.leetcode.every;

import java.util.HashMap;
import java.util.Map;

public class Solution_762 {
    public static void main(String[] args) {
        Solution_762 s = new Solution_762();
//        System.out.println(s.countPrimeSetBits(6, 6));
//        System.out.println(s.countPrimeSetBits(7, 7));
//        System.out.println(s.countPrimeSetBits(8, 8));
//        System.out.println(s.countPrimeSetBits(9, 9));
//        System.out.println(s.countPrimeSetBits(10, 10));
        System.out.println(s.countPrimeSetBits(842, 842));

//        System.out.println(s.countBits(7));
    }
    Map<Integer,Boolean> map = new HashMap<>();


    public int countPrimeSetBits(int left, int right) {
        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            int bits = countBits(i);
            if (isPrime(bits)) {
                sum++;
            }
        }
        return sum;
    }

    private int countBits(int num) {
        int sum = 0;
        while (num != 0) {
            sum++;
            num = num & (num - 1);
        }
        return sum;
    }


    private boolean isPrime(int num) {
        Boolean aBoolean = map.get(num);
        if (aBoolean!=null){
            return aBoolean;
        }
        if (num <= 3) {
            map.put(num,num>1);
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            map.put(num,false);
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                map.put(num,false);
                return false;
            }
        }
        map.put(num,true);
        return true;
    }

}
