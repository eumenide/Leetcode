//Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the 
//Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly 
//above it as shown: 
//
// 
// Example 1: 
// Input: rowIndex = 3
//Output: [1,3,3,1]
// Example 2: 
// Input: rowIndex = 0
//Output: [1]
// Example 3: 
// Input: rowIndex = 1
//Output: [1,1]
// 
// 
// Constraints: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra 
//space? 
// Related Topics Array Dynamic Programming 👍 2292 👎 256


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: eumes
 * @date: 2022-03-01 23:17:04
 * @title: Pascal's Triangle II
 */
public class P119PascalsTriangleIi {
    
    public static void main(String[] args) {
        Solution_119 solution = new Solution_119();
        // TO TEST
        System.out.println(solution.getRow(10));
        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        int index = rowIndex;
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        rows.add(pre);

        while (rowIndex-- > 0) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i = 0; i < pre.size() - 1; i++) {
                cur.add(pre.get(i) + pre.get(i + 1));
            }
            cur.add(1);

            pre = cur;
            rows.add(cur);
        }

        System.out.println(rows);
        return rows.get(index);
    }

    public List<Integer> getRow2(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] += arr[j - 1];
            }
        }
        return Arrays.asList(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
