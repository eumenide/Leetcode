//You are given an m x n binary matrix mat of 1's (representing soldiers) and 0
//'s (representing civilians). The soldiers are positioned in front of the 
//civilians. That is, all the 1's will appear to the left of all the 0's in each row. 
//
// A row i is weaker than a row j if one of the following is true: 
//
// 
// The number of soldiers in row i is less than the number of soldiers in row j.
// 
// Both rows have the same number of soldiers and i < j. 
// 
//
// Return the indices of the k weakest rows in the matrix ordered from weakest 
//to strongest. 
//
// 
// Example 1: 
//
// 
//Input: mat = 
//[{1,1,0,0,0},
// {1,1,1,1,0},
// {1,0,0,0,0},
// {1,1,0,0,0},
// {1,1,1,1,1]}, 
//k = 3
//Output: [2,0,3]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 2 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 2 
//- Row 4: 5 
//The rows ordered from weakest to strongest are [2,0,3,1,4].
// 
//
// Example 2: 
//
// 
//Input: mat = 
//[{1,0,0,0},
// {1,1,1,1},
// {1,0,0,0},
// {1,0,0,0]}, 
//k = 2
//Output: [0,2]
//Explanation: 
//The number of soldiers in each row is: 
//- Row 0: 1 
//- Row 1: 4 
//- Row 2: 1 
//- Row 3: 1 
//The rows ordered from weakest to strongest are [0,2,3,1].
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] is either 0 or 1. 
// 
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 👍 19
//47 👎 102


package leetcode.dp.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: eumes
 * @date: 2022-03-27 18:38:10
 * @title: The K Weakest Rows in a Matrix
 */
public class P1337TheKWeakestRowsInAMatrix {
    
    public static void main(String[] args) {
        Solution_1337 solution = new Solution_1337();
        // TO TEST
        int[][] mat = new int[][] {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, 3)));

        mat = new int[][] {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, 2)));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        // 优先队列，存储每个节点，表示 该行1的个数 & 该行的Index
        // 优先队列，重写比较器：1个数大，行index小
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 计算每行1的个数
        for (int i = 0; i < mat.length; i++) {
            int sum = countNumberOne(mat[i]);
            queue.offer(new int[] {sum, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[1];
        }

        return result;
    }

    public int countNumberOne(int[] row) {
        int l = 0, r = row.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (row[m] == 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return row[l] == 1 ? l + 1 : l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
