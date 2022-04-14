//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day, and an integer k. 
//
// Find the maximum profit you can achieve. You may complete at most k 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 👍 3616 👎 150


package leetcode.dp.editor.en;

import java.util.Arrays;

/**
 * @author: eumes
 * @date: 2022-03-07 21:31:14
 * @title: Best Time to Buy and Sell Stock IV
 */
public class P188BestTimeToBuyAndSellStockIv {
    
    public static void main(String[] args) {
        Solution_188 solution = new Solution_188();
        // TO TEST
        int[] p1 = new int[] {2, 4, 1};
        int[] p2 = new int[] {3, 2, 6, 5, 0, 3};

        System.out.println(solution.maxProfit(3, p1));
        System.out.println(solution.maxProfit(2, p2));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }

        int[] dp = new int[k + 1];
        int[] minK = new int[k + 1];
        Arrays.fill(minK, prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // whether to buy at prices[i]
                minK[j] = Math.min(minK[j], prices[i] - dp[j - 1]);
                // whether to sell at prices[i]
                dp[j] = Math.max(dp[j], prices[i] - minK[j]);
            }
        }

        return dp[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
