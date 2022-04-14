//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics Array Binary Search Matrix 👍 6910 👎 260


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-30 23:49:27
 * @title: Search a 2D Matrix
 */
public class P74SearchA2dMatrix {
    
    public static void main(String[] args) {
        Solution_74 solution = new Solution_74();
        // TO TEST
        int[][] matrix = new int[][] {
            {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(solution.searchMatrix(matrix, 3));
        System.out.println(solution.searchMatrix(matrix, 13));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0]) {
            return false;
        }

        // 二分查找，将二维数组打平看成是一个有序一维数组
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                // 在右边
                l = mid + 1;
            } else {
                // 在左边
                r = mid - 1;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
