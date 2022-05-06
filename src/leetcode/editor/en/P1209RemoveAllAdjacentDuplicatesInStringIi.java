//You are given a string s and an integer k, a k duplicate removal consists of 
//choosing k adjacent and equal letters from s and removing them, causing the left 
//and the right side of the deleted substring to concatenate together. 
//
// We repeatedly make k duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete. 
//
// Example 2: 
//
// 
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa" 
//
// Example 3: 
//
// 
//Input: s = "pbbcggttciiippooaais", k = 2
//Output: "ps"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// 2 <= k <= 10⁴ 
// s only contains lower case English letters. 
// 
// Related Topics String Stack 👍 3404 👎 65


package leetcode.editor.en;

import java.util.Stack;

/**
 * Remove All Adjacent Duplicates in String II
 * 
 * @author: eumes
 * @date: 2022-05-06 22:46:26
 */
 public class P1209RemoveAllAdjacentDuplicatesInStringIi {
    public static void main(String[] args) {
//        Solution_P1209 solution = new Solution_P1209();
        // TO TEST
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1209 {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == stack.peek()[0]) {
                if (stack.peek()[1] == k - 1) {
                    stack.pop();
                } else {
                    stack.peek()[1]++;
                }
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int[] st : stack) {
            while (st[1]-- > 0) {
                builder.append((char) st[0]);
            }
        }

        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
