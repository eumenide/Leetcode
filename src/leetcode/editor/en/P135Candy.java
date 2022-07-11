//There are n children standing in a line. Each child is assigned a rating 
//value given in the integer array ratings. 
//
// You are giving candies to these children subjected to the following 
//requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// Return the minimum number of candies you need to have to distribute the 
//candies to the children. 
//
// 
// Example 1: 
//
// 
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
// 
//
// 
// Constraints: 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics Array Greedy 👍 3981 👎 293


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Candy
 * 
 * @author: eumes
 * @date: 2022-07-05 00:01:58
 */
 public class P135Candy {
    public static void main(String[] args) {
//        Solution_P135 solution = new Solution_P135();
        // TO TEST
        
    }
    
 }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P135 {

    // 分别计算增区间 & 减区间
    public int candy(int[] ratings) {
        int[] memo = new int[ratings.length];
        Arrays.fill(memo, 1);

        // 从左往右，保证增区间
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                memo[i] = memo[i - 1] + 1;
            }
        }
        // 从右往左，保证减区间
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                memo[i] = Math.max(memo[i], memo[i + 1] + 1);
            }
        }

        return Arrays.stream(memo).sum();
    }


    // 暴力
    public int candy_bruce(int[] ratings) {
        int[] memo = new int[ratings.length];
        memo[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                memo[i] = memo[i - 1] + 1;
            } else {
                memo[i] = 1;
                int j = i;
                while (j >= 1 && ratings[j - 1] > ratings[j] && memo[j - 1] <= memo[j]) {
                    memo[--j]++;
                }
            }
        }

        return Arrays.stream(memo).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
