//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Binary Search Divide and Conquer Matrix 👍 7022 👎 121


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-31 00:03:11
 * @title: Search a 2D Matrix II
 */
public class P240SearchA2dMatrixIi {
    
    public static void main(String[] args) {
        Solution_240 solution = new Solution_240();
        // TO TEST
        int[][] matrix = new int[][] {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println(solution.searchMatrix(matrix, 5));
        System.out.println(solution.searchMatrix(matrix, 20));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 对于 [i,j]，须知[i,j] < [i+1,j], [i,j] < [i,j+1] < [i+1,j+1]

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
