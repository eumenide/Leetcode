//Given a string s, reverse the order of characters in each word within a 
//sentence while still preserving whitespace and initial word order. 
//
// 
// Example 1: 
// Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// Example 2: 
// Input: s = "God Ding"
//Output: "doG gniD"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s contains printable ASCII characters. 
// s does not contain any leading or trailing spaces. 
// There is at least one word in s. 
// All the words in s are separated by a single space. 
// 
// Related Topics Two Pointers String 👍 2638 👎 156


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-01 23:32:14
 * @title: Reverse Words in a String III
 */
public class P557ReverseWordsInAStringIii {
    
    public static void main(String[] args) {
        Solution_557 solution = new Solution_557();
        // TO TEST
        String s = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s));

        s = "God Ding";
        System.out.println(solution.reverseWords(s));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (chars[j] == ' ') {
                swap(chars, i, j - 1);
                i = j + 1;
            }
        }
        swap(chars, i, s.length() - 1);
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        while (i < j) {
            char ch = chars[i];
            chars[i++] = chars[j];
            chars[j--] = ch;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
