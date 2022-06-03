//Given an integer n, return the number of structurally unique BST's (binary 
//search trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree ?
//? 7303 👎 298


package leetcode.editor.en;

/**
 * Unique Binary Search Trees
 * 
 * @author: eumes
 * @date: 2022-06-04 00:01:40
 */
 public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
//        Solution_P96 solution = new Solution_P96();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P96 {
    // 记录[i, j]之间数字组成的BST个数
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    // 计算[le, ri] 直接数字组成的BST个数
    private int count(int le, int ri) {
        if (le > ri) {
            return 1;
        }
        if (memo[le][ri] != 0) {
            return memo[le][ri];
        }

        int cnt = 0;
        for (int i = le; i <= ri; i++) {
            int left = count(le, i - 1);
            int right = count(i + 1, ri);

            cnt += left * right;
        }
        memo[le][ri] = cnt;
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
