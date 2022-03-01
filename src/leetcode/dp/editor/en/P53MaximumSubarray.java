//Given an integer array nums, find the contiguous subarray (containing at 
//least one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 👍 18193 👎 864


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-02-07 11:38:08
 * @title: Maximum Subarray
 */
public class P53MaximumSubarray {
    
    public static void main(String[] args) {
        Solution_53 solution = new Solution_53();
        // TO TEST
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));

        nums = new int[] {1};
        System.out.println(solution.maxSubArray(nums));

        nums = new int[] {5, 4, -1, 7, 8};
        System.out.println(solution.maxSubArray(nums));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_53 {

    /**
     * 累加，KADANE解法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 当前者 > 0 时，才累加上；否则会越加越小
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            result = Math.max(result, nums[i]);
        }

        return result;
    }

    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public int maxSubArray_f1(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, tmp = 0; j < nums.length; j++) {
                tmp += nums[j];
                result = Math.max(result, tmp);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
