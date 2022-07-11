//There is a row of m houses in a small city, each house must be painted with 
//one of the n colors (labeled from 1 to n), some houses that have been painted 
//last summer should not be painted again. 
//
// A neighborhood is a maximal group of continuous houses that are painted with 
//the same color. 
//
// 
// For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2},
// {3,3}, {2}, {1,1}]. 
// 
//
// Given an array houses, an m x n matrix cost and an integer target where: 
//
// 
// houses[i]: is the color of the house i, and 0 if the house is not painted 
//yet. 
// cost[i][j]: is the cost of paint the house i with the color j + 1. 
// 
//
// Return the minimum cost of painting all the remaining houses in such a way 
//that there are exactly target neighborhoods. If it is not possible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
//, n = 2, target = 3
//Output: 9
//Explanation: Paint houses of this way [1,2,2,1,1]
//This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
//Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.
// 
//
// Example 2: 
//
// 
//Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5
//, n = 2, target = 3
//Output: 11
//Explanation: Some houses are already painted, Paint the houses of this way [2,
//2,1,2,2]
//This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}]. 
//Cost of paint the first and last house (10 + 1) = 11.
// 
//
// Example 3: 
//
// 
//Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n 
//= 3, target = 3
//Output: -1
//Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{
//1},{2},{3}] different of target = 3.
// 
//
// 
// Constraints: 
//
// 
// m == houses.length == cost.length 
// n == cost[i].length 
// 1 <= m <= 100 
// 1 <= n <= 20 
// 1 <= target <= m 
// 0 <= houses[i] <= n 
// 1 <= cost[i][j] <= 10⁴ 
// 
// Related Topics Array Dynamic Programming 👍 1707 👎 126


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Paint House III
 * 
 * @author: eumes
 * @date: 2022-07-09 22:17:31
 */
 public class P1473PaintHouseIii {
    public static void main(String[] args) {
//        Solution_P1473 solution = new Solution_P1473();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1473 {
    public static final int MAX_COST = 100000001;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]表示前i个house，最后一个house着色为j+1，邻居为k-1时的最小cost
        int[][][] dp = new int[m][n][target + 1];
        // base case
        // 1. 设置最大值，表示-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], MAX_COST);
            }
        }
        // 2. 前0个房子、划分为1时，可初始化
        for (int j = 0; j < n; j++) {
            if (houses[0] == j + 1) {
                // 此时房子不能着色，且已满足，cost为0
                dp[0][j][1] = 0;
            } else if (houses[0] == 0) {
                // 此时需要着色为 j + 1
                dp[0][j][1] = cost[0][j];
            }
        }

        // dp更新
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= target; k++) {
                    // 房子i不能着色为 j + 1
                    if (houses[i] != 0 && houses[i] != j + 1) {
                        continue;
                    }
                    // 房子i着色为 j + 1 / 已经是j + 1
                    int curCost = houses[i] == 0 ? cost[i][j] : 0;
                    // 与上一个颜色相同 / 与上一个颜色不同
                    dp[i][j][k] = dp[i - 1][j][k] + curCost;
                    for (int nj = 0; nj < n; nj++) {
                        if (nj != j) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][nj][k - 1] + curCost);
                        }
                    }
                }
            }
        }

        // 找最小的cost
        int res = MAX_COST;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j][target]);
        }
        return res == MAX_COST ? -1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
