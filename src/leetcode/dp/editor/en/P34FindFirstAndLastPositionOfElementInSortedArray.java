//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Binary Search 👍 10041 👎 284


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-08 01:25:14
 * @title: Find First and Last Position of Element in Sorted Array
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    
    public static void main(String[] args) {
//        Solution_34 solution = new Solution_34();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_34 {
    public int[] searchRange_1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 这里最差情况会有 O(n)
                int lb = mid, rb = mid;
                while (lb > left && nums[lb - 1] == target) {
                    lb--;
                }
                while (rb < right && nums[rb + 1] == target) {
                    rb++;
                }
            }
        }

        return new int[] {-1, -1};
    }

    // 左右边界，平均 2logn
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    private int rightBound(int[] nums, int target) {
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            int mid = le + ((ri - le) >> 1);
            if (nums[mid] > target) {
                ri = mid - 1;
            } else {
                le = mid + 1;
            }
        }

        // 越界
        if (ri < 0 || nums[ri] != target) {
            return -1;
        }
        return ri;
    }

    private int leftBound(int[] nums, int target) {
        int le = 0, ri = nums.length - 1;
        while (le <= ri) {
            int mid = le + ((ri - le) >> 1);
            if (nums[mid] < target) {
                le = mid + 1;
            } else if (nums[mid] >= target) {
                ri = mid - 1;
            }
        }

        // 越界
        if (le >= nums.length || nums[le] != target) {
            return -1;
        }
        return le;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
