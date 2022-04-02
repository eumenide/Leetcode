//Given a string s, return true if the s can be palindrome after deleting at 
//most one character from it. 
//
// 
// Example 1: 
//
// 
//Input: s = "aba"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
// 
//
// Example 3: 
//
// 
//Input: s = "abc"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
// Related Topics Two Pointers String Greedy 👍 5035 👎 280


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-02 21:59:03
 * @title: Valid Palindrome II
 */
public class P680ValidPalindromeIi {
    
    public static void main(String[] args) {
        Solution_680 solution = new Solution_680();
        // TO TEST
        String s = "aba";
        System.out.println(solution.validPalindrome(s));

        s = "abca";
        System.out.println(solution.validPalindrome(s));

        s = "abc";
        System.out.println(solution.validPalindrome(s));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while ((left < right) && chars[left] == chars[right]) {
            left++;
            right--;
        }

        return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
