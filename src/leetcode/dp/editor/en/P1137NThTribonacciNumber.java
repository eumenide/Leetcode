//The Tribonacci sequence Tn is defined as follows: 
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 
//
// Given n, return the value of Tn. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 4
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// Example 2: 
//
// 
//Input: n = 25
//Output: 1389537
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 37 
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1. 
// Related Topics Math Dynamic Programming Memoization 👍 1568 👎 97


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:52
 * @title: N-th Tribonacci Number
 */
public class P1137NThTribonacciNumber {
    
    public static void main(String[] args) {
        Solution_1137 solution = new Solution_1137();
        // TO TEST
        System.out.println(solution.tribonacci(4));
        System.out.println(solution.tribonacci(25));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1137 {
    public int tribonacci(int n) {
        if (n == 0) {return 0;}
        if (n == 1 || n == 2) {return 1;}

        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }

        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
