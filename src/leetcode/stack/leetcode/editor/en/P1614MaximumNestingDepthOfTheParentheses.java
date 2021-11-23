//A string is a valid parentheses string (denoted VPS) if it meets one of the 
//following: 
//
// 
// It is an empty string "", or a single character not equal to "(" or ")", 
// It can be written as AB (A concatenated with B), where A and B are VPS's, or 
//
// It can be written as (A), where A is a VPS. 
// 
//
// We can similarly define the nesting depth depth(S) of any VPS S as follows: 
//
// 
// depth("") = 0 
// depth(C) = 0, where C is a string with a single character not equal to "(" 
//or ")". 
// depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's. 
// depth("(" + A + ")") = 1 + depth(A), where A is a VPS. 
// 
//
// For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, 
//and 2), and ")(" and "(()" are not VPS's. 
//
// Given a VPS represented as string s, return the nesting depth of s. 
//
// 
// Example 1: 
//
// 
//Input: s = "(1+(2*3)+((8)/4))+1"
//Output: 3
//Explanation: Digit 8 is inside of 3 nested parentheses in the string.
// 
//
// Example 2: 
//
// 
//Input: s = "(1)+((2))+(((3)))"
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "1+(2*3)/(2-1)"
//Output: 1
// 
//
// Example 4: 
//
// 
//Input: s = "1"
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'. 
// It is guaranteed that parentheses expression s is a VPS. 
// 
// Related Topics String Stack 👍 604 👎 140


package leetcode.stack.leetcode.editor.en;

/**
 * @author: eumes
 * @date: 2021-11-23 00:07:26
 * @title: Maximum Nesting Depth of the Parentheses
 */
public class P1614MaximumNestingDepthOfTheParentheses {
    
    public static void main(String[] args) {
        Solution_1614 solution = new Solution_1614();
        // TO TEST 1
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(solution.maxDepth(s));

        // Test 2
        s = "(1)+((2))+(((3)))";
        System.out.println(solution.maxDepth(s));

        // Test 3
        s = "1+(2*3)/(2-1)";
        System.out.println(solution.maxDepth(s));

        // Test 4
        s = "1";
        System.out.println(solution.maxDepth(s));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1614 {
    public int maxDepth(String s) {
        int temp = 0;
        int max = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
            } else if (s.charAt(i) == ')') {
                max = Math.max(max, temp);
                temp--;
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)