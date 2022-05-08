//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 👍 5820 👎 171


package leetcode.editor.en;

/**
 * Permutation in String
 * 
 * @author: eumes
 * @date: 2022-05-08 22:18:08
 */
 public class P567PermutationInString {
    public static void main(String[] args) {
//        Solution_P567 solution = new Solution_P567();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        int le = 0, ri = 0, count = s1.length();
        while (ri < s2.length()) {
            if (freq[s2.charAt(ri++) - 'a']-- > 0) {
                count--;
            }

            while (count == 0) {
                if (ri - le == s1.length()) {
                    return true;
                }
                if (freq[s2.charAt(le++) - 'a']++ == 0) {
                    count++;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
