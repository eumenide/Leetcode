//Given a non-empty array nums containing only positive integers, find if the 
//array can be partitioned into two subsets such that the sum of elements in both 
//subsets is equal. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Array Dynamic Programming 👍 7894 👎 126


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Partition Equal Subset Sum
 * 
 * @author: eumes
 * @date: 2022-07-01 23:05:59
 */
 public class P416PartitionEqualSubsetSum {
    public static void main(String[] args) {
//        Solution_P416 solution = new Solution_P416();
        // TO TEST1000000000
        //1000000000
        //[2]
        //[2]
        long m = 1000000000 - 2;
        long n = 1000000000 - 2;
        int re = (int) ((long) (m * n) % (1e9 + 7));
        System.out.println(m * n);
        System.out.println(m * n % (1e9 + 7));
        System.out.println(1e9 + 7);
        System.out.println(m * n % (1000000007));
        System.out.println(re);
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P416 {
    // 转换成dp，能否选择一些数字，使得和为 sum / 2
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            // 奇数，直接返回false
            return false;
        }

        sum >>= 1;
        // 利用一维dp，表示能否满足sum为i
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            // dp记录的实际上是上一次处理的结果，j从后往前是为了保证前面取到的结果是上一次的，而不会被本次覆盖
            for (int j = sum; j > 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }

        return dp[sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
