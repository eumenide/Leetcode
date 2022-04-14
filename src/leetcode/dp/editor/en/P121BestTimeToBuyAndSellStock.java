//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you 
//cannot achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you 
//must buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics Array Dynamic Programming 👍 14606 👎 491


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:28
 * @title: Best Time to Buy and Sell Stock
 */
public class P121BestTimeToBuyAndSellStock {
    
    public static void main(String[] args) {
        Solution_121 solution = new Solution_121();
        // TO TEST
        int[] arr1 = new int[] {7, 1, 5, 3, 6, 4};
        int[] arr2 = new int[] {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit_Bruce(arr1));
        System.out.println(solution.maxProfit_OnePass(arr1));
        System.out.println(solution.maxProfit(arr1));
        System.out.println(solution.maxProfit_Bruce(arr2));
        System.out.println(solution.maxProfit_OnePass(arr2));
        System.out.println(solution.maxProfit(arr2));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_121 {
    public int maxProfit(int[] prices) {

        return 0;
    }

    /**
     * 记录低谷 & 最大利润；一遍 遍历，边更新低谷&最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit_OnePass(int[] prices) {
        int valley = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Integer.max(maxProfit, prices[i] - valley);
            valley = Integer.min(valley, prices[i]);
        }

        return maxProfit;
    }

    /**
     * 暴力，会超时
     *
     * @param prices
     * @return
     */
    public int maxProfit_Bruce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
