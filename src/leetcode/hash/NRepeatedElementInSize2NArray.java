package leetcode.hash;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 961.N-Repeated Element in Size 2N Array
 * @ClassName NRepeatedElementInSize2NArray
 * @Description 在2N个二维数组中，存在n+1个唯一元素，并且只有一个元素重复，找出这个元素
 * @Author qincasin
 * @Date 2019/1/9 11:38
 * @Version 1.0
 **/
public class NRepeatedElementInSize2NArray {

    /**
     * 利用HashMap key值唯一属性
     * map.containsKey(A[i]) 优化找到第一个出现两次的结果值
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                res = A[i];
            } else {
                map.put(A[i], map.getOrDefault(A[i] + 1, 0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //1,2,3,3

        //5, 1, 5, 2, 5, 3, 5, 4


        int[] A = new int[]{2, 1, 2, 5, 3, 2};

        NRepeatedElementInSize2NArray solution = new NRepeatedElementInSize2NArray();
        int result = solution.repeatedNTimes(A);
        System.out.println(result);

        System.out.println(new Date());

    }
}
