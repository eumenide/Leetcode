//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 8497 ?
//? 231


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * @author: eumes
 * @date: 2022-05-23 00:52:17
 */
 public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
//        Solution_P105 solution = new Solution_P105();
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
class Solution_P105 {
    // 存储中序序列中的值与索引关系
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if (preS > preE) {
            return null;
        }

        // 前序中的第一个节点即为根节点，此时需要确认中序序列中的左右子树划分
        int rootI = map.get(preorder[preS]);
        int leftS = rootI - inS;
        TreeNode root = new TreeNode(preorder[preS]);

        // 递归构造左右子树
        root.left = build(preorder, preS + 1, preS + leftS, inorder, inS, rootI - 1);
        root.right = build(preorder, preS + leftS + 1, preE, inorder, rootI + 1, inE);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
