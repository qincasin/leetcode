package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 448. Find All Numbers Disappeared in an Array
 * 查找数组中消失的所有数字
 *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * @author casin
 * @create 2018-09-17 15:53
 **/
public class FindAllNumbersDisappearedInAnArray {
    /**
     *  找出数组中的值与其值应该在下标的位置关系
     *  nums[i]与nums[|nums[i]|-1]
     *  取负值 如果为正则取该值对应的下标+1
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        //判断值关系
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            nums[index]=(nums[index]>0)?(-nums[index]):nums[index];
        }
        //取出数组中值为正的下标+1
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

}
