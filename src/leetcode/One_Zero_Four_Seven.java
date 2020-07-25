package leetcode;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/

import java.util.Stack;

/**
 * title: Remove All Adjacent Duplicates In String
 * description: Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
public class One_Zero_Four_Seven {

	public static void main(String[] args) {
		String input = "abbaca";

		System.out.println(removeDuplicates(input));
	}

	public static String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			if (!stack.empty() && stack.peek() == S.charAt(i)) {
				stack.pop();
			} else {
				stack.push(S.charAt(i));
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.empty()) {
			stringBuilder.append(stack.pop());
		}

		return stringBuilder.reverse().toString();

	}
}
