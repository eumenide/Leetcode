package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/6
 **/

import java.util.Stack;

/**
 * title: Minimum Add to Make Parentheses Valid
 * link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
 * description: Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * examples: Input: "())"
 * Output: 1
 */
public class Nine_Two_One {

	public static void main(String[] args) {
		Nine_Two_One solution = new Nine_Two_One();
		String s1 = "())";
		String s2 = "(((";
		String s3 = "()";
		String s4 = "()))((";

		System.out.println(solution.minAddToMakeValid(s1));
		System.out.println(solution.minAddToMakeValid(s2));
		System.out.println(solution.minAddToMakeValid(s3));
		System.out.println(solution.minAddToMakeValid(s4));
	}

	public int minAddToMakeValid(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.empty() && stack.peek().equals('(') && s.charAt(i) == ')') {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.size();
	}
}
