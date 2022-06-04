//Given an integer n, return all the structurally unique BST's (binary search 
//trees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics Dynamic Programming Backtracking Tree Binary Search Tree 
//Binary Tree 👍 4786 👎 319


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * 
 * @author: eumes
 * @date: 2022-06-04 00:05:22
 */
 public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
//        Solution_P95 solution = new Solution_P95();
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
class Solution_P95 {
    // 记录[i, j] 之间数字组成的BST
    List<TreeNode>[][] memo;
    public List<TreeNode> generateTrees(int n) {
        memo = new List[n + 1][n + 1];
        return generate(1, n);
    }

    // 构造[le, ri]直接数字组成的BST
    private List<TreeNode> generate(int le, int ri) {
        List<TreeNode> res = new LinkedList<>();
        if (le > ri) {
            res.add(null);
            return res;
        }

        // 先查备忘录
        if (memo[le][ri] != null) {
            return memo[le][ri];
        }

        // 递归构造
        for (int i = le; i <= ri; i++) {
            List<TreeNode> left = generate(le, i - 1);
            List<TreeNode> right = generate(i + 1, ri);

            // 组合构造左右子树
            for (TreeNode leNode : left) {
                for (TreeNode riNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leNode;
                    root.right = riNode;
                    res.add(root);
                }
            }
        }
        memo[le][ri] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
