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
// Related Topics Hash Table String Sliding Window 
// 👍 15372 👎 772


package leetcode.stack.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: eumes
 * @date: 2021-06-30 20:51:47
 * @title: Longest Substring Without Repeating Characters
 */
public class P3LongestSubstringWithoutRepeatingCharactersEn {
    
    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        // TO TEST
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";

        System.out.println(solution.lengthOfLongestSubstring2(s1) == 3);
        //System.out.println(solution.lengthOfLongestSubstring(s2) == 1);
        //System.out.println(solution.lengthOfLongestSubstring(s3) == 3);
        //System.out.println(solution.lengthOfLongestSubstring(s4) == 0);

        System.out.println(solution.lengthOfLongestSubstring("abba"));

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

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = 0;
        int[] arr = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (arr[s.charAt(j)] > 0) {
                i = Math.max(i, arr[s.charAt(j)] + 1);
            }
            arr[s.charAt(j)] = j + 1;
            len = Math.max(len, j - i + 1);
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
