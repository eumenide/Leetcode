//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
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
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [2,1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? 
//Related Topics Stack Tree Depth-First Search Binary Tree 👍 3356 👎 128


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-19 22:52:15
 * @title: Binary Tree Postorder Traversal
 */
public class P145BinaryTreePostorderTraversal {
    
    public static void main(String[] args) {
        Solution_145 solution = new Solution_145();
        // TO TEST 1
        TreeNode_145 node3 = new TreeNode_145(3);
        TreeNode_145 node2 = new TreeNode_145(2, node3, null);
        TreeNode_145 root = new TreeNode_145(1, null, node2);
        System.out.println(solution.postorderTraversal(root));

        // Test 2
        System.out.println(solution.postorderTraversal(null));

        // Test 3
        root = new TreeNode_145(1);
        System.out.println(solution.postorderTraversal(root));

        // Test 4
        node2 = new TreeNode_145(2);
        root = new TreeNode_145(1, node2, null);
        System.out.println(solution.postorderTraversal(root));

        // Test 5
        root = new TreeNode_145(1, null, node2);
        System.out.println(solution.postorderTraversal(root));

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

class TreeNode_145 {
    int val;
    TreeNode_145 left;
    TreeNode_145 right;
    TreeNode_145() {}
    TreeNode_145(int val) { this.val = val; }
    TreeNode_145(int val, TreeNode_145 left, TreeNode_145 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_145 {

    public List<Integer> postorderTraversal(TreeNode_145 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode_145> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode_145 node = stack.pop();
            list.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode_145 root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);

        return list;
    }

    public void postOrder(TreeNode_145 node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
