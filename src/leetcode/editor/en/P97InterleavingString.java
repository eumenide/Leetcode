//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of 
//s1 and s2. 
//
// An interleaving of two strings s and t is a configuration where they are 
//divided into non-empty substrings such that: 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + 
//t3 + s3 + ... 
// 
//
// Note: a + b is the concatenation of strings a and b. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s1 = "", s2 = "", s3 = ""
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1, s2, and s3 consist of lowercase English letters. 
// 
//
// 
// Follow up: Could you solve it using only O(s2.length) additional memory 
//space? 
// Related Topics String Dynamic Programming 👍 5058 👎 296


package leetcode.editor.en;

/**
 * Interleaving String
 * 
 * @author: eumes
 * @date: 2022-07-08 00:06:55
 */
 public class P97InterleavingString {
    public static void main(String[] args) {
//        Solution_P97 solution = new Solution_P97();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P97 {

    // 压缩一维dp
    public boolean isInterleave(String s1, String s2, String s3) {
        // 数量不相等
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }

        return dp[n];
    }

    // 二维dp
    public boolean isInterleave_dp2(String s1, String s2, String s3) {
        // 数量不相等
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length(), n = s2.length();
        // dp[i][j]表示s1[0..i-1]与s2[0..j-1]能否满足s3[0..i+j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        // base case
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // dp更新
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[m][n];
    }

    // dfs
    public boolean isInterleave_dfs(String s1, String s2, String s3) {
        // 数量不相等
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0, 0, new boolean[s1.length() + 1][s2.length() + 1]);
    }

    // s1的[0..i]与s2的[0..j]是否满足构成s3的[0..k]，其中invalid[i][j]为备忘录
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) {
            return false;
        }
        if (k == s3.length()) {
            return true;
        }

        // s1右移或s2右移，分别递归
        boolean isvalid = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, invalid)
                || j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, invalid);

        // 更新备忘录
        invalid[i][j] = !isvalid;
        return isvalid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
