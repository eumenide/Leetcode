//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 23437 👎 1053


package leetcode.editor.en;

/**
 * Longest Substring Without Repeating Characters
 * 
 * @author: eumes
 * @date: 2022-05-09 00:35:42
 */
 public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        Solution_P3 solution = new Solution_P3();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 这里记录窗口中每个字符出现的最后一个位置
        int[] freq = new int[128];
        int le = 0, ri = 0;
        int res = 0;

        while (ri < s.length()) {
            if (freq[s.charAt(ri)] > 0) {
                // 如果右指针出现过，则左指针直接移到最大位置
                le = Math.max(le, freq[s.charAt(ri)]);
            }

            // 更新s[ri]出现的最新位置
            freq[s.charAt(ri)] = ++ri;
            res = Math.max(res, ri - le);
        }

        return res;
    }

    public int lengthOfLongestSubstring_1(String s) {
        // 这里记录窗口中每个字符出现的频率
        int[] freq = new int[128];
        int le = 0, ri = 0;

        int res = 0;
        while (ri < s.length()) {
            freq[s.charAt(ri)]++;
            while (freq[s.charAt(ri)] > 1) {
                // 有重复
                freq[s.charAt(le++)]--;
            }

            ri++;
            res = Math.max(res, ri - le);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
