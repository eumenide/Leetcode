//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 18757 👎 1091


package leetcode.editor.en;

/**
 * Longest Palindromic Substring
 * 
 * @author: eumes
 * @date: 2022-06-16 22:14:14
 */
 public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
//        Solution_P5 solution = new Solution_P5();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数个
            String ji = palindrome(s, i, i);
            // 偶数个
            String ou = palindrome(s, i, i + 1);

            res = res.length() >= ji.length() ? res : ji;
            res = res.length() >= ou.length() ? res : ou;
        }

        return res;
    }

    // 获取以[le, ri]为中心的回文字符串
    private String palindrome(String s, int le, int ri) {
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) {
            le--;
            ri++;
        }

        return s.substring(le + 1, ri);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
