//Given a string containing just the characters '(' and ')', find the length of 
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming Stack 👍 8455 👎 282


package leetcode.editor.en;

/**
 * Longest Valid Parentheses
 * 
 * @author: eumes
 * @date: 2022-05-25 01:07:19
 */
 public class P32LongestValidParentheses {
    public static void main(String[] args) {
//        Solution_P32 solution = new Solution_P32();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P32 {
    public int longestValidParentheses(String s) {
        int le = 0, ri = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                le++;
            } else {
                ri++;
            }

            if (le == ri) {
                ans = Math.max(ans, ri + le);
            }
            if (ri > le) {
                ri = le = 0;
            }
        }

        le = ri = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                ri++;
            } else {
                le++;
            }

            if (ri == le) {
                ans = Math.max(ans, le + ri);
            }
            if (le > ri) {
                le = ri = 0;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
