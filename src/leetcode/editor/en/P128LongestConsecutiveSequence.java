//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Union Find 👍 11374 👎 489


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * 
 * @author: eumes
 * @date: 2022-07-05 23:09:02
 */
 public class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
//        Solution_P128 solution = new Solution_P128();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P128 {

     // 利用set，理论上O(n)，但实际更慢
     public int longestConsecutive(int[] nums) {
         if (nums.length <= 1) {
             return nums.length;
         }

         // 去重
         Set<Integer> set = new HashSet<>();
         for (int num : nums) {
             set.add(num);
         }

         int res = 1;
         // 对于每个数字，分别向左向右查找相邻数字，直到找不到
         for (int num : nums) {
             int le = num - 1, ri = num;
             // 删除左边成功，表示存在
             while (set.remove(le)) {
                 le--;
             }
             // 删除右边成功，表示存在
             while (set.remove(ri)) {
                 ri++;
             }

             res = Math.max(res, ri - le - 1);
             if (set.size() <= res) {
                 break;
             }
         }

         return res;
     }

    // 先排序，再查找，理论nlogn，但实际与O(n)快
    public int longestConsecutive_sort(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);

        int res = 1, pre = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == pre + 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
            pre = nums[i];
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
