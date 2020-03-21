package com.qjx.leetcode.bit;

/**
 * 461. Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    /**
     * (1)先求x^y的结果res  先亦或
     * (2)再依次求32位res的每一位与1进行与操作的结果，若不为0，则Hamming Distance加一
     * (3)每判断完一位，res右移一位继续判断下一位
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {

        int res = x^y;
        int count = 0;
        for(int i=0;i<32;i++){
            if((res&1)!=0){
                count++;
            }
            res>>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance solution = new HammingDistance();
        System.out.println(solution.hammingDistance(1,4));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(solution.hammingDistance(1,10));
    }

}
