//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the number of combinations that make up that amount. If that amount 
//of money cannot be made up by any combination of the coins, return 0. 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// The answer is guaranteed to fit into a signed 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// Example 2: 
//
// 
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
// 
//
// Example 3: 
//
// 
//Input: amount = 10, coins = [10]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// All the values of coins are unique. 
// 0 <= amount <= 5000 
// 
// Related Topics Array Dynamic Programming 👍 5477 👎 107


package leetcode.editor.en;

/**
 * Coin Change 2
 * 
 * @author: eumes
 * @date: 2022-07-03 20:02:21
 */
 public class P518CoinChange2 {
    public static void main(String[] args) {
//        Solution_P518 solution = new Solution_P518();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P518 {

    public int change(int amount, int[] coins) {
        // 空间压缩
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // dp[j]只与上一次的j和本次的j-coins[i-1]有关
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }

        return dp[amount];
    }

    public int change_2d(int amount, int[] coins) {
        // dp[i+1][j+1]表示使用前i种硬币，得到金额j的总共装法数量
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // base case，第一列 金额为0 --> 装法为1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // dp更新
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
