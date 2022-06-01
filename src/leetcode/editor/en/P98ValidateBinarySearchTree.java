//Given the root of a binary tree, determine if it is a valid binary search 
//tree (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 9908
// 👎 894


package leetcode.editor.en;

/**
 * Validate Binary Search Tree
 * 
 * @author: eumes
 * @date: 2022-06-01 23:50:39
 */
 public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
//        Solution_P98 solution = new Solution_P98();
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
class Solution_P98 {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    // 验证 root是否在max和min之间；左子树的max为root，右子树的min为root，即root应大于左子树所有节点、小于右子树所有节点
    private boolean validateBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }

        return validateBST(root.left, root, min) && validateBST(root.right, max, root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
