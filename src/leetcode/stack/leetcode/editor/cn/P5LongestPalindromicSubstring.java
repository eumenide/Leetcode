//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// 
// Related Topics 字符串 动态规划 
// 👍 3870 👎 0


package leetcode.stack.leetcode.editor.cn;

/**
 * @author: eumes
 * @date: 2021-07-27 01:02:34
 * @title: Longest Palindromic Substring
 */
public class P5LongestPalindromicSubstring {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        String s = "babad";
        // bab  / aba
        System.out.println(solution.longestPalindrome(s));

        // bb
        s = "cbbd";
        System.out.println(solution.longestPalindrome(s));

        // a
        s = "a";
        System.out.println(solution.longestPalindrome(s));

        // a
        s = "ac";
        System.out.println(solution.longestPalindrome(s));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
