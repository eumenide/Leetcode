//There are n flights that are labeled from 1 to n. 
//
// You are given an array of flight bookings bookings, where bookings[i] = [
//firsti, lasti, seatsi] represents a booking for flights firsti through lasti (
//inclusive) with seatsi seats reserved for each flight in the range. 
//
// Return an array answer of length n, where answer[i] is the total number of 
//seats reserved for flight i. 
//
// 
// Example 1: 
//
// 
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
// 
//
// Example 2: 
//
// 
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
// Related Topics Array Prefix Sum 👍 1024 👎 141


package leetcode.editor.en;

/**
 * Corporate Flight Bookings
 * 
 * @author: eumes
 * @date: 2022-05-06 00:34:51
 */
 public class P1109CorporateFlightBookings {
    public static void main(String[] args) {
//        Solution_P1109 solution = new Solution_P1109();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分数组，初始值为0
        int[] diff = new int[n];

        // 每个flight对指定区间加操作
        for (int[] book : bookings) {
            diff[book[0] - 1] += book[2];
            if (book[1] < n) {
                diff[book[1]] -= book[2];
            }
        }

        // 恢复原数组
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
