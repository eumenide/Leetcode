//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting 
//some or no elements without changing the order of the remaining elements. For 
//example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
// Related Topics Array Binary Search Dynamic Programming 👍 11975 👎 235


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 * 
 * @author: eumes
 * @date: 2022-05-26 00:10:56
 */
 public class P300LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        Solution_P300 solution = new Solution_P300();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P300 {
     // https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
    // 加个例子就比较容易明白，比如序列是78912345，前三个遍历完以后tail是789，这时候遍历到1，就得把1放到合适的位置，于是在tail二分查找1的位置，变成了189（如果序列在此时结束，因为res不变，所以依旧输出3），再遍历到2成为129，然后是123直到12345
    public int lengthOfLIS_binary(int[] nums) {
        // dp[i]表示长度为i+1时的最小结尾数
        // 以纸牌为例，就是分堆，保证堆顶元素递增；堆内元素递减，当前元素比所有堆顶元素都大时，新增一个堆；最终堆的数量就是最大递增子序列的长度
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;

        for (int num : nums) {
            int le = 0, ri = res;
            while (le < ri) {
                int mid = le + ((ri - le) >> 1);
                if (dp[mid] > num) {
                    le = mid + 1;
                } else {
                    ri = mid;
                }
            }

            // 如果num最大，则扩展递增序列长度
            if (le == res) {
                res++;
            }
            dp[le] = num;
        }

        return res;
    }

    public int lengthOfLIS_dp(int[] nums) {
        // dp[i]表示以nums[i]结尾的最大长度
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 循环，更新dp
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxL = 0;
        for (int len : dp) {
            maxL = Math.max(maxL, len);
        }
        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
