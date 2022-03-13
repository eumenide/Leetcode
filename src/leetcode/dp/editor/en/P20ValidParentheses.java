//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 11889 👎 517


package leetcode.dp.editor.en;

import java.util.Stack;

/**
 * @author: eumes
 * @date: 2022-03-13 18:30:13
 * @title: Valid Parentheses
 */
public class P20ValidParentheses {
    
    public static void main(String[] args) {
        Solution_20 solution = new Solution_20();
        // TO TEST
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_20 {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (!stack.isEmpty() && stack.peek() == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
