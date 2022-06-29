//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Dynamic Programming Matrix 👍 2527 👎 95


package leetcode.editor.en;

/**
 * Minimum Falling Path Sum
 * 
 * @author: eumes
 * @date: 2022-06-25 18:40:34
 */
 public class P931MinimumFallingPathSum {
    public static void main(String[] args) {
//        Solution_P931 solution = new Solution_P931();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P931 {
    public int minFallingPathSum(int[][] matrix) {
        // 由题意得到的最大值
        int max = 10001;
        // dp[i][j]表示落到i,j-1位置时的最小路径和
        int m = matrix.length, n = matrix[0].length;
        // 增加左右边界，防止处理越界问题
        int[][] dp = new int[m][n + 2];

        // base case，第一行、第一列、最后一列
        for (int j = 0; j < n; j++) {
            dp[0][j + 1] = matrix[0][j];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = max;
            dp[i][n + 1] = max;
        }

        // 推算dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j - 1];
            }
        }

        // 结果为最后一行的最小值
        int res = max;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
