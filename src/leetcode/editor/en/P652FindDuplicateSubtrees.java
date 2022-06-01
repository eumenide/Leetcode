//Given the root of a binary tree, return all duplicate subtrees. 
//
// For each kind of duplicate subtrees, you only need to return the root node 
//of any one of them. 
//
// Two trees are duplicate if they have the same structure with the same node 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree will be in the range [1, 10^4] 
// -200 <= Node.val <= 200 
// 
// Related Topics Hash Table Tree Depth-First Search Binary Tree 👍 3277 👎 301


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Duplicate Subtrees
 * 
 * @author: eumes
 * @date: 2022-05-31 00:39:02
 */
 public class P652FindDuplicateSubtrees {
    public static void main(String[] args) {
//        Solution_P652 solution = new Solution_P652();
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
class Solution_P652 {
    public static final String SEP = ",";
    public static final String NULL = "#";
    Map<String, Integer> freqMap;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        freqMap = new HashMap<>();
        res = new ArrayList<>();
        traverse(root);

        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return NULL;
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String struc = left + SEP + right + SEP + root.val;

        Integer freq = freqMap.getOrDefault(struc, 1);
        if (freq == 2) {
            res.add(root);
        }
        freqMap.put(struc, freq + 1);

        return struc;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
