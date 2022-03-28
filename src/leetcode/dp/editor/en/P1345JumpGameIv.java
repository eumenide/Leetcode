//Given an array of integers arr, you are initially positioned at the first 
//index of the array. 
//
// In one step you can jump from index i to index: 
//
// 
// i + 1 where: i + 1 < arr.length. 
// i - 1 where: i - 1 >= 0. 
// j where: arr[i] == arr[j] and i != j. 
// 
//
// Return the minimum number of steps to reach the last index of the array. 
//
// Notice that you can not jump outside of the array at any time. 
//
// 
// Example 1: 
//
// 
//Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
//Output: 3
//Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that 
//index 9 is the last index of the array.
// 
//
// Example 2: 
//
// 
//Input: arr = [7]
//Output: 0
//Explanation: Start index is the last index. You do not need to jump.
// 
//
// Example 3: 
//
// 
//Input: arr = [7,6,9,6,9,6,9,7]
//Output: 1
//Explanation: You can jump directly from index 0 to index 7 which is last 
//index of the array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// -10⁸ <= arr[i] <= 10⁸ 
// 
// Related Topics Array Hash Table Breadth-First Search 👍 1756 👎 71


package leetcode.dp.editor.en;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author: eumes
 * @date: 2022-03-27 18:07:38
 * @title: Jump Game IV
 */
public class P1345JumpGameIv {
    
    public static void main(String[] args) {
        Solution_1345 solution = new Solution_1345();
        // TO TEST
        int[] arr = new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(solution.minJumps(arr));

        arr = new int[] {7};
        System.out.println(solution.minJumps(arr));

        arr = new int[] {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(solution.minJumps(arr));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1345 {
    public int minJumps(int[] arr) {
        // 先找到每个值及其所有位置的对应关系
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }

        // 记录已访问过的位置
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        // bfs遍历整个关系图
        // 节点能到达的位置是：i-1,i+1,map.get(value)
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int step = 0;

        while (!queue.isEmpty()) {
            // 取出此步中，所有的节点
            for (int loop = queue.size(); loop > 0; loop--) {
                // 若该节点是最后，则已到达，直接返回
                int cur = queue.poll();
                if (cur == arr.length - 1) {
                    return step;
                }

                // 将该节点能达到的位置加入都queue中
                List<Integer> next = map.get(arr[cur]);
                for (Integer index : next) {
                    // 没有返回过，才加入下一步队列中
                    if (!visited[index]) {
                        visited[index] = true;
                        queue.offer(index);
                    }
                }
                // 处理 i-1 和 i+1
                if (cur > 0  && !visited[cur - 1]) {
                    visited[cur - 1] = true;
                    queue.offer(cur - 1);
                }
                if (cur < arr.length - 1 && !visited[cur + 1]) {
                    visited[cur + 1] = true;
                    queue.offer(cur + 1);
                }

                next.clear();
            }
            step++;
        }

        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
