//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like (i.e., buy one and sell one share of the stock multiple times) 
//with the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., 
//cooldown one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 👍 5376 👎 184


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-07 21:49:38
 * @title: Best Time to Buy and Sell Stock with Cooldown
 */
public class P309BestTimeToBuyAndSellStockWithCooldown {
    
    public static void main(String[] args) {
        Solution_309 solution = new Solution_309();
        // TO TEST
        int[] p1 = new int[] {1,2,3,0,2};
        int[] p2 = new int[] {1};
        int[] p3 = new int[] {7, 6, 4, 3, 1};

        System.out.println(solution.maxProfit(p1));
        System.out.println(solution.maxProfit(p2));
        //System.out.println(solution.maxProfit(p3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // buy[i]表示截止第i天，上个动作是buy的最大利润
        int[] buy = new int[len];
        // sell[i]表示截止第i天，上个动作是sell的最大利润
        int[] sell = new int[len];

        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);

        for (int i = 2; i < len; i++) {
            // 要么保持buy[i-1]（截止昨天，上个动作是buy的利润）
            // 要么今天买入，但需保证昨天是cooldown，截止前天，最后一个动作是卖出
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            // 要么保持sell[i-1]（截止昨天，上个动作是sell的利润）
            // 要么今天卖出，但需保证截止昨天，最后一个动作是买入
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        // 返回截止最后一天，最后一个动作是卖出的利润
        return sell[len - 1];
    }

    // 压缩维度
    public int maxProfit_c(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int buy1 = -prices[0];
        int buy0 = buy1;
        int sell0 = 0;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = 2; i < len; i++) {
            // 要么保持buy[i-1]（截止昨天，上个动作是buy的利润）
            // 要么今天买入，但需保证昨天是cooldown，截止前天，最后一个动作是卖出
            buy1 = Math.max(buy0, sell2 - prices[i]);
            // 要么保持sell[i-1]（截止昨天，上个动作是sell的利润）
            // 要么今天卖出，但需保证截止昨天，最后一个动作是买入
            sell0 = Math.max(sell1, buy0 + prices[i]);

            buy0 = buy1;
            sell2 = sell1;
            sell1 = sell0;
        }

        // 返回截止最后一天，最后一个动作是卖出的利润
        return sell0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
