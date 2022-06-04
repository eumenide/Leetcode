//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Array Backtracking 👍 6703 👎 169


package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N-Queens
 * 
 * @author: eumes
 * @date: 2022-06-05 01:10:29
 */
 public class P51NQueens {
    public static void main(String[] args) {
//        Solution_P51 solution = new Solution_P51();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P51 {

    public List<List<String>> solveNQueens(int n) {
        // 记录棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        // 结果
        List<List<String>> res = new LinkedList<>();
        backtrace(n, 0, res, new LinkedList<>(), board);

        return res;
    }

    // 选择第row行的合法位置放置Q
    private void backtrace(int n, int row, List<List<String>> res, LinkedList<String> trace, char[][] board) {
        if (row == n) {
            // 放置完成
            res.add(new LinkedList<>(trace));
            return;
        }

        // 遍历每一列，选择合法的列放置Q
        for (int i = 0; i < n; i++) {
            if (!isValid(row, i, board)) {
                continue;
            }

            // 第row行第i列放置Q，记录第row行结果；并继续放置下一行
            board[row][i] = 'Q';
            trace.add(new String(board[row]));
            backtrace(n, row + 1, res, trace, board);

            // 撤销放置
            board[row][i] = '.';
            trace.removeLast();
        }
    }

    private boolean isValid(int row, int col, char[][] board) {
        // row上方是否已有
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 左上方向是否已有
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 右上方向是否已有
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
