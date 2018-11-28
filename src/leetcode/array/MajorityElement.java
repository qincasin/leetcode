package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中多数派元素
 *169. Majority Element
 *
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * @author casin
 * @create 2018-09-18 12:44
 **/
public class MajorityElement {

    /**
     * 使用map key 存储数组，value 统计出现的次数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;
        for(int i:nums){
            map.put(i,map.get(i)==null?1:map.get(i).intValue()+1);
            if(map.get(i).intValue()>(nums.length/2)){
                res=i;
            }

        }
        return res;
    }

    /**
     * 排序，取数组mid，最后返回num[mid]值即为结果
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int t = nums.length/2;
        return nums[t];
    }


    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        majorityElement(nums);
    }

}
