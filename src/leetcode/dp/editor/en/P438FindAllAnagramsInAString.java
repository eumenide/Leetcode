//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
// Related Topics Hash Table String Sliding Window 👍 7285 👎 251


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Anagrams in a String
 * 
 * @author: eumes
 * @date: 2022-04-16 23:25:51
 */
 public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution_P438 solution = new Solution_P438();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (char ch : p.toCharArray()) {
            freq[ch - 'a']++;
        }

        // 窗口大小为p的长度
        int left = 0, right = 0, count = p.length();
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a']-- > 0) {
                // 表示right满足了p的一个元素
                count--;
            }
            // 右指针右移
            right++;
            // 表示，此时窗口刚好满足p
            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length()) {
                // 大于=0，表示在p中存在，否则在右指针访问时，会变成负数
                if (freq[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                // 窗口比p长1，左指针左移
                left++;
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
