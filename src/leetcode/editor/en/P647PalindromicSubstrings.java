//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 👍 6876 👎 158


package leetcode.editor.en;

/**
 * Palindromic Substrings
 * 
 * @author: eumes
 * @date: 2022-05-22 23:08:17
 */
 public class P647PalindromicSubstrings {
    public static void main(String[] args) {
//        Solution_P647 solution = new Solution_P647();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P647 {
    public int countSubstrings_center(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalidrome(s, i, i);

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count += countPalidrome(s, i, i + 1);
            }
        }

        return count;
    }

    /**
     * 计算以le,ri为中心的回文子串数量
     *
     * @param s
     * @param le
     * @param ri
     * @return
     */
    private int countPalidrome(String s, int le, int ri) {
        int count = 0;
        while (le >= 0 && ri < s.length() && s.charAt(le) == s.charAt(ri)) {
            le--;
            ri++;
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
