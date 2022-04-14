//Given a non-negative integer x, compute and return the square root of x. 
//
// Since the return type is an integer, the decimal digits are truncated, and 
//only the integer part of the result is returned. 
//
// Note: You are not allowed to use any built-in exponent function or operator, 
//such as pow(x, 0.5) or x ** 0.5. 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since the decimal part 
//is truncated, 2 is returned. 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics Math Binary Search 👍 3613 👎 3109


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-09 01:03:57
 * @title: Sqrt(x)
 */
public class P69Sqrtx {
    
    public static void main(String[] args) {
        Solution_69 solution = new Solution_69();
        // TO TEST
        System.out.println(solution.mySqrt(2147395599));
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_69 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left +((right - left) >> 1);
            long res = (long)mid * mid;
            if (res == x) {
                return mid;
            } else if (res > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
