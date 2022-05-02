//You are given an array of variable pairs equations and an array of real 
//numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai 
/// Bi = values[i]. Each Ai or Bi is a string that represents a single variable. 
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the 
//jᵗʰ query where you must find the answer for Cj / Dj = ?. 
//
// Return the answers to all queries. If a single answer cannot be determined, 
//return -1.0. 
//
// Note: The input is always valid. You may assume that evaluating the queries 
//will not result in division by zero and that there is no contradiction. 
//
// 
// Example 1: 
//
// 
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a",
//"c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation: 
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// Example 2: 
//
// 
//Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//Output: [3.75000,0.40000,5.00000,0.20000]
// 
//
// Example 3: 
//
// 
//Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"]
//,["a","c"],["x","y"]]
//Output: [0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
// Constraints: 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj consist of lower case English letters and digits. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Graph Shortest Path 👍 5529 👎 467


package leetcode.editor.en;

import java.util.*;

/**
 * Evaluate Division
 * 
 * @author: eumes
 * @date: 2022-05-01 01:12:52
 */
 public class P399EvaluateDivision {
    public static void main(String[] args) {
        //equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Solution_P399 solution = new Solution_P399();
        // TO TEST
        System.out.println(Arrays.toString(solution.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2, 3}, Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")))));
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 如 [a, b] = 0.5 表示 a/b=0.5，则 key = a，value = {"b": 0.5}
        Map<String, Map<String, Double>> graph = new HashMap<>();
        double[] ans = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            // 取出等式中的 A 和 B，并将 A / B和B / A都放入
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }

        // 计算每个query
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String c = queries.get(i).get(1);

            // 已有等式中不包含查询，结果为-1
            if (!graph.containsKey(a) || !graph.containsKey(c)) {
                ans[i] = -1;
            } else {
                // dfs搜索a的计算链
                ans[i] = dfsDivide(graph, a, c, new HashSet<>());
            }


        }

        return ans;
    }

    private double dfsDivide(Map<String, Map<String, Double>> graph, String a, String c, HashSet<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(c)) {
            return -1;
        }
        if (a.equals(c)) {
            return 1;
        }
        if (graph.get(a).get(c) != null) {
            return graph.get(a).get(c);
        }

        for (String b : graph.get(a).keySet()) {
            // a / c = (a / b) * (b / c)
            double res = dfsDivide(graph, b, c, visited);
            if (res >= 0) {
                graph.get(a).put(c, graph.get(a).get(b) * res);
                return graph.get(a).get(c);
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
