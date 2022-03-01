//You are given two strings s and t. 
//
// String t is generated by random shuffling string s and then add one more 
//letter at a random position. 
//
// Return the letter that was added to t. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", t = "abcde"
//Output: "e"
//Explanation: 'e' is the letter that was added.
// 
//
// Example 2: 
//
// 
//Input: s = "", t = "y"
//Output: "y"
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s and t consist of lowercase English letters. 
// 
// Related Topics Hash Table String Bit Manipulation Sorting 👍 1918 👎 349


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-02-07 11:23:16
 * @title: Find the Difference
 */
public class P389FindTheDifference {
    
    public static void main(String[] args) {

        System.out.println('a' ^ 'a');
        System.out.println('a' ^ 'b');
        System.out.println('a' ^ 'b' ^ 'a');
        System.out.println(' ' ^ 'a');
        System.out.println('a' - 0);
        Solution_389 solution = new Solution_389();
        // TO TEST
        String s = "abcd";
        String t = "adceb";
        System.out.println(solution.findTheDifference(s, t));

        s = "";
        t = "y";
        System.out.println(solution.findTheDifference(s, t));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_389 {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        for (char c : s.toCharArray()) {
            result ^= c;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
