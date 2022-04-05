//Alice and Bob take turns playing a game, with Alice starting first. 
//
// Initially, there is a number n on the chalkboard. On each player's turn, 
//that player makes a move consisting of: 
//
// 
// Choosing any x with 0 < x < n and n % x == 0. 
// Replacing the number n on the chalkboard with n - x. 
// 
//
// Also, if a player cannot make a move, they lose the game. 
//
// Return true if and only if Alice wins the game, assuming both players play 
//optimally. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: true
//Explanation: Alice chooses 1, and Bob has no more moves.
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: false
//Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics Math Dynamic Programming Brainteaser Game Theory 👍 1209 👎 29
//25


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:49
 * @title: Divisor Game
 */
public class P1025DivisorGame {
    
    public static void main(String[] args) {
        Solution_1025 solution = new Solution_1025();
        // TO TEST
        System.out.println(solution.divisorGame(2));
        System.out.println(solution.divisorGame(3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1025 {
    public boolean divisorGame(int n) {
        // 偶数必赢，奇数必输
        return (n & 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
