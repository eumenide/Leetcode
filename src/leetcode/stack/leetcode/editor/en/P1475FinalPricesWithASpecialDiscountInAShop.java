//Given the array prices where prices[i] is the price of the ith item in a shop.
// There is a special discount for items in the shop, if you buy the ith item, 
//then you will receive a discount equivalent to prices[j] where j is the minimum 
//index such that j > i and prices[j] <= prices[i], otherwise, you will not receive 
//any discount at all. 
//
// Return an array where the ith element is the final price you will pay for 
//the ith item of the shop considering the special discount. 
//
// 
// Example 1: 
//
// 
//Input: prices = [8,4,6,2,3]
//Output: [4,2,4,2,3]
//Explanation: 
//For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]
//=4, therefore, the final price you will pay is 8 - 4 = 4. 
//For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]
//=2, therefore, the final price you will pay is 4 - 2 = 2. 
//For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]
//=2, therefore, the final price you will pay is 6 - 2 = 4. 
//For items 3 and 4 you will not receive any discount at all.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: [1,2,3,4,5]
//Explanation: In this case, for all items, you will not receive any discount 
//at all.
// 
//
// Example 3: 
//
// 
//Input: prices = [10,1,1,6]
//Output: [9,0,1,6]
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 500 
// 1 <= prices[i] <= 10^3 
// 
// Related Topics Array Stack Monotonic Stack 👍 771 👎 58


package leetcode.stack.leetcode.editor.en;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-22 23:39:10
 * @title: Final Prices With a Special Discount in a Shop
 */
public class P1475FinalPricesWithASpecialDiscountInAShop {
    
    public static void main(String[] args) {
        Solution_1475 solution = new Solution_1475();
        // TO TEST 1
        int[] arr1 = {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(solution.finalPrices(arr1)));

        // Test 2
        System.out.println(Arrays.toString(solution.finalPrices(new int[] {1, 2, 3, 4, 5})));

        // Test 3
        System.out.println(Arrays.toString(solution.finalPrices(new int[] {10, 1, 1, 6})));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1475 {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public int[] finalPrices1(int[] prices) {
        int[] ans = new int[prices.length];

        // 存索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }

        return prices;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
