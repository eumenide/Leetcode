//You are given a network of n nodes, labeled from 1 to n. You are also given 
//times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui 
//is the source node, vi is the target node, and wi is the time it takes for a 
//signal to travel from source to target. 
//
// We will send a signal from a given node k. Return the time it takes for all 
//the n nodes to receive the signal. If it is impossible for all the n nodes to 
//receive the signal, return -1. 
//
// 
// Example 1: 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 1
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: times = [[1,2,1]], n = 2, k = 2
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.) 
// 
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority 
//Queue) Shortest Path 👍 4552 👎 296


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Network Delay Time
 * 
 * @author: eumes
 * @date: 2022-05-14 22:22:14
 */
 public class P743NetworkDelayTime {
    public static void main(String[] args) {
//        Solution_P743 solution = new Solution_P743();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接矩阵
        int[][] m = new int[n + 1][n + 1];
        // 填充-1表示未连通
        for (int i = 0; i <= n; i++) {
            Arrays.fill(m[i], -1);
        }
        // 填充邻接矩阵
        for (int[] time : times) {
            m[time[0]][time[1]] = time[2];
        }

        // 优先队列升序，存储节点 & 开始节点到该节点的最小距离
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        queue.offer(new int[]{k, 0});
        // 记录距离，开始节点到节点i的最短距离
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;

        // dijsktra算法
        while (!queue.isEmpty()) {
            // 每次弹出，权重最小的
            int[] poll = queue.poll();
            int i = poll[0];
            int w = poll[1];
            if (w > dis[i]) {
                // 说明i节点已更新为最新，可以略过
                continue;
            }
            // 循环遍历i能到达的节点，更新开始到j节点的最小距离
            for (int j = 1; j <= n; j++) {
                if (m[i][j] == -1) {
                    // 未连通
                    continue;
                }
                int dis2j = dis[i] + m[i][j];
                if (dis2j < dis[j]) {
                    // 经过该节点的距离比已有距离小，则更新
                    dis[j] = dis2j;
                    queue.offer(new int[]{j, dis2j});
                }
            }
        }

        // 找到最长的距离，
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                // 说明未连通的节点
                return -1;
            }
            res = Math.max(res, dis[i]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
