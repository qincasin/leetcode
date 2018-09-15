package leetcode.array;

/**
 * 单调数据
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 *
 *
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 *
 * 单调数判断
 */
public class MonotonicArray {

    /**
     * 常规方案
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {

        //ascStatus 递增 默认true
        //descStatus 递减 默认true
        boolean ascStatus = true;
        boolean descStatus = true;
        if (A.length == 1||A.length==0) {
            return true;
        }
        //循环内判断递增或者递减
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                ascStatus = false;
            }
            if (A[i] > A[i + 1]) {
                descStatus = false;
            }
        }
        return (ascStatus||descStatus);
    }

    /**
     * 递归方案
     * @param A
     * @return
     */
    public static boolean isMonotonic2(int[] A) {
        int len = A.length;
        return isDecrease(A,len)||isIncrease(A,len);
    }
    /**
     * 递增判断  递归
     * @param A
     * @param len
     * @return
     */
    public static boolean isIncrease(int[] A,int len){
        if(len==1){
            return true;
        }
        return (A[len-2]<=A[len-1]&&isIncrease(A,len-1));
    }

    /**
     * 递减判断 递归
     * @param A
     * @param len
     * @return
     */
    public static boolean isDecrease(int[] A,int len){
        if(len==1){
            return true;
        }
        return (A[len-2]>=A[len-1]&&isDecrease(A,len-1));
    }



    public static void main(String[] args) {
        int[] A = {1,2,2,3,3,4,5};
        System.out.println(isMonotonic2(A));
    }


}
