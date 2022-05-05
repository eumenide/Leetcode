//There is a car with capacity empty seats. The vehicle only drives east (i.e., 
//it cannot turn around and drive west). 
//
// You are given the integer capacity and an array trips where trips[i] = [
//numPassengersi, fromi, toi] indicates that the iᵗʰ trip has numPassengersi 
//passengers and the locations to pick them up and drop them off are fromi and toi 
//respectively. The locations are given as the number of kilometers due east from the 
//car's initial location. 
//
// Return true if it is possible to pick up and drop off all passengers for all 
//the given trips, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
// 
//
// Example 2: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
// Related Topics Array Sorting Heap (Priority Queue) Simulation Prefix Sum 👍 3
//137 👎 67


package leetcode.editor.en;

/**
 * Car Pooling
 * 
 * @author: eumes
 * @date: 2022-05-06 00:41:03
 */
 public class P1094CarPooling {
    public static void main(String[] args) {
//        Solution_P1094 solution = new Solution_P1094();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 差分数组
        int[] diff = new int[1001];

        // 构造
        int maxT = 0;
        for (int[] trip : trips) {
            int i = trip[1];
            int j = trip[2];
            int v = trip[0];
            maxT = Math.max(maxT, j);
            diff[i] += v;
            if (j < 1001) {
                diff[j] -= v;
            }
        }

        if (diff[0] > capacity) {
            return false;
        }
        for (int i = 1; i <= maxT; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
