package leetcode.stack;


/**
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 */

/**
 * @author: eumes
 * @date: 2020/7/24
 **/
public class One_Zero_Two_One {

	public static void main(String[] args) {
		String input1 = "(()())(())";
		String input2 = "(()())(())(()(()))";
		String input3 = "()()";

		System.out.println(removeOuterParentheses(input1));
		System.out.println(removeOuterParentheses(input2));
		System.out.println(removeOuterParentheses(input3));
	}

	public static String removeOuterParentheses(String s) {
		StringBuilder stringBuilder = new StringBuilder();

		int parenLevel = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' && parenLevel++ > 0) {
				stringBuilder.append('(');
			} else if (s.charAt(i) == ')' && parenLevel-- > 1){
				stringBuilder.append(')');
			}
		}

		return stringBuilder.toString();
	}

}
