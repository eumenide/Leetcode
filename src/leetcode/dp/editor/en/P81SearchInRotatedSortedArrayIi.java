//There is an integer array nums sorted in non-decreasing order (not 
//necessarily with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot 
//index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true 
//if target is in nums, or false if it is not in nums. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is guaranteed to be rotated at some pivot. 
// -10⁴ <= target <= 10⁴ 
// 
//
// 
// Follow up: This problem is similar to Search in Rotated Sorted Array, but 
//nums may contain duplicates. Would this affect the runtime complexity? How and why?
// 
// Related Topics Array Binary Search 👍 4050 👎 695


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-28 23:29:11
 * @title: Search in Rotated Sorted Array II
 */
public class P81SearchInRotatedSortedArrayIi {
    
    public static void main(String[] args) {
        Solution_81 solution = new Solution_81();
        // TO TEST
        int[] nums = new int[] {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search(nums, target));

        nums = new int[] {2, 5, 6, 0, 0, 1, 2};
        target = 3;
        System.out.println(solution.search(nums, target));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_81 {

    /**
     * 二分查找 平均O(logn)，最坏情况O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 若mid的左侧有序，则nums[left] < nums[mid]
            if (nums[left] < nums[mid]) {
                if (nums[left] == target) {
                    return true;
                }
                // 如果nums[left] < target < nums[mid]，则表明target在左侧
                else if (nums[left] < target && target < nums[mid]) {
                    // 下一步查找左侧
                    right = mid - 1;
                } else {
                    // 否则target在右侧，下一步查找右侧
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (target == nums[right]) {
                    return true;
                }
                // 若mid的右侧有序，则nums[left] > nums[mid]，相当于num[mid]及其右侧为nums[left]原来的左侧置换过去的
                // 如果nums[mid] < target < nums[right]，则表明target在右侧
                else if (nums[mid] < target && target < nums[right]) {
                    // 下一步查找→侧
                    left = mid + 1;
                } else {
                    // 否则target在←侧，
                    right = mid - 1;
                }
            } else {
                // nums[left] == nums[mid]，往后挪一位
                left++;
            }
        }

        return false;
    }

    /**
     * 暴力 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search_bruce(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
