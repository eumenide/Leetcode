//You are a hiker preparing for an upcoming hike. You are given heights, a 2D 
//array of size rows x columns, where heights[row][col] represents the height of 
//cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to 
//travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can 
//move up, down, left, or right, and you wish to find a route that requires the 
//minimum effort. 
//
// A route's effort is the maximum absolute difference in heights between two 
//consecutive cells of the route. 
//
// Return the minimum effort required to travel from the top-left cell to the 
//bottom-right cell. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//Output: 2
//Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 
//in consecutive cells.
//This is better than the route of [1,2,2,2,5], where the maximum absolute 
//difference is 3.
// 
//
// Example 2: 
//
// 
//
// 
//Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//Output: 1
//Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 
//in consecutive cells, which is better than route [1,3,5,3,5].
// 
//
// Example 3: 
//
// 
//Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
//Output: 0
//Explanation: This route does not require any effort.
// 
//
// 
// Constraints: 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// Related Topics Array Binary Search Depth-First Search Breadth-First Search 
//Union Find Heap (Priority Queue) Matrix 👍 2780 👎 116


package leetcode.editor.en;

import java.util.*;

/**
 * Path With Minimum Effort
 * 
 * @author: eumes
 * @date: 2022-04-29 00:48:23
 */
 public class P1631PathWithMinimumEffort {
    public static void main(String[] args) {
//        Solution_P1631 solution = new Solution_P1631();
        // TO TEST
        Deque<Integer> integerDeque = new ArrayDeque<>();
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1631 {

    // bfs
    public int minimumEffortPath(int[][] heights) {
        // 上下左右方向
        int[][] dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        int rows = heights.length, cols = heights[0].length;
        // 记录每个到达该点时 最小effort
        int[][] visited = new int[rows][cols];
        for (int[] v : visited) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        // 优先队列，按小到大顺序存储 点 及达到它的 最小 effort
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = 0;

        // 遍历每个点，并依次检查其上下左右4个点且计算effort
        while (!queue.isEmpty()) {
            // 当前effort最小的
            int[] c = queue.poll();
            if (c[0] == rows - 1 && c[1] == cols - 1) {
                return c[2];
            }
            // 如果当前点 queue中的effort 比visited中的effort大，说明该点有effort更小的到达方式；直接跳过
            if (c[2] > visited[c[0]][c[1]]) {
                continue;
            }

            // 由该点出发，继续达到上下左右
            for (int[] dir : dirs) {
                int x = dir[0] + c[0];
                int y = dir[1] + c[1];

                // 超出范围，跳过
                if (x < 0 ||x >= rows || y < 0 || y >= cols) {
                    continue;
                }

                // effort应为 差值 与 达到当前点 effort的最大值
                int effort = Math.max(c[2], Math.abs(heights[x][y] - heights[c[0]][c[1]]));
                // 当effort比x,y已有的小，表示更优 才更新；否则保持原来的
                if (effort < visited[x][y]) {
                    visited[x][y] = effort;
                    queue.offer(new int[]{x, y, effort});
                }
            }
        }

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
