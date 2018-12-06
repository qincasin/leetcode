package sort;

import java.util.Arrays;
import java.util.Date;

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
 * 大概意思: 给定的数据中，将数据中的值进行排序，
 * 输出:
 * 数组的下表为奇数与之对应的数组值也是奇数，
 * 数组的下标为偶数与之对应的数组值也是偶数
 */
public class SortArrayByParityII {
    /**
     * 交换
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0,j=0; j < A.length; j++) {
            if(A[j]%2==0){
                int tmp = A[i];
                A[i++]= A[j];
                A[j] = tmp;
            }
        }


        return A;
    }
    

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] A = new int[]{4,2,5,7};
        int[] res = sortArrayByParityII.sortArrayByParityII(A);
        System.out.println(Arrays.toString(res));
        System.out.println(new Date());


    }




}
