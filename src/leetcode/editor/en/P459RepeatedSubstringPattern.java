//Given a string s, check if it can be constructed by taking a substring of it 
//and appending multiple copies of the substring together. 
//
// 
// Example 1: 
//
// 
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
// 
//
// Example 2: 
//
// 
//Input: s = "aba"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" 
//twice.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
// Related Topics String String Matching 👍 3273 👎 313


package leetcode.editor.en;

/**
 * Repeated Substring Pattern
 * 
 * @author: eumes
 * @date: 2022-04-21 00:41:41
 */
 public class P459RepeatedSubstringPattern {
    public static void main(String[] args) {
//        Solution_P459 solution = new Solution_P459();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // 每段长度
        for (int i = len / 2; i >= 1; i++) {
            if (len % i == 0) {
                int m = len / i;
                String first = s.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!first.equals(s.substring(j * i, j * i + i))) {
                        break;
                    }
                }
                if (j == m) {
                    return true;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
