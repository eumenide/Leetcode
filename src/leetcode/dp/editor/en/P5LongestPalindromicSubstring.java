//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 👍 16475 👎 970


package leetcode.dp.editor.en;

/**
 * 最长回文子串：https://www.cxyxiaowu.com/2869.html
 *
 * @author: eumes
 * @date: 2022-03-13 18:44:02
 * @title: Longest Palindromic Substring
 */
public class P5LongestPalindromicSubstring {
    
    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        // TO TEST
        System.out.println(solution.longestPalindrome_bruce("babad"));
        System.out.println(solution.longestPalindrome_center("babad"));
        System.out.println(solution.longestPalindrome_bruce("cbbd"));
        System.out.println(solution.longestPalindrome_center("cbbd"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_5 {
    public String longestPalindrome_center(String s) {
        // 遍历每个字符，找到以其为中心的的最大回文子串；注意奇偶数
        String res = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            String jishu = centerMax(s, i - 1, i + 1);
            String ouhsu = centerMax(s, i, i + 1);
            jishu = jishu.length() >= ouhsu.length() ? jishu : ouhsu;
            res = jishu.length() >= res.length() ? jishu : res;
        }

        return res;
    }

    public String centerMax(String s, int left, int right) {
        // 以left、right开始，分别向左右扩散，找到最长回文子串
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left + 1, right);
    }

    public String longestPalindrome_bruce(String s) {
        // 枚举每一个长度>2的子串，选取长度最长的回文子串
        int max = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > max && valid(s, i, j)) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public boolean valid(String s, int left, int right) {
        // 验证s[left, right]是否是回文
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
