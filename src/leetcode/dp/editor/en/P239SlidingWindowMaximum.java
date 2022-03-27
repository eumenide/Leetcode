//You are given an array of integers nums, there is a sliding window of size k 
//which is moving from the very left of the array to the very right. You can only 
//see the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic 
//Queue 👍 9253 👎 326


package leetcode.dp.editor.en;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: eumes
 * @date: 2022-03-26 22:20:41
 * @title: Sliding Window Maximum
 */
public class P239SlidingWindowMaximum {
    
    public static void main(String[] args) {
        Solution_239 solution = new Solution_239();
        // TO TEST
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, k)));

        arr = new int[] {1};
        k = 1;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, k)));

        arr = new int[] {1, -1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, k)));

        arr = new int[] {7, 2, 4};
        k = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(arr, k)));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        // 利用双端队列，仅保存k窗口中到i位置为止的值，并从大到小排列
        // 队首为最大值，队尾为最小值且是当前位置值
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int[] result = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.offer(i);
                continue;
            }

            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 直接利用nums存储最大值
            result[i] = Math.max(nums[i], nums[deque.peekFirst()]);

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }

        return Arrays.copyOfRange(result, k - 1, result.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
