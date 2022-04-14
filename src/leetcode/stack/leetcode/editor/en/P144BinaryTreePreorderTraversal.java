//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 3175 👎 109


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-19 22:28:14
 * @title: Binary Tree Preorder Traversal
 */
public class P144BinaryTreePreorderTraversal {
    
    public static void main(String[] args) {
        Solution_144 solution = new Solution_144();
        // TO TEST 1
        TreeNode_144 node3 = new TreeNode_144(3);
        TreeNode_144 node2 = new TreeNode_144(2, node3, null);
        TreeNode_144 node1 = new TreeNode_144(1, null, node2);
        System.out.println(solution.preorderTraversal(node1));

        // Test 2
        System.out.println(solution.preorderTraversal(null));

        // Test 3
        node1 = new TreeNode_144(1);
        System.out.println(solution.preorderTraversal(node1));

        // Test 4
        node2 = new TreeNode_144(2);
        node1 = new TreeNode_144(1, node2, null);
        System.out.println(solution.preorderTraversal(node1));

        // Test 5
        node1 = new TreeNode_144(1, null, node2);
        System.out.println(solution.preorderTraversal(node1));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode_144 {
    int val;
    TreeNode_144 left;
    TreeNode_144 right;
    TreeNode_144() {}
    TreeNode_144(int val) { this.val = val; }
    TreeNode_144(int val, TreeNode_144 left, TreeNode_144 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode_144 root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode_144> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode_144 node = stack.pop();
            if (node == null) {
                continue;
            }
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode_144 root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            preOrder(root, list);
        }
        return list;
    }

    public void preOrder(TreeNode_144 node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
