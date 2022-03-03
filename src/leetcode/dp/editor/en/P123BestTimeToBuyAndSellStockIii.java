//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you 
//are engaging multiple transactions at the same time. You must sell before buying 
//again.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
// Related Topics Array Dynamic Programming 👍 5407 👎 114


package leetcode.dp.editor.en;

import java.util.Arrays;

/**
 * @author: eumes
 * @date: 2022-03-03 23:03:34
 * @title: Best Time to Buy and Sell Stock III
 */
public class P123BestTimeToBuyAndSellStockIii {
    
    public static void main(String[] args) {
        Solution_123 solution = new Solution_123();
        // TO TEST
        int[] p1 = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
        int[] p2 = new int[] {1, 2, 3, 4, 5};
        int[] p3 = new int[] {7, 6, 4, 3, 1};

        System.out.println(solution.maxProfit5(p1));
        System.out.println(solution.maxProfit5(p2));
        System.out.println(solution.maxProfit5(p3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_123 {
    /**
     * dp[k, i]表示第i天进行第k次交易时的最大利润，则推导公式为：
     * dp[k, i] = max(dp[k, i-1], max(p[i] - p[j] + dp[k-1, j-1]))
     *      =  max(dp[k, i-1], p[i] - min(p[j] - dp[k-1, j-1]))
     * 1. = 第i-1天进行第k次交易时的最大利润；即第i天不进行交易
     * 2. = 第j-1天进行第k-1次交易时的最大利润 + 第j天买入 第i天卖出的利润；即第i天进行卖出交易
     *      这里的j从1取到i-1，取上述最大值
     *
     * 时间 k * n^2
     * 空间 k * n
     *
     * @param prices
     * @return 超时
     */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k < 3; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j < i; j++) {
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                }
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }

    /**
     * 版本1中的最内层循环，除了j<i的限制外，没有其他与i相关的限制；存在很多重复计算
     * 因此，可将其与i层循环合并。
     *
     * 时间：k * n
     * 空间：k * n
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k < 3; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }

    /**
     * 版本2中循环里的min，实质上记录的是每次k循环时的最小值；
     * 调换k和i循环，利用数组记录3个k循环的最小值。
     *
     * 减少了min值的计算次数
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int[][] dp = new int[3][prices.length];
        int[] minK = new int[3];
        Arrays.fill(minK, prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                minK[k] = Math.min(minK[k], prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - minK[k]);
            }
        }

        return dp[2][prices.length - 1];
    }

    /**
     * 版本3中循环内，i只依赖于i-1，因此可以去掉？？？
     *
     * 时间：k * n
     * 空间：k
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int[] dp = new int[3];
        int[] minK = new int[3];
        Arrays.fill(minK, prices[0]);

        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k < 3; k++) {
                minK[k] = Math.min(minK[k], prices[i] - dp[k - 1]);
                dp[k] = Math.max(dp[k], prices[i] - minK[k]);
            }
        }

        return dp[2];
    }

    /**
     * k只有2次循环，用变量代替循环
     *
     * @param prices
     * @return
     */
    public int maxProfit5(int[] prices) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;

        for (int price : prices) {
            // 第1次，没有已有利润
            first = Math.min(first, price);
            profit1 = Math.max(profit1, price - first);
            // 第2次
            second = Math.min(second, price - profit1);
            profit2 = Math.max(profit2, price - second);
        }

        return profit2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
