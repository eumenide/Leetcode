//Given the root of a binary tree, return the sum of values of its deepest 
//leaves.
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//Output: 15
// 
//
// Example 2: 
//
// 
//Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//Output: 19
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// 1 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 29
//54 👎 81


package leetcode.editor.en;

/**
 * Deepest Leaves Sum
 * 
 * @author: eumes
 * @date: 2022-05-15 21:45:42
 */
 public class P1302DeepestLeavesSum {
    public static void main(String[] args) {
//        Solution_P1302 solution = new Solution_P1302();
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
class Solution_P1302 {
    int maxHeight = Integer.MIN_VALUE;
    int maxSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        inOrder(root, 0);
        return maxSum;
    }

    private void inOrder(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height += 1;
        inOrder(root.left, height);
        // 如果是叶子节点，则更新最大高度和最大和
        if (root.left == null && root.right == null) {
            // 更深的深度
            if (maxHeight < height) {
                maxHeight = height;
                maxSum = root.val;
            } else if (maxHeight == height) {
                // 同一深度，更新和
                maxSum += root.val;
            }
        }
        inOrder(root.right, height);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
