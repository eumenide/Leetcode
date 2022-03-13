//You are given an integer array nums. You are initially positioned at the 
//array's first index, and each element in the array represents your maximum jump 
//length at that position. 
//
// Return true if you can reach the last index, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum 
//jump length is 0, which makes it impossible to reach the last index.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics Array Dynamic Programming Greedy 👍 10182 👎 589


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-13 20:30:18
 * @title: Jump Game
 */
public class P55JumpGame {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = new int[] {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums));
        nums = new int[] {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int leftedStep = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (leftedStep <= 0) {
                return false;
            }
            leftedStep = Math.max(leftedStep - 1, nums[i]);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
