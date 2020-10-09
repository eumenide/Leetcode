package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/10
 **/

import java.util.Arrays;
import java.util.Stack;

/**
 * title: Daily Temperatures
 * link: https://leetcode.com/problems/daily-temperatures/
 * description: Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class Seven_Three_Nine {

	public static void main(String[] args) {
		Seven_Three_Nine solution = new Seven_Three_Nine();
		int[] array = {73, 74, 75, 71, 69, 72, 76, 73};

		System.out.println(Arrays.toString(solution.dailyTemperatures(array)));

	}

	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);

		int tmp;
		for (int i = 0; i < T.length; i++) {
			while (stack.peek() < T.length && T[stack.peek()] <= T[i]) {
				tmp = stack.pop();
				result[tmp] = i - tmp;
			}
			stack.push(i);
		}


		return result;
	}
}