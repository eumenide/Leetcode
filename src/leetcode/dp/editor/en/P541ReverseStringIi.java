//Given a string s and an integer k, reverse the first k characters for every 2
//k characters counting from the start of the string. 
//
// If there are fewer than k characters left, reverse all of them. If there are 
//less than 2k but greater than or equal to k characters, then reverse the first 
//k characters and leave the other as original. 
//
// 
// Example 1: 
// Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// Example 2: 
// Input: s = "abcd", k = 2
//Output: "bacd"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only lowercase English letters. 
// 1 <= k <= 10⁴ 
// 
// Related Topics Two Pointers String 👍 932 👎 2327


package leetcode.dp.editor.en;

import java.util.Arrays;

/**
 * @author: eumes
 * @date: 2022-04-01 23:11:30
 * @title: Reverse String II
 */
public class P541ReverseStringIi {
    
    public static void main(String[] args) {
        Solution_541 solution = new Solution_541();
        // TO TEST
        String s = "abcdefg";
        int k = 2;
        System.out.println(solution.reverseStr(s, k));

        s = "abcd";
        System.out.println(solution.reverseStr(s, k));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_541 {

    private void swap(char[] chars, int left, int right) {
        while (left < right) {
            char ch = chars[left];
            chars[left++] = chars[right];
            chars[right--] = ch;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0, n = s.length();
        while (left < n) {
            int right = Math.min(left + k - 1, n);
            swap(chars, left, right);
            left += 2 * k;
        }
        return String.valueOf(chars);

        //// left = 0, 每次reverse [left, min(left + k - 1, len - 1)]  -> left + 2k
        //int left = 0, right = left + k - 1;
        //char[] chars = new char[s.length()];
        //for (int i = 0; i < s.length();) {
        //    for (int j = right; j >= left; j--) {
        //        chars[i++] = s.charAt(j);
        //    }
        //    left = right + 1;
        //    right = left + k;
        //    for (int j = left; j < right && j < s.length(); j++) {
        //        chars[i++] = s.charAt(j);
        //    }
        //    left = right;
        //    right = left + k - 1;
        //}
        //
        //return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
