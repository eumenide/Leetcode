//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Math Dynamic Programming Memoization 👍 10245 👎 316


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-02-07 12:55:10
 * @title: Climbing Stairs
 */
public class P70ClimbingStairs {
    
    public static void main(String[] args) {
        Solution_70 solution = new Solution_70();
        // TO TEST
        System.out.println(solution.climbStairs(2));

        System.out.println(solution.climbStairs(3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_70 {

    /**
     * 空间1
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // steps[i]表示第n阶台阶时，走法总数
        int oneStep = 1;
        int twoStep = 1;
        int tmp;
        for (int i = 0; i < n - 1; i++) {
            oneStep = oneStep + twoStep;
            twoStep = oneStep - twoStep;

            //tmp = twoStep;
            //twoStep = oneStep;
            //oneStep = tmp + oneStep;
        }

        return oneStep;
    }

    /**
     * 空间n
     *
     * @param n
     * @return
     */
    public int climbStairs_n(int n) {
        // steps[i]表示第n阶台阶时，走法总数
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
