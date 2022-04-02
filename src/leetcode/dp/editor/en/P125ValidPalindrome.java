//A phrase is a palindrome if, after converting all uppercase letters into 
//lowercase letters and removing all non-alphanumeric characters, it reads the same 
//forward and backward. Alphanumeric characters include letters and numbers. 
//
// Given a string s, return true if it is a palindrome, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
// 
//
// Example 2: 
//
// 
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric 
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s consists only of printable ASCII characters. 
// 
// Related Topics Two Pointers String 👍 3371 👎 5023


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-02 21:58:59
 * @title: Valid Palindrome
 */
public class P125ValidPalindrome {
    
    public static void main(String[] args) {
        Solution_125 solution = new Solution_125();
        // TO TEST
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));

        s = "race a car";
        System.out.println(solution.isPalindrome(s));

        s = " ";
        System.out.println(solution.isPalindrome(s));

        s = ".,";
        System.out.println(solution.isPalindrome(s));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, n = s.length(), right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !isAlphanumeric(chars[left])) {
                left++;
            }
            while (!isAlphanumeric(chars[right]) && right > left) {
                right--;
            }
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
