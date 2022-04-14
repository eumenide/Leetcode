//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
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
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 👍 2691 👎 166


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-11 23:45:48
 * @title: Spiral Matrix II
 */
public class P59SpiralMatrixIi {
    
    public static void main(String[] args) {
        Solution_59 solution = new Solution_59();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_59 {
    public int[][] generateMatrix(int n) {
        // 模拟每一边
        int[][] res = new int[n][n];
        // 每次循环起始位置 & 偏移量
        int startX = 0, startY = 0;
        int offset = 1;
        // 循环次数为n/2
        int loop = n / 2;
        int num = 1;

        while (loop-- > 0) {
            int i = startX, j = startY;
            // 上面 从左往右 填充第i行每一列 [i, n - offset)
            for (; j < n - offset; j++) {
                res[i][j] = num++;
            }
            // 右面 从上往下 填充第 n-offset 列每一行 [i, n - offset)
            for (; i < n - offset; i++) {
                res[i][j] = num++;
            }
            // 下面 从右往左 填充第 n-offset行 每一列[n - offset, i)
            for (; j > startY; j--) {
                res[i][j] = num++;
            }
            // 左面 从下往上 填充第i列 每一行 [n - offset, i)
            for (; i > startX; i--) {
                res[i][j] = num++;
            }

            startX++;
            startY++;
            offset++;
        }

        // 奇数，需要给最中间单独赋值
        if (n % 2 != 0) {
            res[n / 2][n / 2] = num;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
