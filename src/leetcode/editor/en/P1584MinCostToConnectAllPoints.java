//You are given an array points representing integer coordinates of some points 
//on a 2D-plane, where points[i] = [xi, yi]. 
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan 
//distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute 
//value of val. 
//
// Return the minimum cost to make all points connected. All points are 
//connected if there is exactly one simple path between any two points. 
//
// 
// Example 1: 
//
// 
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation: 
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
// 
//
// Example 2: 
//
// 
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// All pairs (xi, yi) are distinct. 
// 
// Related Topics Array Union Find Minimum Spanning Tree 👍 1948 👎 60


package leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Min Cost to Connect All Points
 * 
 * @author: eumes
 * @date: 2022-04-26 23:22:55
 */
 public class P1584MinCostToConnectAllPoints {
    public static void main(String[] args) {
//        Solution_P1584 solution = new Solution_P1584();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1584 {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }

        int minW = 0;
        boolean[] visited = new boolean[points.length];
        int edgeCount = points.length - 1;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        // 初始化
        visited[0] = true;
        for (int i = 1; i < points.length; i++) {
            int w = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            minHeap.offer(new Edge(0, i, w));
        }

        // 每次添加一个点+边
        while (edgeCount > 0 && !minHeap.isEmpty()) {
            Edge e = minHeap.poll();
            // 已添加过的点，不再添加
            if (visited[e.p2]) {
                continue;
            }

            edgeCount--;
            visited[e.p2] = true;
            minW += e.w;

            for (int i = 1; i < points.length; i++) {
                int w = Math.abs(points[e.p2][0] - points[i][0]) + Math.abs(points[e.p2][1] - points[i][1]);
                minHeap.offer(new Edge(e.p2, i, w));
            }
        }

        return minW;
    }

    class Edge {
        int p1;
        int p2;
        int w;

        public Edge(int p1, int p2, int w) {
            this.p1 = p1;
            this.p2 = p2;
            this.w = w;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
