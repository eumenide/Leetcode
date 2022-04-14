//Given an array of integers nums containing n + 1 integers where each integer 
//is in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only 
//constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,4,2,2]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,2]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer 
//which appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
// Related Topics Array Two Pointers Binary Search Bit Manipulation 👍 12840 👎 
//1451


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-29 23:51:17
 * @title: Find the Duplicate Number
 */
public class P287FindTheDuplicateNumber {
    
    public static void main(String[] args) {
        Solution_287 solution = new Solution_287();
        // TO TEST
        int[] nums = new int[] {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums));

        nums = new int[] {3, 1, 3, 4, 2};
        System.out.println(solution.findDuplicate(nums));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_287 {
    public int findDuplicate(int[] nums) {
        boolean[] existed = new boolean[nums.length];

        for (int num : nums) {
            if (existed[num]) {
                return num;
            }
            existed[num] = true;
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
