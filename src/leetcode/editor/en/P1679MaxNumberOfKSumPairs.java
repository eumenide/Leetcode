//You are given an integer array nums and an integer k. 
//
// In one operation, you can pick two numbers from the array whose sum equals k 
//and remove them from the array. 
//
// Return the maximum number of operations you can perform on the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4], k = 5
//Output: 2
//Explanation: Starting with nums = [1,2,3,4]:
//- Remove numbers 1 and 4, then nums = [2,3]
//- Remove numbers 2 and 3, then nums = []
//There are no more pairs that sum up to 5, hence a total of 2 operations. 
//
// Example 2: 
//
// 
//Input: nums = [3,1,3,4,3], k = 6
//Output: 1
//Explanation: Starting with nums = [3,1,3,4,3]:
//- Remove the first two 3's, then nums = [1,4,3]
//There are no more pairs that sum up to 6, hence a total of 1 operation. 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
// Related Topics Array Hash Table Two Pointers Sorting 👍 1464 👎 34


package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Max Number of K-Sum Pairs
 * 
 * @author: eumes
 * @date: 2022-05-04 23:39:03
 */
 public class P1679MaxNumberOfKSumPairs {
    public static void main(String[] args) {
//        Solution_P1679 solution = new Solution_P1679();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1679 {
     // [2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2]
    public int maxOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(k - nums[i])) {
                count++;
                set.remove(k - nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
