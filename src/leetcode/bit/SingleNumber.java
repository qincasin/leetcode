package bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 */
public class SingleNumber {

    /**
     * 方法一 bit
     * ^ 操作
     * time:O(n)
     * Space:O(1)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a=a^num;
        }

        return a;
    }

    /**
     * map方法  存在则remove 不存在则put
     * time:O(n)
     * Space:O(n)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if(map.containsKey(num)){
                map.remove(num);
            }else {
                map.put(num,false);
            }
        }
        for (Map.Entry<Integer,Boolean> key:map.entrySet()) {
            return key.getKey();
        }
        return 0;
    }





    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        int result = singleNumber.singleNumber2(arr);
        System.out.println(result);

    }


}
