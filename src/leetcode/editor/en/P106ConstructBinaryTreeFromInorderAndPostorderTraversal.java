//Given two integer arrays inorder and postorder where inorder is the inorder 
//traversal of a binary tree and postorder is the postorder traversal of the same 
//tree, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 4462 ?
//? 73


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * @author: eumes
 * @date: 2022-05-23 00:57:48
 */
 public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
//        Solution_P106 solution = new Solution_P106();
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
class Solution {
    // 记录中序序列中值与索引关系
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int poS, int poE) {
        if (inS > inE) {
            return null;
        }

        // 后序中的最后一个节点即为根节点
        int rootI = map.get(postorder[poE]);
        int leftS = rootI - inS;
        TreeNode root = new TreeNode(postorder[poE]);

        // 递归构造左右子树
        root.left = build(inorder, inS, rootI - 1, postorder, poS, poS + leftS - 1);
        root.right = build(inorder, rootI + 1, inE, postorder, poS + leftS, poE - 1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
