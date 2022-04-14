//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child 
//pointer points to the next node in the list and the left child pointer is always 
//null. 
// The "linked list" should be in the same order as a pre-order traversal of 
//the binary tree. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related 
//Topics Linked List Stack Tree Depth-First Search Binary Tree 👍 5893 👎 434


package leetcode.stack.leetcode.editor.en;

/**
 * @author: eumes
 * @date: 2021-11-24 23:24:06
 * @title: Flatten Binary Tree to Linked List
 */
public class P114FlattenBinaryTreeToLinkedList {
    
    public static void main(String[] args) {
        Solution_114 solution = new Solution_114();
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

class TreeNode_114 {
    int val;
    TreeNode_114 left;
    TreeNode_114 right;
    TreeNode_114() {}

    TreeNode_114(int val) {this.val = val;}

     TreeNode_114(int val, TreeNode_114 left, TreeNode_114 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution_114 {
    public void flatten(TreeNode_114 root) {
        TreeNode_114 cur = root;
        TreeNode_114 tmp;

        while (cur != null) {
            if (cur.left != null) {
                tmp = cur.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
