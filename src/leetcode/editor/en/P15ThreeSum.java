//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 17243 👎 1658


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * 
 * @author: eumes
 * @date: 2022-04-18 00:58:43
 */
 public class P15ThreeSum {
    public static void main(String[] args) {
        Solution_P15 solution = new Solution_P15();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int le = i + 1, ri = nums.length - 1;
            while (le < ri) {
                if (nums[ri] < 0) {
                    break;
                }
                int sum = nums[i] + nums[le] + nums[ri];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[le], nums[ri]));
                    while (le < ri && nums[le] == nums[le + 1]) {
                        le++;
                    }
                    while (le < ri && nums[ri] == nums[ri - 1]) {
                        ri--;
                    }
                    le++;
                    ri--;
                } else if (sum < 0) {
                    le++;
                } else {
                    ri--;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
