//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the 
//input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array Math Matrix 👍 9058 👎 481


package leetcode.editor.en;

/**
 * Rotate Image
 * 
 * @author: eumes
 * @date: 2022-05-08 01:45:42
 */
 public class P48RotateImage {
    public static void main(String[] args) {
//        Solution_P48 solution = new Solution_P48();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 按对角线镜像
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }

        // 每行reverse
        for (int i = 0; i < n; i++) {
            int le = 0, ri = n - 1;
            while (le < ri) {
                matrix[i][le] ^= matrix[i][ri];
                matrix[i][ri] ^= matrix[i][le];
                matrix[i][le++] ^= matrix[i][ri--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
