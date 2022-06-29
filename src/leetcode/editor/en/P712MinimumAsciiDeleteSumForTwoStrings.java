//Given two strings s1 and s2, return the lowest ASCII sum of deleted 
//characters to make two strings equal. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the 
//sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum 
//possible to achieve this.
// 
//
// Example 2: 
//
// 
//Input: s1 = "delete", s2 = "leet"
//Output: 403
//Explanation: Deleting "dee" from "delete" to turn the string into "let",
//adds 100[d] + 101[e] + 101[e] to the sum.
//Deleting "e" from "leet" adds 101[e] to the sum.
//At the end, both strings are equal to "let", and the answer is 100+101+101+101
// = 403.
//If instead we turned both strings into "lee" or "eet", we would get answers 
//of 433 or 417, which are higher.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 👍 2042 👎 66


package leetcode.editor.en;

/**
 * Minimum ASCII Delete Sum for Two Strings
 * 
 * @author: eumes
 * @date: 2022-06-30 00:29:56
 */
 public class P712MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
//        Solution_P712 solution = new Solution_P712();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P712 {
    // 最长公共子串：这里是需要计算不同(需要删除)的最少字符
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // dp[i+1][j+1]表示s1[0..i]与s2[0..j]的最小删除字符ASCII和
        int[][] dp = new int[m + 1][n + 1];
        // base case : 第一行 -- s1为空串时，需要删除整个s2
            // 第一列 -- s2为空串时，需要删除整个s1
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // 更新dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 相等，则不需要删除
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则，取删除s1或s2最小的
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1),
                            dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
