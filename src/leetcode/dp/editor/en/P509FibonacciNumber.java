//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the 
//Fibonacci sequence, such that each number is the sum of the two preceding ones, 
//starting from 0 and 1. That is, 
//
// 
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
// 
//
// Given n, calculate F(n). 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// Example 3: 
//
// 
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 30 
// 
// Related Topics Math Dynamic Programming Recursion Memoization 👍 3020 👎 255


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:44
 * @title: Fibonacci Number
 */
public class P509FibonacciNumber {
    
    public static void main(String[] args) {
        Solution_509 solution = new Solution_509();
        // TO TEST
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_509 {

    public int fib(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int fib_1(int n) {
        //F(0) = 0, F(1) = 1
        //F(n) = F(n - 1) + F(n - 2), for n > 1.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib_1(n - 1) + fib_1(n - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
