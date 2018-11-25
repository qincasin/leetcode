package array;

/**
 * 941. Valid Mountain Array
 * 验证山峰数组
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *
 *
 Example 1:

 Input: [2,1]
 Output: false
 Example 2:

 Input: [3,5,5]
 Output: false
 Example 3:

 Input: [0,3,2,1]
 Output: true


 Note:

 0 <= A.length <= 10000
 0 <= A[i] <= 10000

 *
 */
public class ValidMountainArray {

    /**
     * 如果是山峰数组的，则两个人同时爬同一座山峰如果是山峰数组，则他们肯定相遇
     *  i j 两个人
     *  n 数组长度
     *  i==j  并且 i > 0 并且 j < n-1
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int i=0;
        int j=A.length-1;
        int n=A.length;
        //上坡
        while (i+1<n&&A[i]<A[i+1]){
            i++;
        }
        //下坡
        while (j>0 && A[j-1]>A[j]){
            j--;
        }
        return i>0&&i==j&&j<n-1;

    }

    public static void main(String[] args) {
        ValidMountainArray solution = new ValidMountainArray();
        int[] arr=new int[]{3,5,5};
        boolean result = solution.validMountainArray(arr);
        System.out.println(result);

    }


}
