//You are given an array of binary strings strs and two integers m and n. 
//
// Return the size of the largest subset of strs such that there are at most m 0
//'s and n 1's in the subset. 
//
// A set x is a subset of a set y if all elements of x are also elements of y. 
//
// 
// Example 1: 
//
// 
//Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//Output: 4
//Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
// "1", "0"}, so the answer is 4.
//Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
//{"111001"} is an invalid subset because it contains 4 1's, greater than the 
//maximum of 3.
// 
//
// Example 2: 
//
// 
//Input: strs = ["10","0","1"], m = 1, n = 1
//Output: 2
//Explanation: The largest subset is {"0", "1"}, so the answer is 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] consists only of digits '0' and '1'. 
// 1 <= m, n <= 100 
// 
// Related Topics Array String Dynamic Programming 👍 3606 👎 366


package leetcode.editor.en;

/**
 * Ones and Zeroes
 * 
 * @author: eumes
 * @date: 2022-05-24 00:27:11
 */
 public class P474OnesAndZeroes {
    public static void main(String[] args) {
//        Solution_P474 solution = new Solution_P474();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]表示最多i个0、j个1时，符合的最大子集数
        int[][] dp = new int[m + 1][n + 1];
        // 每个元素都尝试加入
        for (String str : strs) {
            // 计算0和1的数量
            int zeros = 0, ones = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 倒序更新dp，保证str只会被计算一次
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
