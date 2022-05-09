//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking 👍 10285 👎 684


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * 
 * @author: eumes
 * @date: 2022-05-09 23:15:22
 */
 public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
//        Solution_P17 solution = new Solution_P17();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P17 {

    String[] maps = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }

        StringBuilder builder = new StringBuilder();
        backTrace(digits, 0, builder);
        return list;
    }

    private void backTrace(String digits, int start, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            list.add(builder.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            for (char ch : maps[digits.charAt(i) - '0'].toCharArray()) {
                builder.append(ch);

                backTrace(digits, i + 1, builder);

                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
