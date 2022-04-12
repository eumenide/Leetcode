//According to Wikipedia's article: "The Game of Life, also known simply as 
//Life, is a cellular automaton devised by the British mathematician John Horton 
//Conway in 1970." 
//
// The board is made up of an m x n grid of cells, where each cell has an 
//initial state: live (represented by a 1) or dead (represented by a 0). Each cell 
//interacts with its eight neighbors (horizontal, vertical, diagonal) using the 
//following four rules (taken from the above Wikipedia article): 
//
// 
// Any live cell with fewer than two live neighbors dies as if caused by under-
//population. 
// Any live cell with two or three live neighbors lives on to the next 
//generation. 
// Any live cell with more than three live neighbors dies, as if by over-
//population. 
// Any dead cell with exactly three live neighbors becomes a live cell, as if 
//by reproduction. 
// 
//
// The next state is created by applying the above rules simultaneously to 
//every cell in the current state, where births and deaths occur simultaneously. Given 
//the current state of the m x n grid board, return the next state. 
//
// 
// Example 1: 
//
// 
//Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
//Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// 
//
// Example 2: 
//
// 
//Input: board = [[1,1],[1,0]]
//Output: [[1,1],[1,1]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 25 
// board[i][j] is 0 or 1. 
// 
//
// 
// Follow up: 
//
// 
// Could you solve it in-place? Remember that the board needs to be updated 
//simultaneously: You cannot update some cells first and then use their updated 
//values to update other cells. 
// In this question, we represent the board using a 2D array. In principle, the 
//board is infinite, which would cause problems when the active area encroaches 
//upon the border of the array (i.e., live cells reach the border). How would you 
//address these problems? 
// 
// Related Topics Array Matrix Simulation 👍 4347 👎 421


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-12 22:53:16
 * @title: Game of Life
 */
public class P289GameOfLife {
    
    public static void main(String[] args) {
        Solution_289 solution = new Solution_289();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_289 {
    public void gameOfLife(int[][] board) {
        // 通过2个bit表示4种状态，第一位表示next状态，第二位表示current状态
        // 00 : 0,  dead -> dead
        // 01 : 1,  live -> dead
        // 10 : 2,  dead -> live
        // 11 : 3,  live -> live
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 求邻居和
                int lives = countLives(board, i, j, rows, cols);
                // 由于只变化一次，因此只需考虑两种变化
                // 节点初始值只会有两种 00 和 01
                // 00 -> 00 : 不需变动
                // 00 -> 10 : dead -> live
                // 01 -> 11 : live -> live
                // 01 -> 01 : 不需变动
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int countLives(int[][] board, int row, int col, int m, int n) {
        int lives = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(m - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(n - 1, col + 1); j++) {
                lives += board[i][j] & 1;
            }
        }

        return lives - (board[row][col] & 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
