//Given an n x n binary matrix grid, return the length of the shortest clear 
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
// Related Topics Array Breadth-First Search Matrix 👍 3130 👎 141


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Path in Binary Matrix
 * 
 * @author: eumes
 * @date: 2022-05-16 22:56:57
 */
 public class P1091ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
//        Solution_P1091 solution = new Solution_P1091();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        // 记录每层节点，x,y到0,0的距离
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                int dis = poll[2];
                // 已到达
                if (x == m - 1 && y == n - 1) {
                    return dis;
                }

                for (int[] dir : dirs) {
                    int i = dir[0] + x;
                    int j = dir[1] + y;
                    if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 0) {
                        queue.offer(new int[]{i, j, dis + 1});
                        grid[i][j] = 1;
                    }
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
