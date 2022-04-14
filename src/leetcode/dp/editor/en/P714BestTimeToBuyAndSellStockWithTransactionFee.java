//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day, and an integer fee representing a transaction fee. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like, but you need to pay the transaction fee for each transaction. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
// Related Topics Array Dynamic Programming Greedy 👍 3695 👎 98


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-13 18:09:47
 * @title: Best Time to Buy and Sell Stock with Transaction Fee
 */
public class P714BestTimeToBuyAndSellStockWithTransactionFee {
    
    public static void main(String[] args) {
        Solution_714 solution = new Solution_714();
        // TO TEST
        int[] p1 = new int[] {1, 3, 2, 8, 4, 9};
        int[] p2 = new int[] {1, 3, 7, 5, 10, 3};
        int[] p3 = new int[] {7, 6, 4, 3, 1};

        System.out.println(solution.maxProfit(p1, 2));
        System.out.println(solution.maxProfit(p2, 3));
        //System.out.println(solution.maxProfit(p3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) {
            return 0;
        }

        // buy表示上一个动作是买入时的最大利润
        int buy = -prices[0];
        // sell表示上一动作是卖出时的最大利润
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            // 要么今天买入（上一动作是卖出）
            // 要么保持上一买入动作
            buy = Math.max(buy, sell - prices[i]);

            // 要么今天卖出（上一动作是买入）
            // 要么保持上一卖出动作
            sell = Math.max(sell, buy + prices[i] - fee);

            // 更新动态记录值
            //buy = buy1;
            //sell = sell1;
        }

        return sell;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
