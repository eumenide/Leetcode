//A conveyor belt has packages that must be shipped from one port to another 
//within days days. 
//
// The iᵗʰ package on the conveyor belt has a weight of weights[i]. Each day, 
//we load the ship with packages on the conveyor belt (in the order given by 
//weights). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the 
//packages on the conveyor belt being shipped within days days. 
//
// 
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 
//5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of 
//capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed.
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], days = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3
// days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= days <= weights.length <= 5 * 10⁴ 
// 1 <= weights[i] <= 500 
// Related Topics Array Binary Search Greedy 👍 4200 👎 99


package leetcode.editor.en;

/**
 * Capacity To Ship Packages Within D Days
 * 
 * @author: eumes
 * @date: 2022-05-10 00:09:18
 */
 public class P1011CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
//        Solution_P1011 solution = new Solution_P1011();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1011 {
    public int shipWithinDays(int[] weights, int days) {
        int le = 0, ri = 1;
        // le为weights中最大值，至少需要能容纳一天的量；ri 为和
        for (int i = 0; i < weights.length; i++) {
            le = Math.max(le, weights[i]);
            ri += weights[i];
        }

        while (le < ri) {
            int mid = le + ((ri - le) >> 1);
            int curD = findD(mid, weights);
            if (curD > days) {
                // 说明容量小了
                le = mid + 1;
            } else {
                ri = mid;
            }
        }

        return le;
    }

    private int findD(int cap, int[] weights) {
        int days = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > cap) {
                sum = weights[i];
                days++;
            }
        }
        return days + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
