//Implement strStr(). 
//
// Given two strings needle and haystack, return the index of the first 
//occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great 
//question to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty 
//string. This is consistent to C's strstr() and Java's indexOf(). 
//
// 
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack and needle consist of only lowercase English characters. 
// 
// Related Topics Two Pointers String String Matching 👍 3885 👎 3597


package leetcode.editor.en;

/**
 * Implement strStr()
 * 
 * @author: eumes
 * @date: 2022-04-21 00:35:48
 */
 public class P28ImplementStrstr {
    public static void main(String[] args) {
//        Solution_P28 solution = new Solution_P28();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P28 {
    public int strStr(String haystack, String needle) {
        // 暴力
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int idx = 0;
            while (idx < needle.length() && haystack.charAt(idx + i) == needle.charAt(idx)) {
                idx++;
            }
            if (idx == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
