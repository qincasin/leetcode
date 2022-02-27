package com.qjx.jz.offer.cap_1.sec2;

import com.qjx.AbstractClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 二进制的加法
 * 输入 两个标识 二进制的的字符串，请计算他们的和，并以二进制字符串的形式输出
 * 例如，输入的二进制字符串分别是"11"和"10"，则输出"101"
 */
public class BitAdd extends AbstractClass {
    public static void main(String[] args) throws InterruptedException {
        BitAdd bitAdd = new BitAdd();
        String s = bitAdd.addBinary("1010", "1011");
        Date date = new Date();
        TimeUnit.SECONDS.sleep(3);
        Date d = new Date();
        System.out.println((d.getTime()-date.getTime())/1000);
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digA + digB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            res.append(sum);
        }
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
