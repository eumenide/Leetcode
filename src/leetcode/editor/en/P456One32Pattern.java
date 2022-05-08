//Given an array of n integers nums, a 132 pattern is a subsequence of three 
//integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < 
//nums[j]. 
//
// Return true if there is a 132 pattern in nums, otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4]
//Output: false
//Explanation: There is no 132 pattern in the sequence.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,4,2]
//Output: true
//Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,3,2,0]
//Output: true
//Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
// 0] and [-1, 2, 0].
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Binary Search Stack Monotonic Stack Ordered Set 👍 4164 
//👎 221


package leetcode.editor.en;

import java.util.Stack;

/**
 * 132 Pattern
 * 
 * @author: eumes
 * @date: 2022-05-08 00:19:07
 */
 public class P456One32Pattern {
    public static void main(String[] args) {
//        Solution_P456 solution = new Solution_P456();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P456 {
    public boolean find132pattern(int[] nums) {
        // 记录p2
        int p2 = Integer.MIN_VALUE;
        // 记录p3
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < p2) {
                // 满足pattern
                return true;
            }

            // 更新p2/p3
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                p2 = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
