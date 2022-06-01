//Given two integers dividend and divisor, divide two integers without using 
//multiplication, division, and mod operator. 
//
// The integer division should truncate toward zero, which means losing its 
//fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be 
//truncated to -2. 
//
// Return the quotient after dividing dividend by divisor. 
//
// Note: Assume we are dealing with an environment that could only store 
//integers within the 32-bit signed integer range: [−2³¹, 2³¹ − 1]. For this problem, if 
//the quotient is strictly greater than 2³¹ - 1, then return 2³¹ - 1, and if the 
//quotient is strictly less than -2³¹, then return -2³¹. 
//
// 
// Example 1: 
//
// 
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
// 
//
// Example 2: 
//
// 
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
// Related Topics Math Bit Manipulation 👍 3020 👎 10470


package leetcode.editor.en;

/**
 * Divide Two Integers
 * 
 * @author: eumes
 * @date: 2022-05-31 00:17:31
 */
 public class P29DivideTwoIntegers {
    public static void main(String[] args) {
//        Solution_P29 solution = new Solution_P29();
        // TO TEST
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE - 2);
        System.out.println(Math.abs(Integer.MIN_VALUE) - 2);
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P29 {
    public int divide(int dividend, int divisor) {
        // 可利用位运算，通过减法替代除法
        // 但要考虑效率，可利用每次翻倍减，利用log(n)找到最大可减的数
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int dd = Math.abs(dividend), dv = Math.abs(divisor);
        int ans = 0, sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        while (dd - dv >= 0) {
            int tmpDv = dv, tmpA = 1;
            while (dd - (tmpDv << 1) >= 0) {
                tmpDv <<= 1;
                tmpA <<= 1;
            }

            ans += tmpA;
            dd -= tmpDv;
        }

        return ans * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
