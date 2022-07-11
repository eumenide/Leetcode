//Given an integer array nums of size n, return the minimum number of moves 
//required to make all array elements equal. 
//
// In one move, you can increment or decrement an element of the array by 1. 
//
// Test cases are designed so that the answer will fit in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: 2
//Explanation:
//Only two moves are needed (remember each move increments or decrements one 
//element):
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,10,2,9]
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Math Sorting 👍 2352 👎 95


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 * 
 * @author: eumes
 * @date: 2022-06-30 23:37:16
 */
 public class P462MinimumMovesToEqualArrayElementsIi {
    public static void main(String[] args) {
//        Solution_P462 solution = new Solution_P462();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P462 {
    public int minMoves2(int[] nums) {
        // 中位数定理
        Arrays.sort(nums);
        int le = 0, ri = nums.length - 1;
        int sum = 0;
        while (le < ri) {
            sum += nums[ri--] - nums[le++];
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
