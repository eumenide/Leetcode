package leetcode;

/**
 * @author: eumes
 * @date: 2020/7/26
 **/


import java.util.Stack;

/**
 * title: Baseball Game
 * description: You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 *
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Input: ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * Round 1: You could get 5 points. The sum is: 5.
 * Round 2: You could get 2 points. The sum is: 7.
 * Operation 1: The round 2's data was invalid. The sum is: 5.
 * Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 */
public class Six_Eight_Two {

	public static void main(String[] args) {
		String[] ops1 = {"5", "2", "C", "D", "+"};
		String[] op2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};

		System.out.println(calPoints(ops1));
		System.out.println(calPoints(op2));
	}

	public static int calPoints(String[] ops) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();

		for (String str : ops) {
			switch (str) {
				case "C":
					sum -= stack.pop();
					break;
				case "D":
					stack.push(stack.peek() * 2);
					sum += stack.peek();
					break;
				case "+":
					stack.push(stack.elementAt(stack.size() - 2) + stack.peek());
					sum += stack.peek();
					break;
				default:
					stack.push(Integer.parseInt(str));
					sum += stack.peek();
					break;
			}
		}

		return sum;
	}

}
