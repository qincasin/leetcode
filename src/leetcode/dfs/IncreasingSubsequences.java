package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 增加的序列
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 *
 *
 *
 * Example:
 *
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 *
 * Note:
 *
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 * @author: qincasin
 * @date: 2019/8/22/ 18:08
 */
public class IncreasingSubsequences {


  public List<List<Integer>> findSubsequences(int[] nums) {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> curRes = new ArrayList<>();
    DFS(results, nums, 0, curRes);
    return results;
  }

  private void DFS(List<List<Integer>> res, int[] nums, int curPos, List<Integer> curRes) {
    if (curRes.size() > 1) {
      res.add(new ArrayList<>(curRes));
    }
    if (curRes.size() == nums.length) {
      return;
    }
    Set<Integer> set = new HashSet<>();

    for (int i = curPos; i < nums.length; i++) {
      //
      if (curRes.size() >= 1 && nums[i] < curRes.get(curRes.size()-1)) {
        continue;
      }
      //如果是排序好的话 可以使用如下方法判断
      //if(i>=1 && nums[i]==nums[i-1]&&visited[i-1]==false continu)
      if (set.contains(nums[i])) {
        continue;
      }
      set.add(nums[i]);
      curRes.add(nums[i]);
      DFS(res, nums, i + 1, curRes);
      //回溯 list中的最后一个数字剔除
      curRes.remove(curRes.size() - 1);
    }
  }

  //[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
  public static void main(String[] args) {
    IncreasingSubsequences solution = new IncreasingSubsequences();
    int[] nums = {4, 6, 7, 7};
    List<List<Integer>> result = solution.findSubsequences(nums);
    System.out.println("result:" + result);
  }

}
