//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics Array Dynamic Programming 👍 4798 👎 188


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: eumes
 * @date: 2022-02-07 13:12:04
 * @title: Pascal's Triangle
 */
public class P118PascalsTriangle {
    
    public static void main(String[] args) {
        Solution_118 solution = new Solution_118();
        // TO TEST
        System.out.println(solution.generate(5));

        System.out.println(solution.generate(1));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        while (--numRows > 0) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int i = 0; i < first.size() - 1; i++) {
                tmp.add(first.get(i) + first.get(i + 1));
            }
            tmp.add(1);

            first = tmp;
            result.add(tmp);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
