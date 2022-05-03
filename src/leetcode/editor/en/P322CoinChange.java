//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If 
//that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics Array Dynamic Programming Breadth-First Search 👍 10991 👎 266
//


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Coin Change
 * 
 * @author: eumes
 * @date: 2022-05-04 01:09:58
 */
 public class P322CoinChange {
    public static void main(String[] args) {
//        Solution_P322 solution = new Solution_P322();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示amount为i时所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 遍历每个目标值
        for (int i = 1; i <= amount; i++) {
            // 遍历每种硬币选择
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - amount < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
