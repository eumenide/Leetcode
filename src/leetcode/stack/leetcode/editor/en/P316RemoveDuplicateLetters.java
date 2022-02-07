//Given a string s, remove duplicate letters so that every letter appears once 
//and only once. You must make sure your result is the smallest in lexicographical 
//order among all possible results. 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// 
// Note: This question is the same as 1081: https://leetcode.com/problems/
//smallest-subsequence-of-distinct-characters/ 
// Related Topics String Stack Greedy Monotonic Stack 👍 3506 👎 247


package leetcode.stack.leetcode.editor.en;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-12-02 23:21:58
 * @title: Remove Duplicate Letters
 */
public class P316RemoveDuplicateLetters {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> freq = new HashMap<>(26);
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.get(ch) - 1);
            if (stack.contains(ch)) {
                continue;
            }

            while (!stack.isEmpty() && freq.get(stack.peek()) > 0 && stack.peek() > ch) {
                stack.pop();
            }
            stack.push(ch);
        }

        StringBuilder builder = new StringBuilder();
        stack.forEach(builder::append);
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
