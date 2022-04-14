//You are given a 0-indexed integer array nums and an integer k. 
//
// You are initially standing at index 0. In one move, you can jump at most k 
//steps forward without going outside the boundaries of the array. That is, you can 
//jump from index i to any index in the range [i + 1, min(n - 1, i + k)] 
//inclusive. 
//
// You want to reach the last index of the array (index n - 1). Your score is 
//the sum of all nums[j] for each index j you visited in the array. 
//
// Return the maximum score you can get. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,-1,-2,4,-7,3], k = 2
//Output: 7
//Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (
//underlined above). The sum is 7.
// 
//
// Example 2: 
//
// 
//Input: nums = [10,-5,-2,4,0,3], k = 3
//Output: 17
//Explanation: You can choose your jumps forming the subsequence [10,4,3] (
//underlined above). The sum is 17.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics Array Dynamic Programming Queue Sliding Window Heap (Priority 
//Queue) Monotonic Queue 👍 1258 👎 52


package leetcode.dp.editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: eumes
 * @date: 2022-03-26 17:46:28
 * @title: Jump Game VI
 */
public class P1696JumpGameVi {
    
    public static void main(String[] args) {
        Solution_1696 solution = new Solution_1696();
        // TO TEST
        int[] arr = new int[] {1, -1, -2, 4, -7, 3};
        int k= 2;
        System.out.println(solution.maxResult(arr, k));

        arr = new int[] {10, -5, -2, 4, 0, 3};
        k = 3;
        System.out.println(solution.maxResult(arr, k));

        arr = new int[] {1, -5, -20, 4, -1, 3, -6, -3};
        k = 2;
        System.out.println(solution.maxResult(arr, k));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1696 {
    /**
     * 动归 O(n * k)  --  TLE
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxResult_tle(int[] nums, int k) {
        // dp[i]表示到达i时的最大值
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // 到达i时，其上一跳应在[i-k,i-1]区间内 的最大值
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
        }

        return dp[nums.length - 1];
    }

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        // 双端队列，按值大小顺序索引值，越靠前越大，越靠前越先出现
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for (int i = 1; i < len; i++) {
            // nums[i] 本身记录 到达i时的最大值
            // 那么nums[i] = max(nums[i-k], ..., num[i-1]) + nums[i]
            // 而deque中记录的永远是nums[i-k], ..., num[i-1] 的顺序排列
            nums[i] = nums[deque.peekFirst()] + nums[i];

            // 将nums[i]加入到deque中，按照顺序，将队尾<nums[i]的都删除
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 将nums[i]加到队尾
            deque.offerLast(i);

            // 若队首超出了[i-k,i-1]的范围，应该删除
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
        }

        return nums[len - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
