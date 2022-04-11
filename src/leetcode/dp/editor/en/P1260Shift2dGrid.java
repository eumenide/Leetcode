//Given a 2D grid of size m x n and an integer k. You need to shift the grid k 
//times. 
//
// In one shift operation: 
//
// 
// Element at grid[i][j] moves to grid[i][j + 1]. 
// Element at grid[i][n - 1] moves to grid[i + 1][0]. 
// Element at grid[m - 1][n - 1] moves to grid[0][0]. 
// 
//
// Return the 2D grid after applying shift operation k times. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//Output: [[9,1,2],[3,4,5],[6,7,8]]
// 
//
// Example 2: 
//
// 
//Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
//Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
//Output: [[1,2,3],[4,5,6],[7,8,9]]
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 50 
// 1 <= n <= 50 
// -1000 <= grid[i][j] <= 1000 
// 0 <= k <= 100 
// 
// Related Topics Array Matrix Simulation 👍 1078 👎 251


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: eumes
 * @date: 2022-04-11 22:57:21
 * @title: Shift 2D Grid
 */
public class P1260Shift2dGrid {
    
    public static void main(String[] args) {
        Solution_1260 solution = new Solution_1260();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 数组打平后，grid[i]对应原来的 grid[(i/n)%m][i%n]
        // 数组移动k次后，grid[i] 应变成 grid[(i+k)%mn]
        List<List<Integer>> res = new ArrayList<>();
        int cols = grid[0].length, rows = grid.length;
        int len = cols * rows;
        k %= len;
        // 新数组的起始位置，对应原数组的
        int begin = len - k;
        for (int i = begin, idx = -1; i < begin + len; i++) {
            int c = (i / cols) % rows;
            int r = i % cols;
            if ((i - begin) % cols == 0) {
                // 表示新的一行
                res.add(new ArrayList<>());
                idx++;
            }
            res.get(idx).add(grid[c][r]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
