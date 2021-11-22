//Given a string s, find the length of the longest substring without repeating c
//haracters. 
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
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5809 👎 0


package leetcode.stack.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: eumes
 * @date: 2021-07-27 00:36:59
 * @title: Longest Substring Without Repeating Characters
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        Solution_4 solution4 = new Solution_4();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
