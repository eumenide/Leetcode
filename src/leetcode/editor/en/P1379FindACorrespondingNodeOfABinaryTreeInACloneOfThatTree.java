//Given two binary trees original and cloned and given a reference to a node 
//target in the original tree. 
//
// The cloned tree is a copy of the original tree. 
//
// Return a reference to the same node in the cloned tree. 
//
// Note that you are not allowed to change any of the two trees or the target 
//node and the answer must be a reference to a node in the cloned tree. 
//
// 
// Example 1: 
//
// 
//Input: tree = [7,4,3,null,null,6,19], target = 3
//Output: 3
//Explanation: In all examples the original and cloned trees are shown. The 
//target node is a green node from the original tree. The answer is the yellow node 
//from the cloned tree.
// 
//
// Example 2: 
//
// 
//Input: tree = [7], target =  7
//Output: 7
// 
//
// Example 3: 
//
// 
//Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// The values of the nodes of the tree are unique. 
// target node is a node from the original tree and is not null. 
// 
//
// 
// Follow up: Could you solve the problem if repeated values on the tree are 
//allowed? 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 10
//80 👎 1398


package leetcode.editor.en;

/**
 * Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * 
 * @author: eumes
 * @date: 2022-05-18 01:25:30
 */
 public class P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public static void main(String[] args) {
//        Solution_P1379 solution = new Solution_P1379();
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
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution_P1379 {

    // 遍历二叉树
    TreeNode res = null;
    public final TreeNode getTargetCopy_tra(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original, cloned, target);
        return res;
    }

    private void traverse(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return;
        }
        if (original == target) {
            res = cloned;
            return;
        }

        traverse(original.left, cloned.left, target);
        traverse(original.right, cloned.right, target);
    }

    // 分解子问题
    public final TreeNode getTargetCopy_split(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        // 从左子树找，找到直接返回
        TreeNode left = getTargetCopy_split(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }

        // 否则，从右子树找，返回结果
        return getTargetCopy_split(original.right, cloned.right, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
