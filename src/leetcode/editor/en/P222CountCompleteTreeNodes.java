//Given the root of a complete binary tree, return the number of the nodes in 
//the tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far 
//left as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 10⁴]. 
// 0 <= Node.val <= 5 * 10⁴ 
// The tree is guaranteed to be complete. 
// 
// Related Topics Binary Search Tree Depth-First Search Binary Tree 👍 5094 👎 3
//16


package leetcode.editor.en;

/**
 * Count Complete Tree Nodes
 * 
 * @author: eumes
 * @date: 2022-06-23 00:22:19
 */
 public class P222CountCompleteTreeNodes {
    public static void main(String[] args) {
//        Solution_P222 solution = new Solution_P222();
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
class Solution_P222 {

    // log(N) * log(N)
    // 点是，root的左右子树肯定有一棵是满二叉树
    public int countNodes(TreeNode root) {
        TreeNode le = root, ri = root;
        int lh = 0, rh = 0;
        // 计算最左边高度
        while (le != null) {
            le = le.left;
            lh++;
        }
        // 计算最右边高度
        while (ri != null) {
            ri = ri.right;
            rh++;
        }

        // 如果左右子树高度相同，说明是满二叉树，可以直接计算结果
        if (lh == rh) {
            return (int) (Math.pow(2, lh) - 1);
        }

        // 否则，分别计算左右子树节点数；点仍是左右子树肯定有一棵是满二叉树
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes_n(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
