package leetcode;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/

import java.util.Stack;

/**
 * title: Backspace String Compare
 * description: Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 */
public class Eight_Four_Four {

	public static void main(String[] args) {
		String S1 = "ab#c", T1 = "ad#c";
		String S2 = "ab##", T2 = "c#d#";
		String S3 = "a##c", T3 = "#a#c";

		System.out.println(backspaceCompare(S1, T1));
		System.out.println(backspaceCompare(S2, T2));
		System.out.println(backspaceCompare(S3, T3));
	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> stackS = new Stack<>();
		Stack<Character> stackT = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (!stackS.empty()) {
					stackS.pop();
				}
			} else {
				stackS.push(S.charAt(i));
			}
		}

		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#') {
				if (!stackT.empty()) {
					stackT.pop();
				}
			} else {
				stackT.push(T.charAt(i));
			}
		}

		while (!stackT.empty() && !stackS.empty()) {
			if (stackS.pop() != stackT.pop()) {
				return false;
			}
		}

		return stackS.empty() && stackT.empty();

	}
}
