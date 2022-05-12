//Given an array nums which consists of non-negative integers and an integer m, 
//you can split the array into m non-empty continuous subarrays. 
//
// Write an algorithm to minimize the largest sum among these m subarrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], m = 2
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,4,4], m = 3
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics Array Binary Search Dynamic Programming Greedy 👍 5849 👎 150


package leetcode.editor.en;

/**
 * Split Array Largest Sum
 * 
 * @author: eumes
 * @date: 2022-05-11 01:37:50
 */
 public class P410SplitArrayLargestSum {
    public static void main(String[] args) {
//        Solution_P410 solution = new Solution_P410();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P410 {
    // 二分查找，YYDS
    public int splitArray(int[] nums, int m) {
        int le = 0, ri = 1;
        for (int i = 0; i < nums.length; i++) {
            le = Math.max(le, nums[i]);
            ri += nums[i];
        }

        while (le < ri) {
            int sum = le + ((ri - le) >> 1);
            int curM = findM(nums, sum);
            if (curM > m) {
                // 划分的比期望的多，说明sum值取小了
                le = sum + 1;
            } else {
                ri = sum;
            }
        }

        return le;
    }

    private int findM(int[] nums, int sum) {
        int res = 0, m = 1;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            if (res > sum) {
                res = nums[i];
                m++;
            }
        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
