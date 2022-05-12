//Find all valid combinations of k numbers that sum up to n such that the 
//following conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain 
//the same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 👍 3401 👎 82


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * 
 * @author: eumes
 * @date: 2022-05-10 23:32:40
 */
 public class P216CombinationSumIii {
    public static void main(String[] args) {
//        Solution_P216 solution = new Solution_P216();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P216 {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        backTrace(1, k, n, new ArrayList<>());
        return res;
    }

    // 回溯得到从start开始的和为n的所有数comb，个数为k
    private void backTrace(int start, int k, int n, List<Integer> comb) {
        if (n == 0 && k == comb.size()) {
            // 表示已经刚好找到了k个数
            res.add(new ArrayList<>(comb));
            return;
        }

        // 数字为1-9
        for (int i = 1; i <= 9; i++) {
            comb.add(i);
            backTrace(i + 1, k, n - i, comb);
            comb.remove(comb.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
