package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * @ClassName ContiguousArray
 * @Description 连续数组
 * @Author qincasin
 * @Date 2019/1/9 9:52
 * @Version 1.0
 **/
public class ContiguousArray {


    /**
     * hash
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {

        nums = Arrays.stream(nums).filter(Objects::nonNull).map(v -> v == 0 ? -1 : v).toArray();

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                nums[i] = -1;
//            }
//        }

        Map<Integer, Integer> sumToIndex = new HashMap<>();

        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();
        int[] nums = new int[]{0, 1, 0};
        int[] nums2 = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
        int result = solution.findMaxLength(nums2);
        System.out.println(result);


    }

}
