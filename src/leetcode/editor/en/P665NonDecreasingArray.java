//Given an array nums with n integers, your task is to check if it could become 
//non-decreasing by modifying at most one element. 
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for 
//every i (0-based) such that (0 <= i <= n - 2). 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,2,1]
//Output: false
//Explanation: You can't get a non-decreasing array by modify at most one 
//element.
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array 👍 4223 👎 684


package leetcode.editor.en;

/**
 * Non-decreasing Array
 * 
 * @author: eumes
 * @date: 2022-06-25 17:03:06
 */
 public class P665NonDecreasingArray {
    public static void main(String[] args) {
//        Solution_P665 solution = new Solution_P665();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P665 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        // 比较当前与-1值
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            // 当前值 < -1值，则需要改变一个元素，两种改法：1. 改变-1与-2相同，2. 改变当前值与-1相同
            if (nums[i] < nums[i - 1]) {
                cnt++;
                // 当前值 < -2值，则需要改变当前与-1相同
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
                // 至于改变-1与-2相同，可以不用管；因为当cnt>1时，会返回false
            }
        }
        return cnt <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
