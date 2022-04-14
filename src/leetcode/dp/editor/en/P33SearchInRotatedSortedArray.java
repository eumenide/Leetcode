//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Binary Search 👍 13402 👎 868


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-28 23:29:14
 * @title: Search in Rotated Sorted Array
 */
public class P33SearchInRotatedSortedArray {
    
    public static void main(String[] args) {
        Solution_33 solution = new Solution_33();
        // TO TEST
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 0));

        nums = new int[] {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 3));

        nums = new int[] {1};
        System.out.println(solution.search(nums, 0));
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 找到了，直接返回
            if (target == nums[mid]) {
                return mid;
            }

            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                // 说明mid和target在同一侧
                if (nums[mid] < target) {
                    // 此时，应往右找
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[0] < target) {
                // 说明mid和target不在同一侧
                // target在左侧，mid在右侧
                right = mid - 1;
            } else {
                // target在右侧，mid在左侧
                left = mid + 1;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
