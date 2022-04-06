//Given an integer array arr, and an integer target, return the number of 
//tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target. 
//
// As the answer can be very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//Output: 20
//Explanation: 
//Enumerating by the values (arr[i], arr[j], arr[k]):
//(1, 2, 5) occurs 8 times;
//(1, 3, 4) occurs 8 times;
//(2, 2, 4) occurs 2 times;
//(2, 3, 3) occurs 2 times.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,2,2,2,2], target = 5
//Output: 12
//Explanation: 
//arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
//We choose one 1 from [1,1] in 2 ways,
//and two 2s from [2,2,2,2] in 6 ways.
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
// Related Topics Array Hash Table Two Pointers Sorting Counting 👍 1750 👎 216


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: eumes
 * @date: 2022-04-06 23:03:16
 * @title: 3Sum With Multiplicity
 */
public class P923ThreeSumWithMultiplicity {
    
    public static void main(String[] args) {
        Solution_923 solution = new Solution_923();
        // TO TEST
        int[] arr = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target = 8;
        System.out.println(solution.threeSumMulti(arr, target));

        arr = new int[] {1, 1, 2, 2, 2, 2};
        target = 5;
        System.out.println(solution.threeSumMulti(arr, target));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_923 {

    public int threeSumMulti(int[] arr, int target) {
        int n = 101;
        long count = 0;
        // 统计各数字出现次数
        long[] nums = new long[n];
        for (int i : arr) {
            nums[i]++;
        }

        // 遍历统计数组
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 此时第3个数应该为 target - i - j
                int k = target - i - j;
                // 若k超出范围，继续
                if (k < 0 || k > 100) {
                    continue;
                }

                // 下面分几种情况：1. i = j = k ; 2. i = j != k 或 i != j = k ; 3. i != j != K
                // 严格按顺序 i <=j<=k，避免重复
                if (i == j && j == k) {
                    // 相当于 C(n,3) n个相同数中取3个
                    count += nums[i] * (nums[i] - 1) * (nums[i] - 2) / 6;
                } else if (i == j) {
                    // 相当于 C(n,2) * k的数量
                    count += nums[i] * (nums[i] - 1) / 2 * nums[k];
                } else if (j < k) {
                    // 相当于三者数量相乘
                    count += nums[i] * nums[j] * nums[k];
                }
            }
        }

        return (int)(count % (1e9 + 7));
    }

    public int threeSumMulti_n2(int[] arr, int target) {
        // 明确，数组的顺序不会影响结果
        // 先对数组排序
        //Arrays.sort(arr);
        // 统计各数字出现次数
        long count = 0;
        // map存储 k-v，表示当之前两数和为 k的数量；
        // 因此当遍历到 arr[i]时，我们取 map.get(target - arr[i])即可获得以 i 结尾的满足target的数量
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count = count + map.getOrDefault(target - arr[i], 0);

            for (int j = 0; j < i; j++) {
                int tmp = arr[i] + arr[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        return (int)(count % 10000000007L);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
