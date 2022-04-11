//Given an m x n matrix, return all elements of the matrix in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 👍 6757 👎 820


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: eumes
 * @date: 2022-04-12 00:24:01
 * @title: Spiral Matrix
 */
public class P54SpiralMatrix {
    
    public static void main(String[] args) {
        Solution_54 solution = new Solution_54();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 上下左右边界值
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (true) {
            // 上面 从左往右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            // 右面 从上往下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            // 下面 从右往左
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            // 左面 从下往上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
