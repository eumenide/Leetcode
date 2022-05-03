//Given an integer array nums, move all the even integers at the beginning of 
//the array followed by all the odd integers. 
//
// Return any array that satisfies this condition. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,2,4]
//Output: [2,4,3,1]
//Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be 
//accepted.
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics Array Two Pointers Sorting 👍 3039 👎 116


package leetcode.editor.en;

/**
 * Sort Array By Parity
 * 
 * @author: eumes
 * @date: 2022-05-02 16:28:40
 */
 public class P905SortArrayByParity {
    public static void main(String[] args) {
//        Solution_P905 solution = new Solution_P905();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P905 {
    public int[] sortArrayByParity(int[] nums) {
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            // 找左侧奇数
            while (le <= ri && ((nums[le] & 1) == 0)) {
                le++;
            }
            // 找右侧偶数
            while (le <= ri && ((nums[ri] & 1) == 1)) {
                ri--;
            }

            if (le < ri) {
                nums[le] ^= nums[ri];
                nums[ri] ^= nums[le];
                nums[le] ^= nums[ri];
            }
        }

        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
