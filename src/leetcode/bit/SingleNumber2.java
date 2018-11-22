package bit;

/**
 *
 * 137.Single Number II 
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumber2 {
    /**
     * bit
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0,b = 0;
        for (int num : nums) {
            b = (b^num) & ~a;
            a = (a^num) & ~b;
        }
        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,2};
        SingleNumber2 singleNumber = new SingleNumber2();
        int result = singleNumber.singleNumber(arr);
        System.out.println(result);
    }

}
