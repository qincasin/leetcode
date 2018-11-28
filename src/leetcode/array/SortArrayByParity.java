package array;

import java.util.Arrays;
import java.util.Date;

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



    public  int[] sortArrayByParity(int[] A) {

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

    /**
     * time: Wed Nov 28 21:29:11 CST 2018
     * 二刷
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity2(int[] A) {
        int[] res = new int[A.length];
        int i = 0;
        int j = A.length-1;
        for (int a:A) {
            if(a%2==0) {
                res[i++]=a;
            }else {
                res[j--]=a;
            }
        }

        return res;
    }

    /**
     * time:Wed Nov 28 21:49:05 CST 2018
     * 三刷
     * 交换
     * @param A
     * @return
     */
    public int[] sortArrayByParity3(int[] A) {
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

        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] A = {0,1,2};
        int[] res = sortArrayByParity.sortArrayByParity2(A);
        System.out.println(Arrays.toString(res));
        System.out.println(new Date());
    }




}
