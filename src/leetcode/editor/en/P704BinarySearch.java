//Given an array of integers nums which is sorted in ascending order, and an 
//integer target, write a function to search target in nums. If target exists, then 
//return its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ < nums[i], target < 10⁴ 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 👍 4750 👎 111


package leetcode.editor.en;

/**
 * Binary Search
 * 
 * @author: eumes
 * @date: 2022-05-09 01:20:26
 */
 public class P704BinarySearch {
    public static void main(String[] args) {
//        Solution_P704 solution = new Solution_P704();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P704 {
    public int search(int[] nums, int target) {
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            int mid = le + ((ri - le) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                le = mid + 1;
            } else {
                ri = mid - 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
