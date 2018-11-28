package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 888. Fair Candy Swap
 * 公平交换糖果
 *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 *
 * Example 1:
 *
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 *
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 *
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 *
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * It is guaranteed that Alice and Bob have different total amounts of candy.
 * It is guaranteed there exists an answer.
 *
 */
public class FairCandySwap {
    /**
     *  求A、B之和 然后求平均值，该平均值则交换后的A和B的和。
     *
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA =0 ,sumB =0;
        //求A数组的值
        for(int i:A){
            sumA+=i;
        }
        //set 提高效率
        Set<Integer> set = new HashSet<>();
        //求B数组的值
        for(int i:B){
            set.add(i);
            sumB+=i;
        }
        //求平均值
        int avg = (sumA+sumB)>>1;
        System.out.println(avg+" "+sumA+" "+sumB);
        for(int i=0;i<A.length;i++){
            //存在的target目标值
            int target = avg-(sumA-A[i]);
            //判断B中是否存在
            if(set.contains(target)){
                return new int[]{A[i],target};
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int[] A = {2};
        int[] B = {1,3};
        int[] result = fairCandySwap(A,B);
        System.out.println(Arrays.toString(result));

    }


}
