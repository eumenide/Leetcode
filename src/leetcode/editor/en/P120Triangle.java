//Given a triangle array, return the minimum path sum from top to bottom. 
//
// For each step, you may move to an adjacent number of the row below. More 
//formally, if you are on index i on the current row, you may move to either index i 
//or index i + 1 on the next row. 
//
// 
// Example 1: 
//
// 
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined 
//above).
// 
//
// Example 2: 
//
// 
//Input: triangle = [[-10]]
//Output: -10
// 
//
// 
// Constraints: 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//Follow up: Could you do this using only O(n) extra space, where n is the 
//total number of rows in the triangle? Related Topics Array Dynamic Programming 👍 592
//4 👎 408


package leetcode.editor.en;

import java.util.List;
import java.util.Scanner;

/**
 * Triangle
 * 
 * @author: eumes
 * @date: 2022-06-14 00:17:43
 */
 public class P120Triangle {
    public static void main(String[] args) {
//        Solution_P120 solution = new Solution_P120();
        // TO TEST
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String target = in.nextLine();
        char[] chars = new char[2];

        // target字符记录大小写
        chars[0] = target.charAt(0);
        System.out.println(chars[0] >= 'a' && chars[0] <= 'z');
        System.out.println(chars[0] >= 'A' && chars[0] <= 'Z');
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[1] = (char)(chars[0] + 'A' - 'a');
        } else if (chars[0] >= 'A' && chars[0] <= 'Z') {
            chars[1] = (char)(chars[1] + 'a' - 'A');
        }
        System.out.println(chars[0]);
        System.out.println(chars[1]);
        // 遍历寻找
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chars[0] || str.charAt(i) == chars[1]) {
                count++;
            }
        }
        System.out.println(count);
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 自底向上
        int n = triangle.size();
        // dp[i]表示从底部向上累加，第i列的最小路径和
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                // 从下面一行的第j或j+1列得到
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }

        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
