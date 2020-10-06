package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/6
 **/

import java.util.Stack;

/**
 * title: Crawler Log Folder
 * link: https://leetcode.com/problems/crawler-log-folder/
 * description: The Leetcode file system keeps a log each time some user performs a change folder operation.
 *
 * The operations are described below:
 *
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 *
 * The file system starts in the main folder, then the operations in logs are performed.
 *
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 *
 * examples: Input: logs = ["d1/","d2/","../","d21/","./"]
 * Output: 2
 * Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
 */
public class One_Five_Nine_Eight {

	public static void main(String[] args) {
		One_Five_Nine_Eight solution = new One_Five_Nine_Eight();

		String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
		String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
		String[] logs3 = {"d1/", "../", "../", "../"};

		System.out.println(solution.minOperations(logs1));
		System.out.println(solution.minOperations(logs2));
		System.out.println(solution.minOperations(logs3));

	}

	public int minOperations(String[] logs) {
		Stack<String> stack = new Stack<>();
		for (String log : logs) {
			switch (log) {
				case "../":
					if (!stack.empty()) {
						stack.pop();
					}
					break;
				case "./":
					break;
				default:
					stack.push(log);
					break;
			}
		}
		return stack.size();
	}
}
