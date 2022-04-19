//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
// Related Topics Two Pointers String 👍 3014 👎 3857


package leetcode.editor.en;

/**
 * Reverse Words in a String
 * 
 * @author: eumes
 * @date: 2022-04-20 00:41:45
 */
 public class P151ReverseWordsInAString {
    public static void main(String[] args) {
//        Solution_P151 solution = new Solution_P151();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        // 翻转字符串
        reverse(chars, start, end);

        // 记录字符串实际末尾
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            // 空格，跳过
            if (chars[i] == ' ') {
                continue;
            }

            start = k;
            // 找到单词结尾，同时左移
            while (i < chars.length && chars[i] != ' ') {
                chars[k++] = chars[i++];
            }
            end = k - 1;

            // 翻转单词
            reverse(chars, start, end);
            if (i < chars.length) {
                chars[k++] = chars[i];
            }
        }

        return String.valueOf(chars, 0, chars[k - 1] == ' ' ? k - 1 : k);
    }

    public void reverse(char[] chars, int le, int ri) {
        while (le < ri) {
            chars[le] ^= chars[ri];
            chars[ri] ^= chars[le];
            chars[le++] ^= chars[ri--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
