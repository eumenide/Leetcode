//Given the root of a binary tree, imagine yourself standing on the right side 
//of it, return the values of the nodes you can see ordered from top to bottom. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,3]
//Output: [1,3]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 75
//86 👎 429


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Right Side View
 * 
 * @author: eumes
 * @date: 2022-07-11 23:32:55
 */
 public class P199BinaryTreeRightSideView {
    public static void main(String[] args) {
//        Solution_P199 solution = new Solution_P199();
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
class Solution_P199 {
    // BFS：层次遍历
    public List<Integer> rightSideView_bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }

        return res;
    }

    // DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }

        depth++;
        if (res.size() < depth) {
            res.add(root.val);
        }
        traverse(root.right, res, depth);
        traverse(root.left, res, depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
