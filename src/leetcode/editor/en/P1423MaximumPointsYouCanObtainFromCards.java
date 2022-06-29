//There are several cards arranged in a row, and each card has an associated 
//number of points. The points are given in the integer array cardPoints. 
//
// In one step, you can take one card from the beginning or from the end of the 
//row. You have to take exactly k cards. 
//
// Your score is the sum of the points of the cards you have taken. 
//
// Given the integer array cardPoints and the integer k, return the maximum 
//score you can obtain. 
//
// 
// Example 1: 
//
// 
//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Explanation: After the first step, your score will always be 1. However, 
//choosing the rightmost card first will maximize your total score. The optimal 
//strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 1
//2.
// 
//
// Example 2: 
//
// 
//Input: cardPoints = [2,2,2], k = 2
//Output: 4
//Explanation: Regardless of which two cards you take, your score will always 
//be 4.
// 
//
// Example 3: 
//
// 
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55
//Explanation: You have to take all the cards. Your score is the sum of points 
//of all cards.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cardPoints.length <= 10⁵ 
// 1 <= cardPoints[i] <= 10⁴ 
// 1 <= k <= cardPoints.length 
// 
// Related Topics Array Sliding Window Prefix Sum 👍 3636 👎 136


package leetcode.editor.en;

/**
 * Maximum Points You Can Obtain from Cards
 * 
 * @author: eumes
 * @date: 2022-06-26 16:43:53
 */
 public class P1423MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
//        Solution_P1423 solution = new Solution_P1423();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口，容纳k个数字，注意只能首尾取。[i, j]表示从j~n-1，再从0~i.
        int le = 0, ri = n - k;
        // 初始计算最后k个数的和
        int sum = 0;
        for (int i = ri; i < n; i++) {
            sum += cardPoints[i];
        }

        int res = sum;
        // 挪到窗口，即尾部越来越少，头部越来越多，直到全是头部
        while (ri < n) {
            sum += cardPoints[le++] - cardPoints[ri++];
            res = Math.max(res, sum);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
