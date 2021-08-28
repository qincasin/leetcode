//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4416 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double s = solution.doFindMedianSortedArrays(nums1, nums2);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return doFindMedianSortedArrays(nums1, nums2);
        }

        private double doFindMedianSortedArrays(int[] nums1, int[] nums2) {

            int m = nums1.length;

            int len = nums1.length + nums2.length;
            int[] all = new int[len];
            for (int i = 0; i < nums1.length; i++) {
                all[i] = nums1[i];
            }
            merge(all, nums2, m, nums2.length);
            if (len % 2 == 0) {
                return (all[len / 2 - 1] + all[len / 2] + 0.0) / 2;
            } else {
                return all[len / 2];
            }
        }

        private void merge(int[] nums1, int[] nums2, int m, int n) {
            int i = m - 1, j = n - 1;
            int idx = m + n - 1;
            while (i >= 0 || j >= 0) {
                if (i >= 0 && j >= 0) {
                    nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
                } else if (i >= 0) {
                    nums1[idx--] = nums1[i--];
                } else {
                    nums1[idx--] = nums2[j--];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}