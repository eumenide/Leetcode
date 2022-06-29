//You are given an array target of n integers. From a starting array arr 
//consisting of n 1's, you may perform the following procedure : 
//
// 
// let x be the sum of all elements currently in your array. 
// choose index i, such that 0 <= i < n and set the value of arr at index i to 
//x. 
// You may repeat this procedure as many times as needed. 
// 
//
// Return true if it is possible to construct the target array from arr, 
//otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: target = [9,3,5]
//Output: true
//Explanation: Start with arr = [1, 1, 1] 
//[1, 1, 1], sum = 3 choose index 1
//[1, 3, 1], sum = 5 choose index 2
//[1, 3, 5], sum = 9 choose index 0
//[9, 3, 5] Done
// 
//
// Example 2: 
//
// 
//Input: target = [1,1,1,2]
//Output: false
//Explanation: Impossible to create target array from [1,1,1,1].
// 
//
// Example 3: 
//
// 
//Input: target = [8,5]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// n == target.length 
// 1 <= n <= 5 * 10⁴ 
// 1 <= target[i] <= 10⁹ 
// 
// Related Topics Array Heap (Priority Queue) 👍 1489 👎 116


package leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Construct Target Array With Multiple Sums
 * 
 * @author: eumes
 * @date: 2022-06-25 00:05:40
 */
 public class P1354ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
//        Solution_P1354 solution = new Solution_P1354();
        // TO TEST
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1354 {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        long sum = 0;
        // 大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int t : target) {
            sum += t;
            heap.offer(t);
        }

        while (!heap.isEmpty() && heap.peek() != 1) {
            int p = heap.poll();
            sum -= p;
            if (sum == 1) {
                // 其他数和=1，只可能是x, 1
                return true;
            }

            // 这样会超时
//            int cur = (int) (p - sum);
            // 取模，相当于一次性进行好几次转换
            int cur = (int) (p % sum);
            sum += cur;
            if (cur == p || cur == 0) {
                // 后者为p == sum，即其他数和=0；前者为p < sum，则不能变化
                return false;
            }
            heap.offer(cur);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
