//Given an array of integers arr and an integer d. In one step you can jump 
//from index i to index: 
//
// 
// i + x where: i + x < arr.length and 0 < x <= d. 
// i - x where: i - x >= 0 and 0 < x <= d. 
// 
//
// In addition, you can only jump from index i to index j if arr[i] > arr[j] 
//and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k 
//< max(i, j)). 
//
// You can choose any index of the array and start jumping. Return the maximum 
//number of indices you can visit. 
//
// Notice that you can not jump outside of the array at any time. 
//
// 
// Example 1: 
//
// 
//Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
//Output: 4
//Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as 
//shown.
//Note that if you start at index 6 you can only jump to index 7. You cannot 
//jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is 
//between index 4 and 6 and 13 > 9.
//Similarly You cannot jump from index 3 to index 2 or index 1.
// 
//
// Example 2: 
//
// 
//Input: arr = [3,3,3,3,3], d = 3
//Output: 1
//Explanation: You can start at any index. You always cannot jump to any index.
// 
//
// Example 3: 
//
// 
//Input: arr = [7,6,5,4,3,2,1], d = 1
//Output: 7
//Explanation: Start at index 0. You can visit all the indicies. 
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 10⁵ 
// 1 <= d <= arr.length 
// 
// Related Topics Array Dynamic Programming Sorting 👍 625 👎 22


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-27 18:37:43
 * @title: Jump Game V
 */
public class P1340JumpGameV {
    
    public static void main(String[] args) {
        Solution_1340 solution = new Solution_1340();
        // TO TEST
        int[] arr = new int[] {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int k = 2;
        System.out.println(solution.maxJumps(arr, k));

        arr = new int[] {3, 3, 3, 3, 3};
        k = 3;
        System.out.println(solution.maxJumps(arr, k));

        arr = new int[] {7, 6, 5, 4, 3, 2, 1};
        k = 1;
        System.out.println(solution.maxJumps(arr, k));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1340 {

    public int maxJumps(int[] arr, int d) {
        // TODO: 2022/3/28  O(n)的算法，目前看不太懂
        return 0;
    }

    /**
     * dfs  O(n * d)
     *
     * @param arr
     * @param d
     * @return
     */
    public int maxJumps_dfs(int[] arr, int d) {
        // dp[i]表示从i起跳，能跳到的最大步数
        // 则dp[i] = max(dp[j]) + 1，其中j为i能跳到的所有位置
        int[] dp = new int[arr.length];
        // 返回结果应该是dp中的最大值
        int result = 0;
        // 找到最高点
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, dfs(arr, d, i, dp));
        }

        return result;
    }

    public int dfs(int[] arr, int d, int i, int[] dp) {
        // 如果dp[i]有值，则表示已跳到最底层
        if (dp[i] != 0) {
            return dp[i];
        }

        // 左边界 & 右边界
        int left = Math.max(0, i - d);
        int right = Math.min(arr.length - 1, i + d);
        int res = 0;
        // 往左边跳，不超过边界 & 比当前小
        for (int j = i - 1; j >= left && arr[j] < arr[i]; --j) {
            res = Math.max(res, dfs(arr, d, j, dp));
        }

        // 往右边跳，不超过边界 & 比当前大
        for (int j = i + 1; j <= right && arr[j] < arr[i]; j++) {
            res = Math.max(res, dfs(arr, d, j, dp));
        }

        return dp[i] = res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
