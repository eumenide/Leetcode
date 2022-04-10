//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics Hash Table String Sliding Window 👍 9910 👎 529


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-11 00:43:47
 * @title: Minimum Window Substring
 */
public class P76MinimumWindowSubstring {
    
    public static void main(String[] args) {
        Solution_76 solution = new Solution_76();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_76 {
    public String minWindow(String s, String t) {
        // 存储子串t中的字符 & 频率
        int[] freq = new int[256];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        // 双指针
        int left = 0, right = 0;
        int len = s.length() + 1, head = 0;
        int count = t.length();
        while (right < s.length()) {
            // 往右移动右指针，直到窗口中可容纳字符t
            if (freq[s.charAt(right++)]-- > 0) {
                count--;
            }
            // 当count==0时，表示窗口可容纳字符t
            while (count == 0) {
                // 如果窗口长度小于最小长度，则更新
                if (right - left < len) {
                    len = right - left;
                    head = left;
                }
                // 移动左指针，直到刚好不能容纳字符t
                if (freq[s.charAt(left++)]++ == 0) {
                    count++;
                }
            }
        }

        // 如果最小长度len未变，表示没有找到字符
        return len > s.length() ? "" : s.substring(head, head + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
