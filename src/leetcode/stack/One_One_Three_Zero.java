package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/6
 **/

import java.util.Stack;

/**
 * title: Minimum Cost Tree From Leaf Values
 * link: https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 * description: Given an array arr of positive integers, consider all binary trees such that:
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 *
 * example: Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 */
public class One_One_Three_Zero {

	public static void main(String[] args) {
		One_One_Three_Zero solution = new One_One_Three_Zero();
		int[] arr = {6, 2, 4};

		System.out.println(solution.mctFromLeafValues(arr));
		System.out.println(solution.mctFromLeafValuesBest(arr));
	}

	public int mctFromLeafValuesBest(int[] arr) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);

		for (int anArr : arr) {
			while (stack.peek() <= anArr) {
				int mid = stack.pop();
				res += Math.min(stack.peek(), anArr) * mid;
			}
			stack.push(anArr);
		}
		while (stack.size() > 2) {
			res += stack.pop() * stack.peek();
		}

		return res;
	}

	public int mctFromLeafValues(int[] arr) {
		int len = arr.length;
		int[][] dp = new int[len][len];
		int[][] max = new int[len][len];

		// max[i][j]表示arr[i]~arr[j]中的最大值
		for (int i = 0; i < len - 1; i++) {
			max[i][i] = arr[i];
			dp[i][i + 1] = arr[i] * arr[i + 1];
			for (int j = i + 1; j < len; j++) {
				max[i][j] = Math.max(max[i][j - 1], arr[j]);
			}
		}
		max[len - 1][len - 1] = arr[len - 1];

		// dp[i][j]表示arr[i]~arr[j]组成树的和最小值
		int end;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				end = j + i;
				dp[j][end] = Integer.MAX_VALUE;
				for (int k = j; k < end; k++) {
					dp[j][end] = Math.min(max[j][k] * max[k + 1][end] + dp[j][k] + dp[k + 1][end], dp[j][end]);
				}
			}
		}

		return dp[0][len - 1];
	}
}
