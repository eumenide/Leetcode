//Given an integer n, return an array ans of length n + 1 such that for each i (
//0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// Example 2: 
//
// 
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
// Follow up: 
//
// 
// It is very easy to come up with a solution with a runtime of O(n log n). Can 
//you do it in linear time O(n) and possibly in a single pass? 
// Can you do it without using any built-in function (i.e., like __builtin_
//popcount in C++)? 
// 
// Related Topics Dynamic Programming Bit Manipulation 👍 6221 👎 295


package leetcode.dp.editor.en;

import java.util.Arrays;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:31
 * @title: Counting Bits
 */
public class P338CountingBits {
    
    public static void main(String[] args) {
        Solution_338 solution = new Solution_338();
        // TO TEST
        System.out.println(Arrays.toString(solution.countBits(2)));

        System.out.println(Arrays.toString(solution.countBits(5)));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_338 {
    public int[] countBits(int n) {
        // 0 1 10 11 100 101 110 111 1000 1001 1010 1011 1100 1101 1110 1111 10000 10001 10010 10011 10100 10101 10110 10111 11000 11001 11010 11011 11100
        // 0 1  2  3  4   5   6   7   8     9   10   11    12  13   14   15    16    17    18    19    20
        // 0 1  1  2  1   2   2   3   1     2    2    3     2   3    3    4     1     2     2     3     2     3     3     4    2     3      3    4     3     5  6

        // 观察到  100  =  10  + 0，101  =  10  +  1，110  = 11 + 0
        // 即  dp[i] = dp[i/2] + i % 2;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i >> 1] + i % 2;
        }

        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
