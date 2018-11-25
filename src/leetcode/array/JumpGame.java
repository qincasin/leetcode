package array;

/**
 * 55. Jump Game
 * 给定一个数组，每个数字代表当前可向后走的最大步数。从第一个数字开始，求是否能走到最后一个数字位置，若能，返回true，否则返回false
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    /**
     * 纪录当前能走的最大步数，即从前一步的最大步数减一和当前下标对应步数中选择最大的一个，如果最大步数非零，向前走一步，直到走到最后一个数字。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length<1){
            return false;
        }
        if(nums.length==1){
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max<i){
                return false;
            }
            max = i+nums[i] > max ? i + nums[i] : max;
            if(max>=nums.length-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        //3,2,1,0,4 false
        int[] nums = new int[]{2,3,1,1,4};
        boolean result = solution.canJump(nums);
        System.out.println(result);


    }


}
