package sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Date;
import java.util.Queue;

/**
 * 922. Sort Array By Parity II
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 * 大概意思: 给定的数据中，
 */
public class SortArrayByParityII {

    /**
     * 直接引入队列计算，效率低
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];

        //奇数
        Queue<Integer> odd = new ArrayDeque<>();
        //偶数
        Queue<Integer> even = new ArrayDeque<>();

        for (int i = 0; i < A.length; i++) {
            if(A[i]%2==0){
                even.add(A[i]);
            }else {
                odd.add(A[i]);
            }
        }

        System.out.println(odd);
        System.out.println(even);
        int n1 =0;
        int n2 =1;
        for (Integer i : even) {
            res[n1] = i;
            n1+=2;
        }
        for (Integer i : odd) {
            res[n2] = i;
            n2+=2;
        }
        return res;
    }


    /**
     * 效率高 一次循环搞定
     * A[i]%2 == 0
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int[] res = new int[A.length];

        int eIndex = 0;
        int oIndex = 1;
        for (int i = 0; i < A.length; i++) {
            //偶数
            if(A[i]%2 == 0){
                res[eIndex] = A[i];
                eIndex+=2;
            }else {
                res[oIndex] = A[i];
                oIndex += 2;
            }
        }
        return res;
    }


    /**
     * 效率高 一次循环搞定
     *  使用A[i] & 1) == 0 来计算
     *  A[i] & 1) == 0 等同于  A[i]%2 == 0
     * @param A
     * @return
     */
    public int[] sortArrayByParityII3(int[] A) {
        int[] res = new int[A.length];

        int eIndex = 0;
        int oIndex = 1;
        for (int i = 0; i < A.length; i++) {
            //偶数
            if((A[i] & 1) == 0){
                res[eIndex] = A[i];
                eIndex+=2;
            }else {
                res[oIndex] = A[i];
                oIndex += 2;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] arr = new int[]{4,2,5,7};
        int[] res = sortArrayByParityII.sortArrayByParityII3(arr);
        System.out.println(Arrays.toString(res));
        System.out.println(new Date());
    }

}
