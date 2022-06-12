//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return the number of distinct solutions to the n-queens 
//puzzle. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
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
// 1 <= n <= 9 
// 
// Related Topics Backtracking 👍 2314 👎 221


package leetcode.editor.en;

/**
 * N-Queens II
 * 
 * @author: eumes
 * @date: 2022-06-05 23:52:46
 */
 public class P52NQueensIi {
    public static void main(String[] args) {
//        Solution_P52 solution = new Solution_P52();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P52 {
    int count;
    public int totalNQueens(int n) {
        count = 0;
        // 记录第i列是否已有Q
        boolean[] up = new boolean[n];
        // 记录左上方向是否已有Q，其中下标为 i - j，因为i-j为固定值
        boolean[] leftUp = new boolean[n * 2];
        // 记录右上方向是否已有Q，其中下标为 i + j，因为 i + j为固定值
        boolean[] rightUp = new boolean[n * 2];

        backtrace(0, n, up, leftUp, rightUp);
        return count;
    }

    private void backtrace(int row, int n, boolean[] up, boolean[] leftUp, boolean[] rightUp) {
        if (row == n) {
            count++;
            return;
        }

        // 选择第i列
        for (int i = 0; i < n; i++) {
            // +n是为了消除负数
            int lu = row - i + n;
            int ru = row + i;
            // 如果三个方向上已有Q，则继续
            if (up[i] || leftUp[lu] || rightUp[ru]) {
                continue;
            }

            // 选择第i列放置Q
            up[i] = true;
            leftUp[lu] = true;
            rightUp[ru] = true;
            backtrace(row + 1, n, up, leftUp, rightUp);

            // 撤销选择
            up[i] = false;
            leftUp[lu] = false;
            rightUp[ru] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
