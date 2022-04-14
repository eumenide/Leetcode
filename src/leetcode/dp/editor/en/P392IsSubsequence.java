//Given two strings s and t, return true if s is a subsequence of t, or false 
//otherwise. 
//
// A subsequence of a string is a new string that is formed from the original 
//string by deleting some (can be none) of the characters without disturbing the 
//relative positions of the remaining characters. (i.e., "ace" is a subsequence of 
//"abcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10⁴ 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >
//= 10⁹, and you want to check one by one to see if t has its subsequence. In 
//this scenario, how would you change your code? Related Topics Two Pointers String 
//Dynamic Programming 👍 3743 👎 269


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:36
 * @title: Is Subsequence
 */
public class P392IsSubsequence {
    
    public static void main(String[] args) {
        Solution_392 solution = new Solution_392();
        // TO TEST
        String s = "abc", t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        System.out.println(solution.isSubsequence(s, t));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            }
            while (j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }
        }

        return i == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
