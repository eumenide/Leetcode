//You are given an integer n. A 0-indexed integer array nums of length n + 1 is 
//generated in the following way: 
//
// 
// nums[0] = 0 
// nums[1] = 1 
// nums[2 * i] = nums[i] when 2 <= 2 * i <= n 
// nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n 
// 
//
// Return the maximum integer in the array nums. 
//
// 
// Example 1: 
//
// 
//Input: n = 7
//Output: 3
//Explanation: According to the given rules:
//  nums[0] = 0
//  nums[1] = 1
//  nums[(1 * 2) = 2] = nums[1] = 1
//  nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
//  nums[(2 * 2) = 4] = nums[2] = 1
//  nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
//  nums[(3 * 2) = 6] = nums[3] = 2
//  nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
//Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is max(0,1,1,2,1,3,2,3) = 3.
// 
//
// Example 2: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: According to the given rules, nums = [0,1,1]. The maximum is max(
//0,1,1) = 1.
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: 2
//Explanation: According to the given rules, nums = [0,1,1,2]. The maximum is 
//max(0,1,1,2) = 2.
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 100 
// 
// Related Topics Array Dynamic Programming Simulation 👍 343 👎 496


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-01 23:18:55
 * @title: Get Maximum in Generated Array
 */
public class P1646GetMaximumInGeneratedArray {
    
    public static void main(String[] args) {
        Solution_1646 solution = new Solution_1646();
        // TO TEST
        // 1
        System.out.println(solution.getMaximumGenerated(2));
        // 3
        System.out.println(solution.getMaximumGenerated(7));
        // 2
        System.out.println(solution.getMaximumGenerated(3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // nums[2 * i] = nums[i]
        // nums[2 * i + 1] = nums[i] + nums[i + 1]
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        int len = n / 2;
        for (int i = 1; i <= len; i++) {
            nums[i * 2] = nums[i];
            if (i * 2 + 1 <= n) {
                nums[i * 2 + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[i * 2 + 1]);
            }
        }

        // i = 1, n[2] = 1, n[3] = 2
        // i = 2, n[4] = 1, n[5] = 3
        // i = 3, n[6] = 2, n[7] = 3
        // i = 4, n[8] = 1, n[9] = 4
        // i = 5, n[10] = 3, n[11] = 5
        // i = 6, n[12] = 2, n[13] = 5
        // i = 7, n[14] = 3, n[15] = 4

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
