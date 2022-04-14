package leetcode.stack;

/**
 * @author eumes
 * @date 2020/10/13
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * title: Reverse Substrings Between Each Pair of Parentheses
 * link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * description: You are given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any brackets.
 *
 * examples: Input: s = "(abcd)"
 * Output: "dcba"
 */
public class One_One_Nine_Zero {

    public static void main(String[] args) {
        One_One_Nine_Zero solution = new One_One_Nine_Zero();
        String s1 = "(abcd)";
        String s2 = "(u(love)i)";
        String s3 = "(ed(et(oc))el)";
        String s4 = "a(bcdefghijkl(mno)p)q";

        System.out.println(solution.reverseParentheses_2(s1));
        System.out.println(solution.reverseParentheses_2(s2));
        System.out.println(solution.reverseParentheses_2(s3));
        System.out.println(solution.reverseParentheses_2(s4));
    }

    public String reverseParentheses(String s) {
        s = "(" + s + ")";
        Stack<Character> stack = new Stack<>();

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) != ')') {
                stack.push(s.charAt(i++));
            }
            while (!stack.empty() && stack.peek() != '(') {
                result += stack.pop();
            }
            if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            }
            if (stack.empty()){
                return result;
            }
            for (int j = 0; j < result.length(); j++) {
                stack.push(result.charAt(j));
            }
            result = "";
        }

        return result;
    }

    public String reverseParentheses_1(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(stringBuilder);
                stringBuilder = new StringBuilder();
            } else if (ch == ')') {
                stringBuilder = stack.pop().append(stringBuilder.reverse());
            }else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/discuss/742862/Java-Straightforward-Stack-vs-O(n)
     * @param s
     * @return
     */
    public String reverseParentheses_2(String s) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> pair = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        // 遍历获取()的配对信息
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                pair.put(stack.peek(), i);
                pair.put(i, stack.pop());
            }
        }

        // 遍历获取结果
        for (int i = 0, step = 1; i < s.length(); i += step) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair.get(i);
                step = -step;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
