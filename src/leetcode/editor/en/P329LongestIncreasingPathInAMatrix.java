//Given an m x n integers matrix, return the length of the longest increasing 
//path in matrix. 
//
// From each cell, you can either move in four directions: left, right, up, or 
//down. You may not move diagonally or move outside the boundary (i.e., wrap-
//around is not allowed). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
//
// 
//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally 
//is not allowed.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
// Related Topics Dynamic Programming Depth-First Search Breadth-First Search 
//Graph Topological Sort Memoization 👍 5858 👎 96


package leetcode.editor.en;

/**
 * Longest Increasing Path in a Matrix
 * 
 * @author: eumes
 * @date: 2022-05-19 22:09:03
 */
 public class P329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
//        Solution_P329 solution = new Solution_P329();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P329 {

    // 四个方向
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) {
            return 1;
        }

        int res = 1;
        int[][] memo = new int[m][n];
        // 以每个节点为起点，进行dfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, memo, i, j, m, n));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] memo, int i, int j, int m, int n) {
        if (memo[i][j] != 0) {
            // 已访问过
            return memo[i][j];
        }

        // 四个方向进行dfs
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] > matrix[x][y]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, memo, x, y, m, n));
            }
        }

        return ++memo[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
