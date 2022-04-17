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
//? 2965 👎 620


package leetcode.editor.en;


import java.util.Stack;

/**
 * Increasing Order Search Tree
 * 
 * @author: eumes
 * @date: 2022-04-18 00:33:40
 */
 public class P897IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution_P897 solution = new Solution_P897();
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
class Solution_P897 {
    public TreeNode increasingBST_ite(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(-1, null, root);
        TreeNode prev = dummy;
        while (root != null || !stack.isEmpty()) {
            // 找到左子树最左边
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 找到后调整指向
                TreeNode cur = stack.pop();
                // 下一步遍历右子树
                root = cur.right;
                cur.left = null;
                prev.right = cur;
                prev = cur;
            }
        }

        return dummy.right;
    }

    public TreeNode increasingBST(TreeNode root) {
        // 递归
        return increasingBST(root, null);
    }

    private TreeNode increasingBST(TreeNode root, TreeNode next) {
        // root为当前节点，next为root的下一个节点
        if (root == null) {
            return next;
        }
        // 递归左侧，找到头节点；左子树的下一个节点为当前节点
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        // 递归右侧，找到右子树的头节点；右子树的下一个节点为当前节点的父节点
        root.right = increasingBST(root.right, next);
        return res;
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
