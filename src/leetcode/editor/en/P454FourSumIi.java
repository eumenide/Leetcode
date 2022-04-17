//Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, 
//return the number of tuples (i, j, k, l) such that: 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//Output: 2
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
// Related Topics Array Hash Table 👍 3758 👎 112


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 4Sum II
 * 
 * @author: eumes
 * @date: 2022-04-18 01:47:15
 */
 public class P454FourSumIi {
    public static void main(String[] args) {
//        Solution_P454 solution = new Solution_P454();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                freq.put(n1 + n2, freq.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        int count = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                count += freq.getOrDefault(-n3 - n4, 0);
            }
        }

        return count;
    }

    public int fourSumCount_map(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> freq = new HashMap<>();

        // 统计1,2和频率
        Arrays.stream(nums1).forEach(n1 ->
                Arrays.stream(nums2).forEach(n2 ->
                        freq.compute(n1 + n2, (k, v) -> v == null ? 1 : ++v)));

        // 计算3,4数组符合条件的
        return Arrays.stream(nums3).map(n3 ->
                Arrays.stream(nums4).map(n4 -> freq.getOrDefault(-n3 - n4, 0)).sum())
                .sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
