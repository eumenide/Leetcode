//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day. 
//
// On each day, you may decide to buy and/or sell the stock. You can only hold 
//at most one share of the stock at any time. However, you can buy it then 
//immediately sell it on the same day. 
//
// Find and return the maximum profit you can achieve. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 
//5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//
//Total profit is 4 + 3 = 7.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Total profit is 4.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the 
//stock to achieve the maximum profit of 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics Array Dynamic Programming Greedy 👍 6938 👎 2326


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-03 22:41:26
 * @title: Best Time to Buy and Sell Stock II
 */
public class P122BestTimeToBuyAndSellStockIi {
    
    public static void main(String[] args) {
        Solution_122 solution = new Solution_122();
        // TO TEST
        int[] p1 = new int[] {7, 1, 5, 3, 6, 4};
        int[] p2 = new int[] {1, 2, 3, 4, 5};
        int[] p3 = new int[] {7, 6, 4, 3, 1};

        System.out.println(solution.maxProfit(p1));
        System.out.println(solution.maxProfit(p2));
        System.out.println(solution.maxProfit(p3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_122 {
    /**
     * 寻找每个低谷与随后的高峰，求和即可
     * (P[n] - P[n-1]) + (P[n-1] - P[n-2]) = P[n] - P[n-2]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 卖掉当前，买入新的
            if (prices[i] < max) {
                ans += max - min;
                min = prices[i];
            }
            max = prices[i];
        }
        ans += max - min;

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
