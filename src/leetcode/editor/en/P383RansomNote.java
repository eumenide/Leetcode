//Given two strings ransomNote and magazine, return true if ransomNote can be 
//constructed from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
// Related Topics Hash Table String Counting 👍 1646 👎 297


package leetcode.editor.en;

/**
 * Ransom Note
 * 
 * @author: eumes
 * @date: 2022-04-18 01:44:10
 */
 public class P383RansomNote {
    public static void main(String[] args) {
//        Solution_P383 solution = new Solution_P383();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
//            freq[ch - 'a']--;
            if (--freq[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
