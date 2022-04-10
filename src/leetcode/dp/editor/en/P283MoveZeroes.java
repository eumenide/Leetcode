//Given an integer array nums, move all 0's to the end of it while maintaining 
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related 
//Topics Array Two Pointers 👍 8752 👎 236


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-09 02:15:48
 * @title: Move Zeroes
 */
public class P283MoveZeroes {
    
    public static void main(String[] args) {
        Solution_283 solution = new Solution_283();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_283 {
    public void moveZeroes(int[] nums) {
        int zeroSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroSize++;
            } else if (zeroSize > 0) {
                nums[i - zeroSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public void moveZeroes_2(int[] nums) {
        int left = 0, right = 0;
        if (nums.length == 1) return;
        while (right < nums.length) {
            // 找到不为0的
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            // 交换
            if (right < nums.length) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right++] = tmp;
            }
        }
    }

    public void moveZeroes_1(int[] nums) {
        int lIdx = 0;
        for (int rIdx = 0; rIdx < nums.length; rIdx++) {
            if (nums[rIdx] != 0) {
                int tmp = nums[lIdx];
                nums[lIdx++] = nums[rIdx];
                nums[rIdx] = tmp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
