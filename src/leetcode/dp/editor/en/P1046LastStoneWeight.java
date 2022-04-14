//You are given an array of integers stones where stones[i] is the weight of 
//the iᵗʰ stone. 
//
// We are playing a game with the stones. On each turn, we choose the heaviest 
//two stones and smash them together. Suppose the heaviest two stones have weights 
//x and y with x <= y. The result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the smallest possible weight of the left stone. If there are no 
//stones left, return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation: 
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the 
//value of the last stone.
// 
//
// Example 2: 
//
// 
//Input: stones = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics Array Heap (Priority Queue) 👍 2802 👎 59


package leetcode.dp.editor.en;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: eumes
 * @date: 2022-04-08 00:05:29
 * @title: Last Stone Weight
 */
public class P1046LastStoneWeight {
    
    public static void main(String[] args) {
        Solution_1046 solution = new Solution_1046();
        // TO TEST
        int[] stones = new int[] {2, 7, 4, 1, 8, 1};
        System.out.println(solution.lastStoneWeight(stones));

        stones = new int[] {1};
        System.out.println(solution.lastStoneWeight(stones));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        // 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones) {
            queue.offer(s);
        }

        int first, second;
        while (queue.size() > 1) {
            first = queue.poll();
            second = queue.poll();
            if (first > second) {
                queue.offer(first - second);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }

    // n ^ 2，但 n<=30
    public int lastStoneWeight_1(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            Arrays.sort(stones);
        }

        return stones[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
