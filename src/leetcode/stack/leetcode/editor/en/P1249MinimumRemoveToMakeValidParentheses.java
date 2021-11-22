//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// s[i] is one of '(' , ')' and lowercase English letters. 
// Related Topics String Stack 
// 👍 1165 👎 30


package leetcode.stack.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2020-10-14 01:27:20
 * @title: Minimum Remove to Make Valid Parentheses
 */
public class P1249MinimumRemoveToMakeValidParentheses {
    
    public static void main(String[] args) {
        Solution_1249 solution = new Solution_1249();
        // TO TEST
        String s1 = "lee(t(c)o)de)";
        String s2 = "a)b(c)d";
        String s3 = "))((";
        String s4 = "(a(b(c)d)";

        System.out.println(solution.minRemoveToMakeValid(s1));
        System.out.println(solution.minRemoveToMakeValid(s2));
        System.out.println(solution.minRemoveToMakeValid(s3));
        System.out.println(solution.minRemoveToMakeValid(s4));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        while (!stack.empty()) {
            chars[stack.pop()] = '-';
        }
        for (char ch : chars) {
            if (ch != '-') {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    public String minRemoveToMakeValid_1(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        Map<Integer, Integer> pair = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    pair.put(i, stack.peek());
                    pair.put(stack.pop(), i);
                } else {
                    stack.push(i);
                }
            }
        }

        while (!stack.empty()) {
            stringBuilder = stringBuilder.replace(stack.peek(), stack.pop() + 1, "-");
        }

        return stringBuilder.toString().replaceAll("-", "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
