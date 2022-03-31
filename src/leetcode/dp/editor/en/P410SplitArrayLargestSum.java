//Given an array nums which consists of non-negative integers and an integer m, 
//you can split the array into m non-empty continuous subarrays. 
//
// Write an algorithm to minimize the largest sum among these m subarrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [7,2,5,10,8], m = 2
//Output: 18
//Explanation:
//There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8],
//where the largest sum among the two subarrays is only 18.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], m = 2
//Output: 9
// 
//
// Example 3: 
//
// 
//Input: nums = [1,4,4], m = 3
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics Array Binary Search Dynamic Programming Greedy 👍 5287 👎 136


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-31 22:43:15
 * @title: Split Array Largest Sum
 */
public class P410SplitArrayLargestSum {
    
    public static void main(String[] args) {
        Solution_410 solution = new Solution_410();
        // TO TEST
        int[] nums = new int[] {7, 2, 5, 10, 8};
        System.out.println(solution.splitArray(nums, 2));

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(solution.splitArray(nums, 2));

        nums = new int[] {1, 4, 4};
        System.out.println(solution.splitArray(nums, 3));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_410 {
    public int splitArray(int[] nums, int m) {
        // 可预想的最小值为 max(nums[])，最大值为 sum(nums[0] + ... + nums[len - m])
        // 在min 到 max 的解空间里，逐一取值，模拟划分nums[]，当满足要求时，即返回该值
        // 为减少模拟次数，可采用二分法取值
        // 复杂度 O(n * log(sum - max))
        int min = 0, max = 0;
        for (int num : nums) {
            min = Math.max(min, num);
            max += num;
        }

        while (min < max) {
            int mid = min +  (max - min) / 2;
            // 当目标值为mid时，模拟划分nums
            if (canSplit(nums, m, mid)) {
                // 如果可以划分，则往左取值（尝试取更小的值）
                max = mid;
            } else {
                // 不可以划分，则往右取值（尝试取更大的值）
                min = mid + 1;
            }
        }

        // 最后，min记录的可取的最小值
        return min;
    }

    private boolean canSplit(int[] nums, int m, int mid) {
        // 记录划分的次数
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 当该次累加大于 限定值
            if (sum > mid) {
                // 划分次数 + 1；重置累加值为当前值（相当于回退本次累计值，放入下次）
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
