//You are given an array of positive integers nums and want to erase a subarray 
//containing unique elements. The score you get by erasing the subarray is equal 
//to the sum of its elements. 
//
// Return the maximum score you can get by erasing exactly one subarray. 
//
// An array b is called to be a subarray of a if it forms a contiguous 
//subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r). 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,4,5,6]
//Output: 17
//Explanation: The optimal subarray here is [2,4,5,6].
// 
//
// Example 2: 
//
// 
//Input: nums = [5,2,1,2,5,2,1,2,5]
//Output: 8
//Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics Array Hash Table Sliding Window 👍 1808 👎 31


package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Maximum Erasure Value
 * 
 * @author: eumes
 * @date: 2022-06-12 23:24:42
 */
 public class P1695MaximumErasureValue {
    public static void main(String[] args) {
//        Solution_P1695 solution = new Solution_P1695();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1695 {

    public int maximumUniqueSubarray(int[] nums) {
        // set保存出现过且在子数组中的值
        Set<Integer> set = new HashSet<>();
        int le = 0, ri = 0;
        int res = 0, sum = 0;
        while (le <= ri && ri < nums.length) {
            while (!set.add(nums[ri])) {
                // 若已存在，则缩减左边
                sum -= nums[le];
                set.remove(nums[le++]);
            }
            // 满足条件的子数组，更新相关内容
            sum += nums[ri++];
            res = Math.max(res, sum);
        }

        return res;
    }

    public int maximumUniqueSubarray_preSum(int[] nums) {
        // hashmap存储值-最后位置
        HashMap<Integer, Integer> map = new HashMap<>();
        // 前缀和
        int[] preSum = new int[nums.length + 1];
        int le = 0, ri = 0;
        int res = 0;
        while (ri < nums.length) {
            preSum[ri + 1] = preSum[ri] + nums[ri];
            if (map.containsKey(nums[ri])) {
                // 若重复，则直接挪动le到上一个ri + 1
                le = Math.max(le, map.get(nums[ri]) + 1);
            }
            // 更新map和res
            map.put(nums[ri], ri);
            res = Math.max(res, preSum[++ri] - preSum[le]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
