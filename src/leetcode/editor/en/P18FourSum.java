//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Two Pointers Sorting 👍 6011 👎 686


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum
 * 
 * @author: eumes
 * @date: 2022-04-18 01:35:01
 */
 public class P18FourSum {
    public static void main(String[] args) {
        Solution_P18 solution = new Solution_P18();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int le = j + 1, ri = nums.length - 1;
                while (le < ri) {
                    int sum = nums[i] + nums[j] + nums[le] + nums[ri];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[le], nums[ri]));
                        while (le < ri && nums[le] == nums[le + 1]) {
                            le++;
                        }
                        while (le < ri && nums[ri] == nums[ri - 1]) {
                            ri--;
                        }
                        le++;
                        ri--;
                    } else if (sum < target) {
                        le++;
                    } else {
                        ri--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
