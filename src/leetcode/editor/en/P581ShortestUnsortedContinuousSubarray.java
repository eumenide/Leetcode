//Given an integer array nums, you need to find one continuous subarray that if 
//you only sort this subarray in ascending order, then the whole array will be 
//sorted in ascending order. 
//
// Return the shortest such subarray and output its length. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the 
//whole array sorted in ascending order.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: nums = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//Follow up: Can you solve it in O(n) time complexity? Related Topics Array Two 
//Pointers Stack Greedy Sorting Monotonic Stack 👍 5881 👎 217


package leetcode.editor.en;

/**
 * Shortest Unsorted Continuous Subarray
 * 
 * @author: eumes
 * @date: 2022-05-03 22:17:49
 */
 public class P581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
//        Solution_P581 solution = new Solution_P581();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P581 {
    public int findUnsortedSubarray(int[] nums) {
        int le = 0, ri = nums.length - 1;
        // 找到左边第一个破坏递增规则的位置
        while (le < ri && nums[le] <= nums[le + 1]) {
            le++;
        }
        if (le == ri) {
            return 0;
        }
        // 找到右边第一个破坏递增规则的位置
        while (le < ri && nums[ri] >= nums[ri - 1]) {
            ri--;
        }

        // 找到le~ri中的最大最小值
        int minV = Math.min(nums[le], nums[ri]);
        int maxV = Math.max(nums[le], nums[ri]);
        for (int i = le + 1; i < ri; i++) {
            minV = Math.min(minV, nums[i]);
            maxV = Math.max(maxV, nums[i]);
        }

        // 往左右找到真正破坏递增规则的位置
        while (le > 0 && nums[le - 1] > minV) {
            le--;
        }
        while (ri < nums.length - 1 && nums[ri + 1] < maxV) {
            ri++;
        }

        return ri - le + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
