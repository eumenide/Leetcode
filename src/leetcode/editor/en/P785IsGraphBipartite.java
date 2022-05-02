//There is an undirected graph with n nodes, where each node is numbered 
//between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of 
//nodes that node u is adjacent to. More formally, for each v in graph[u], there is 
//an undirected edge between node u and node v. The graph has the following 
//properties: 
//
// 
// There are no self-edges (graph[u] does not contain u). 
// There are no parallel edges (graph[u] does not contain duplicate values). 
// If v is in graph[u], then u is in graph[v] (the graph is undirected). 
// The graph may not be connected, meaning there may be two nodes u and v such 
//that there is no path between them. 
// 
//
// A graph is bipartite if the nodes can be partitioned into two independent 
//sets A and B such that every edge in the graph connects a node in set A and a node 
//in set B. 
//
// Return true if and only if it is bipartite. 
//
// 
// Example 1: 
//
// 
//Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//Output: false
//Explanation: There is no way to partition the nodes into two independent sets 
//such that every edge connects a node in one and a node in the other. 
//
// Example 2: 
//
// 
//Input: graph = [[1,3],[0,2],[1,3],[0,2]]
//Output: true
//Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}. 
//
// 
// Constraints: 
//
// 
// graph.length == n 
// 1 <= n <= 100 
// 0 <= graph[u].length < n 
// 0 <= graph[u][i] <= n - 1 
// graph[u] does not contain u. 
// All the values of graph[u] are unique. 
// If graph[u] contains v, then graph[v] contains u. 
// 
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 44
//53 👎 269


package leetcode.editor.en;

/**
 * Is Graph Bipartite?
 * 
 * @author: eumes
 * @date: 2022-04-29 23:15:12
 */
 public class P785IsGraphBipartite {
    public static void main(String[] args) {
        Solution_P785 solution = new Solution_P785();
        System.out.println(solution.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
//        System.out.println(solution.dfs(0, null, null));
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P785 {

    // dfs
    public boolean isBipartite(int[][] graph) {
        boolean[] set1 = new boolean[graph.length];
        boolean[] set2 = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (set1[i] || set2[i]) {
                continue;
            }

            if (!dfs(i, set1, set2, graph)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int i, boolean[] set1, boolean[] set2, int[][] graph) {
        if (set1[i] || set2[i]) {
            return !set2[i];
        }

        set1[i] = true;
        for (int j : graph[i]) {
            if (!dfs(j, set2, set1, graph)) {
                return false;
            }
        }

        return true;
    }

    private String dfs(int i, boolean[] set1, boolean[] set2) {
        return "hhh";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
