//Given two sequences pushed and popped with distinct values, return true if and
// only if this could have been the result of a sequence of push and pop operation
//s on an initially empty stack. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//Output: true
//Explanation: We might do the following sequence:
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 
// Example 2: 
//
// 
//Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//Output: false
//Explanation: 1 cannot be popped before 2.
// 
// 
// 
//
// 
// Constraints: 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed is a permutation of popped. 
// pushed and popped have distinct values. 
// 
// Related Topics Stack 
// 👍 1096 👎 32


package leetcode.stack.leetcode.editor.en;

import java.util.Stack;

/**
 * @author: eumes
 * @date: 2020-10-23 20:52:22
 * @title: Validate Stack Sequences
 */
public class P946ValidateStackSequences {
    
    public static void main(String[] args) {
        Solution_946 solution = new Solution_946();
        // TO TEST
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        System.out.println(solution.validateStackSequences(pushed, poped));

        poped = new int[] {4, 3, 5, 1, 2};
        System.out.println(solution.validateStackSequences(pushed, poped));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (int j : pushed) {
            stack.push(j);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
