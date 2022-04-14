//Given a positive integer num, write a function which returns True if num is a 
//perfect square else False. 
//
// Follow up: Do not use any built-in library function such as sqrt. 
//
// 
// Example 1: 
// Input: num = 16
//Output: true
// Example 2: 
// Input: num = 14
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics Math Binary Search 👍 2138 👎 227


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-09 01:21:20
 * @title: Valid Perfect Square
 */
public class P367ValidPerfectSquare {
    
    public static void main(String[] args) {
        Solution_367 solution = new Solution_367();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_367 {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long res = (long)mid * mid;
            if (res == num) {
                return true;
            } else if (res < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
