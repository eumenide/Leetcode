package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/6
 **/

import java.util.Collections;
import java.util.Stack;

/**
 * title: Make The String Great
 * link: https://leetcode.com/problems/make-the-string-great/
 * description: Given a string s of lower and upper case English letters.
 *
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 *
 * Notice that an empty string is also good.
 *
 * examples: Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 */
public class One_Five_Four_Four {

	public static void main(String[] args) {
		One_Five_Four_Four solution = new One_Five_Four_Four();
		String s1 = "leEeetcode";
		String s2 = "abBAcC";
		String s3 = "s";

		System.out.println(solution.makeGood(s1));
		System.out.println(solution.makeGood(s2));
		System.out.println(solution.makeGood(s3));

		System.out.println('B' - 'b');
	}

	public String makeGood(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.empty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		stack.forEach(stringBuilder::append);

		return stringBuilder.toString();
	}
}
