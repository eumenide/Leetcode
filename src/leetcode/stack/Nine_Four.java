package leetcode.stack;

/**
 * @author: eumes
 * @date: 2020/10/10
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * title: Binary Tree Inorder Traversal
 * link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * description: Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * examples: Input: root = [1,null,2,3]
 * Output: [1,3,2]
 */
public class Nine_Four {

	public static void main(String[] args) {
		Nine_Four solution = new Nine_Four();

		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2, node3, null);
		TreeNode root1 = new TreeNode(1, null, node2);

		TreeNode root2 = null;

		TreeNode root3 = new TreeNode(1);

		TreeNode node22 = new TreeNode(2);
		TreeNode root4 = new TreeNode(1, node22, null);

		TreeNode root5 = new TreeNode(1, null, node22);


		System.out.println(solution.inorderTraversal(root1));
		System.out.println(solution.inorderTraversal(root2));
		System.out.println(solution.inorderTraversal(root3));
		System.out.println(solution.inorderTraversal(root4));
		System.out.println(solution.inorderTraversal(root5));

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.empty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}

		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}





























