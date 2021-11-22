//Given the root of a binary search tree, rearrange the tree in in-order so 
//that the leftmost node in the tree is now the root of the tree, and every node has 
//no left child and only one right child. 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,7]
//Output: [1,null,5,null,7]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree will be in the range [1, 100]. 
// 0 <= Node.val <= 1000 
// Related Topics Stack Tree Depth-First Search Binary Search Tree Binary Tree ?
//? 1913 👎 571


package leetcode.stack.leetcode.editor.en;

/**
 * @author: eumes
 * @date: 2021-11-21 22:50:25
 * @title: Increasing Order Search Tree
 */
public class P897IncreasingOrderSearchTree {
    
    public static void main(String[] args) {
        Solution_897 solution = new Solution_897();
        // TO TEST
        
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

class TreeNode_897 {
    int val;
    TreeNode_897 left;
    TreeNode_897 right;

    TreeNode_897() {}
    TreeNode_897(int val) {this.val = val;}
    TreeNode_897(int val, TreeNode_897 left, TreeNode_897 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_897 {
    TreeNode_897 cur;

    public TreeNode_897 increasingBST(TreeNode_897 root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode_897 result = new TreeNode_897();
        cur = result;

        inOrder(root);
        return result.right;
    }

    public void inOrder(TreeNode_897 node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inOrder(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
