package leetcode.array;

import java.util.Arrays;

/**
 *
 * Weekly Contest 102
 * 905. Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {



    public static int[] sortArrayByParity(int[] A) {

        int[] res = new int[A.length];

        int i=0;
        int j=A.length-1;
        while (i<=j){
            if(A[i]%2!=0 &&A[j]%2==0){
                //左边奇数右边偶数  交换
                int tem = A[i];
                A[i]=A[j];
                A[j]=tem;
                i++;
                j--;
            }else if(A[i]%2!=0 && A[j]%2 !=0){
                //左边奇数，右边奇数  不交换
                j--;
            }else if(A[i]%2==0&&A[j]%2==0){
                //左边偶数 右边偶数
                i++;
            }else if(A[i]%2==0&&A[j]%2!=0){
            //左边偶数 右边奇数
                i++;
                j--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {0,1,2};
        int[] res = sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }


}
