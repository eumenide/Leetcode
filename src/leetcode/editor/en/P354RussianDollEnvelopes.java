//You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] 
//represents the width and the height of an envelope. 
//
// One envelope can fit into another if and only if both the width and height 
//of one envelope are greater than the other envelope's width and height. 
//
// Return the maximum number of envelopes you can Russian doll (i.e., put one 
//inside the other). 
//
// Note: You cannot rotate an envelope. 
//
// 
// Example 1: 
//
// 
//Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//Output: 3
//Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] 
//=> [5,4] => [6,7]).
// 
//
// Example 2: 
//
// 
//Input: envelopes = [[1,1],[1,1],[1,1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics Array Binary Search Dynamic Programming Sorting 👍 3748 👎 86


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Russian Doll Envelopes
 * 
 * @author: eumes
 * @date: 2022-05-25 23:21:53
 */
 public class P354RussianDollEnvelopes {
    public static void main(String[] args) {
//        Solution_P354 solution = new Solution_P354();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P354 {
    // 加个例子就比较容易明白，比如序列是78912345，前三个遍历完以后tail是789，这时候遍历到1，就得把1放到合适的位置，于是在tail二分查找1的位置，变成了189（如果序列在此时结束，因为res不变，所以依旧输出3），再遍历到2成为129，然后是123直到12345
    public int maxEnvelopes(int[][] envelopes) {
        // 行升序、列降序
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        // dp数组
        int n = envelopes.length;
        int[] dp = new int[n];
        int res = 0;

        for (int[] env : envelopes) {
            int h = env[1];
            int le = 0, ri = res;
            while (le < ri) {
                int mid = le + ((ri - le) >> 1);
                if (dp[mid] < h) {
                    le = mid + 1;
                } else {
                    ri = mid;
                }
            }

            if (le == res) {
                res++;
            }
            dp[le] = h;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
