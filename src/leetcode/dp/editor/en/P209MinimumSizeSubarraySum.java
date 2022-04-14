//Given an array of positive integers nums and a positive integer target, 
//return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, 
//numsr] of which the sum is greater than or equal to target. If there is no such 
//subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem 
//constraint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another 
//solution of which the time complexity is O(n log(n)). Related Topics Array Binary 
//Search Sliding Window Prefix Sum 👍 6263 👎 182


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-09 22:24:58
 * @title: Minimum Size Subarray Sum
 */
public class P209MinimumSizeSubarraySum {
    
    public static void main(String[] args) {
        Solution_209 solution = new Solution_209();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minCount = Math.min(minCount, i - left + 1);
                sum -= nums[left++];
            }
        }

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }

    public int minSubArrayLen_1(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE, left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            // 一直往右加，直到sum >= target
            while (sum < target && right < nums.length) {
                sum += nums[right++];
            }
            if (sum < target) {
                return minCount == Integer.MAX_VALUE ? 0 : minCount;
            }

            // 左边一直减，直到sum < target
            while (sum >= target && left < right) {
                sum -= nums[left++];
            }
            minCount = Math.min(minCount, right - left + 1);
        }

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
