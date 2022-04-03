//You are given an integer array cost where cost[i] is the cost of iᵗʰ step on 
//a staircase. Once you pay the cost, you can either climb one or two steps. 
//
// You can either start from the step with index 0, or the step with index 1. 
//
// Return the minimum cost to reach the top of the floor. 
//
// 
// Example 1: 
//
// 
//Input: cost = [10,15,20]
//Output: 15
//Explanation: You will start at index 1.
//- Pay 15 and climb two steps to reach the top.
//The total cost is 15.
// 
//
// Example 2: 
//
// 
//Input: cost = [1,100,1,1,1,100,1,1,100,1]
//Output: 6
//Explanation: You will start at index 0.
//- Pay 1 and climb two steps to reach index 2.
//- Pay 1 and climb two steps to reach index 4.
//- Pay 1 and climb two steps to reach index 6.
//- Pay 1 and climb one step to reach index 7.
//- Pay 1 and climb two steps to reach index 9.
//- Pay 1 and climb one step to reach the top.
//The total cost is 6.
// 
//
// 
// Constraints: 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
// Related Topics Array Dynamic Programming 👍 5427 👎 957


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:39
 * @title: Min Cost Climbing Stairs
 */
public class P746MinCostClimbingStairs {
    
    public static void main(String[] args) {
        Solution_746 solution = new Solution_746();
        // TO TEST
        int[] cost = new int[] {10, 15, 20};
        // 15
        System.out.println(solution.minCostClimbingStairs(cost));

        cost = new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        // 6
        System.out.println(solution.minCostClimbingStairs(cost));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        // dp2表示往右跳2阶最小cost，dp1表示往右跳1阶最小cost
        int dp2 = 0;
        int dp1 = cost[cost.length - 1];

        for (int i = cost.length - 2; i >= 0; i--) {
            int dp = cost[i] + Math.min(dp1, dp2);
            dp2 = dp1;
            dp1 = dp;
        }

        return Math.min(dp1, dp2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
