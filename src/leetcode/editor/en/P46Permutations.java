//Given an array nums of distinct integers, return all the possible 
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 👍 10730 👎 192


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 * 
 * @author: eumes
 * @date: 2022-06-05 01:11:03
 */
 public class P46Permutations {
    public static void main(String[] args) {
//        Solution_P46 solution = new Solution_P46();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrace(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    // 从i开始选择nums中数字
    private void backtrace(int[] nums, int i, LinkedList<Integer> perm, List<List<Integer>> res) {
        if (i == nums.length) {
            // 找到全排列
            res.add(new LinkedList<>(perm));
            return;
        }

        // 从i开始往后找
        for (int j = i; j < nums.length; j++) {
            perm.add(nums[j]);
            // 交换i/j，保证后续待选择的数字都在后面
            swap(nums, i, j);
            backtrace(nums, i + 1, perm, res);

            // 撤销选择
            perm.removeLast();
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
