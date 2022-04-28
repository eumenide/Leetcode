//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, and /. Each operand may be an integer or 
//another expression. 
//
// Note that division between two integers should truncate toward zero. 
//
// It is guaranteed that the given RPN expression is always valid. That means 
//the expression would always evaluate to a result, and there will not be any 
//division by zero operation. 
//
// 
// Example 1: 
//
// 
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
//
// 
// Constraints: 
//
// 
// 1 <= tokens.length <= 10⁴ 
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the 
//range [-200, 200]. 
// 
// Related Topics Array Math Stack 👍 2329 👎 573


package leetcode.stack.leetcode.editor.en;

import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-29 23:00:32
 * @title: Evaluate Reverse Polish Notation
 */
public class P150EvaluateReversePolishNotation {
    
    public static void main(String[] args) {
        Solution_150 solution = new Solution_150();
        // TO TEST
        System.out.println(solution.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int num, tmp;
            switch (token) {
                case "+" -> num = stack.pop() + stack.pop();
                case "-" -> {
                    tmp = stack.pop();
                    num = stack.pop() - tmp;
                }
                case "*" -> {
                    tmp = stack.pop();
                    num = stack.pop() * tmp;
                }
                case "/" -> {
                    tmp = stack.pop();
                    num = stack.pop() / tmp;
                }
                default -> num = Integer.parseInt(token);
            }
            stack.push(num);
        }

        return stack.pop();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
