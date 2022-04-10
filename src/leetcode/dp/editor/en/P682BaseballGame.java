//You are keeping score for a baseball game with strange rules. The game 
//consists of several rounds, where the scores of past rounds may affect future rounds' 
//scores. 
//
// At the beginning of the game, you start with an empty record. You are given 
//a list of strings ops, where ops[i] is the iᵗʰ operation you must apply to the 
//record and is one of the following: 
//
// 
// An integer x - Record a new score of x. 
// "+" - Record a new score that is the sum of the previous two scores. It is 
//guaranteed there will always be two previous scores. 
// "D" - Record a new score that is double the previous score. It is guaranteed 
//there will always be a previous score. 
// "C" - Invalidate the previous score, removing it from the record. It is 
//guaranteed there will always be a previous score. 
// 
//
// Return the sum of all the scores on the record. 
//
// 
// Example 1: 
//
// 
//Input: ops = ["5","2","C","D","+"]
//Output: 30
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"2" - Add 2 to the record, record is now [5, 2].
//"C" - Invalidate and remove the previous score, record is now [5].
//"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//The total sum is 5 + 10 + 15 = 30.
// 
//
// Example 2: 
//
// 
//Input: ops = ["5","-2","4","C","D","9","+","+"]
//Output: 27
//Explanation:
//"5" - Add 5 to the record, record is now [5].
//"-2" - Add -2 to the record, record is now [5, -2].
//"4" - Add 4 to the record, record is now [5, -2, 4].
//"C" - Invalidate and remove the previous score, record is now [5, -2].
//"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//"9" - Add 9 to the record, record is now [5, -2, -4, 9].
//"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
// 
//
// Example 3: 
//
// 
//Input: ops = ["1"]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= ops.length <= 1000 
// ops[i] is "C", "D", "+", or a string representing an integer in the range [-3
// * 10⁴, 3 * 10⁴]. 
// For operation "+", there will always be at least two previous scores on the 
//record. 
// For operations "C" and "D", there will always be at least one previous score 
//on the record. 
// 
// Related Topics Array Stack Simulation 👍 1476 👎 1567


package leetcode.dp.editor.en;

import java.util.Stack;

/**
 * @author: eumes
 * @date: 2022-04-10 23:31:47
 * @title: Baseball Game
 */
public class P682BaseballGame {
    
    public static void main(String[] args) {
        Solution_682 solution = new Solution_682();
        // TO TESTs

        System.out.println(solution.calPoints(new String[] {"5", "2", "C", "D", "+"}));
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int le = 0, ri = 0;
        for (int i = 0; i < ops.length; i++) {
            if ("+".equals(ops[i])) {
                stack.push(stack.elementAt(stack.size() - 2) + stack.peek());
                sum += stack.peek();
            } else if ("D".equals(ops[i])) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if ("C".equals(ops[i])) {
                sum -= stack.pop();
            } else {
                stack.push(Integer.valueOf(ops[i]));
                sum += Integer.valueOf(ops[i]);
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
