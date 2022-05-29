//Given two integer arrays, preorder and postorder where preorder is the 
//preorder traversal of a binary tree of distinct values and postorder is the postorder 
//traversal of the same tree, reconstruct and return the binary tree. 
//
// If there exist multiple answers, you can return any of them. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [1], postorder = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// All the values of preorder are unique. 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// All the values of postorder are unique. 
// It is guaranteed that preorder and postorder are the preorder traversal and 
//postorder traversal of the same binary tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 1902 ?
//? 86


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Postorder Traversal
 * 
 * @author: eumes
 * @date: 2022-05-29 00:32:11
 */
 public class P889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
//        Solution_P889 solution = new Solution_P889();
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
class Solution_P889 {

    Map<Integer, Integer> map;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int preS, int preE, int[] postorder, int poS, int poE) {
        if (preS > preE) {
            return null;
        }
        if (preS == preE) {
            // 没有左右节点了，直接构造返回
            return new TreeNode(preorder[preE]);
        }

        // 选取preorder中的下一个元素作为左节点，在postorder中根据位置确定左右子树的范围
        int leV = preorder[preS + 1];
        int leI = map.get(leV);
        int leL = leI - poS + 1;

        TreeNode root = new TreeNode(preorder[preS]);
        root.left = build(preorder, preS + 1, preS + leL, postorder, poS, leI);
        root.right = build(preorder, preS + leL + 1, preE, postorder, leI + 1, poE);

        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
