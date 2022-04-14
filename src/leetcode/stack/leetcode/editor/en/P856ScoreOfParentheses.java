//Given a balanced parentheses string S, compute the score of the string based o
//n the following rule: 
//
// 
// () has score 1 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
//
// 
// Example 1: 
//
// 
//Input: "()"
//Output: 1
// 
//
// 
// Example 2: 
//
// 
//Input: "(())"
//Output: 2
// 
//
// 
// Example 3: 
//
// 
//Input: "()()"
//Output: 2
// 
//
// 
// Example 4: 
//
// 
//Input: "(()(()))"
//Output: 6
// 
//
// 
//
// Note: 
//
// 
// S is a balanced parentheses string, containing only ( and ). 
// 2 <= S.length <= 50 
// 
// 
// 
// 
// 
// Related Topics String Stack 
// 👍 1383 👎 47


package leetcode.stack.leetcode.editor.en;

import java.util.Stack;

/**
 * @author: eumes
 * @date: 2020-10-26 17:27:42
 * @title: Score of Parentheses
 */
public class P856ScoreOfParentheses {
    
    public static void main(String[] args) {
        Solution_856 solution = new Solution_856();
        // TO TEST
        String s1 = "()";
        String s2 = "(())";
        String s3 = "()()";
        String s4 = "(()(()))";

        System.out.println(solution.scoreOfParentheses(s1));
        System.out.println(solution.scoreOfParentheses(s2));
        System.out.println(solution.scoreOfParentheses(s3));
        System.out.println(solution.scoreOfParentheses(s4));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        for (Character ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push(1);
            } else if (ch == ')') {
                int sum = 1;
                while (stack.peek() != 1) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(sum * 2);
            }
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
