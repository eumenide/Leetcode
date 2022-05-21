//There are n servers numbered from 0 to n - 1 connected by undirected server-
//to-server connections forming a network where connections[i] = [ai, bi] 
//represents a connection between servers ai and bi. Any server can reach other servers 
//directly or indirectly through the network. 
//
// A critical connection is a connection that, if removed, will make some 
//servers unable to reach some other server. 
//
// Return all critical connections in the network in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//Output: [[1,3]]
//Explanation: [[3,1]] is also accepted.
// 
//
// Example 2: 
//
// 
//Input: n = 2, connections = [[0,1]]
//Output: [[0,1]]
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁵ 
// n - 1 <= connections.length <= 10⁵ 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// There are no repeated connections. 
// 
// Related Topics Depth-First Search Graph Biconnected Component 👍 4178 👎 151


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Critical Connections in a Network
 * 
 * @author: eumes
 * @date: 2022-05-19 00:32:57
 */
 public class P1192CriticalConnectionsInANetwork {
    public static void main(String[] args) {
//        Solution_P1192 solution = new Solution_P1192();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1192 {
    // 不在环上的边，即为符合题意的critical边
    // https://leetcode.com/problems/critical-connections-in-a-network/discuss/2049712/100-or-0MS-or-DETAILED-EXPLANATION-or-EPIC-MEME-or-CONCISE-or-FAQ-or-2-WAYS
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 先构建邻接表
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> con : connections) {
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }

        // 遍历图，得到不在环上的边集合
        List<List<Integer>> res = new ArrayList<>();
        traverse(graph, res, new int[n], new int[n], 1, 0, -1);
        return res;
    }

    /**
     *
     * @param graph     需要的遍历的图
     * @param res       不在环上的边集合，需要返回的结果
     * @param dis       记录各节点的深度，深度从1开始
     * @param low       记录各节点能到达的最小层数（排除从父节点来的那条路径）
     * @param depth     当前节点的深度
     * @param cur       当前节点
     * @param pre       前一节点
     */
    private void traverse(List<Integer>[] graph, List<List<Integer>> res, int[] dis, int[] low, int depth, int cur, int pre) {
        dis[cur] = low[cur] = depth;
        // 遍历当前节点能到达的下一节点，注意需过滤掉前一节点
        for (Integer next : graph[cur]) {
            if (dis[next] == 0) {
                // 下一节点未访问过，则遍历访问
                traverse(graph, res, dis, low, depth + 1, next, cur);
                // 更新cur能到达的最小层数
                low[cur] = Math.min(low[cur], low[next]);
            } else if (next != pre) {
                // 过滤前一节点，更新cur能到达的最小层数
                low[cur] = Math.min(low[cur], low[next]);
            }

            // 如果下一节点能到达的最小层 > 当前层，则表示这条边不在环上
            if (low[next] > dis[cur]) {
                res.add(Arrays.asList(cur, next));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
