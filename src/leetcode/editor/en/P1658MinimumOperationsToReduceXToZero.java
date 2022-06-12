//You are given an integer array nums and an integer x. In one operation, you 
//can either remove the leftmost or the rightmost element from the array nums and 
//subtract its value from x. Note that this modifies the array for future 
//operations. 
//
// Return the minimum number of operations to reduce x to exactly 0 if it is 
//possible, otherwise, return -1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
//Explanation: The optimal solution is to remove the last two elements to 
//reduce x to zero.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,6,7,8,9], x = 4
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,20,1,1,3], x = 10
//Output: 5
//Explanation: The optimal solution is to remove the last three elements and 
//the first two elements (5 operations in total) to reduce x to zero.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
// Related Topics Array Hash Table Binary Search Sliding Window Prefix Sum 👍 29
//89 👎 63


package leetcode.editor.en;

/**
 * Minimum Operations to Reduce X to Zero
 * 
 * @author: eumes
 * @date: 2022-06-12 02:03:57
 */
 public class P1658MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
//        Solution_P1658 solution = new Solution_P1658();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1658 {
    public int minOperations(int[] nums, int x) {
        // 首尾元素和 = x, ==> 找到nums中子数组和 = sum(nums) - x
        int sum = -x;
        for (int num : nums) {
            sum += num;
        }

        // 找到nums中和为 sum的最长子数组
        int curSum = 0, le = 0, ri = 0;
        int res = -1;
        while (ri < nums.length) {
            // 扩增子数组右边
            curSum += nums[ri++];
            // 当子数组和超过目标值，则缩小子数组左边
            while (le < ri && curSum > sum) {
                curSum -= nums[le++];
            }

            // 如果和相等，则是一个可选值
            if (curSum == sum) {
                res = Math.max(res, ri - le);
            }
        }

        return res == -1 ? -1 : nums.length - res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
