//You are given the root of a binary search tree (BST), where the values of 
//exactly two nodes of the tree were swapped by mistake. Recover the tree without 
//changing its structure. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 
//makes the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 
//and 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//Follow up: A solution using O(n) space is pretty straight-forward. Could you 
//devise a constant O(1) space solution? Related Topics Tree Depth-First Search 
//Binary Search Tree Binary Tree 👍 4879 👎 168


package leetcode.editor.en;

/**
 * Recover Binary Search Tree
 * 
 * @author: eumes
 * @date: 2022-04-19 23:33:03
 */
 public class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
//        Solution_P99 solution = new Solution_P99();
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
class Solution_P99 {
    TreeNode first;
    TreeNode second;
    // prev应该比当前小
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        traverse(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return ;
        }

        traverse(root.left);
        //
        if (first == null && prev != null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev != null && prev.val > root.val) {
            second = root;
        }

        prev = root;
        traverse(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
