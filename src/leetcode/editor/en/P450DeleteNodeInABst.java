//Given a root node reference of a BST and a key, delete the node with the 
//given key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and 
//delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's 
//also accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
// Follow up: Could you solve it with time complexity O(height of tree)? 
// Related Topics Tree Binary Search Tree Binary Tree 👍 5443 👎 161


package leetcode.editor.en;

/**
 * Delete Node in a BST
 * 
 * @author: eumes
 * @date: 2022-06-02 00:42:14
 */
 public class P450DeleteNodeInABst {
    public static void main(String[] args) {
//        Solution_P450 solution = new Solution_P450();
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
class Solution_P450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 先按BST找到要删除的节点
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // 情况1：左子树或右子树为null，则直接将找到的节点替换成另一边；相当于删除了该节点，并保持了BST
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // 情况2：左子树和右子树都是null，则直接将找到的节点置为null；相当于删除了该节点，并保持了BST。恰巧，上述情况1的实现覆盖了这种情况。

            // 情况3：左子树和右子树都不为null，则可选择，此处选择找到右子树最小的节点，替换该节点；并删除那个最小节点
            TreeNode min = findMin(root.right);
            // 删除最小节点
            root.right = deleteNode(root.right, min.val);
            // 替换root节点
            min.left = root.left;
            min.right = root.right;
            root = min;
        }

        return root;
    }

    private TreeNode findMin(TreeNode root) {
        // 最小节点肯定在最左边
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
