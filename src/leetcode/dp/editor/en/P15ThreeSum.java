//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 17009 👎 1640


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: eumes
 * @date: 2022-04-07 00:15:14
 * @title: 3Sum
 */
public class P15ThreeSum {
    
    public static void main(String[] args) {
        Solution_15 solution = new Solution_15();
        // TO TEST
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));

        System.out.println(solution.threeSum(new int[] {}));
        System.out.println(solution.threeSum(new int[] {0}));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 重复
                continue;
            }

            // 双指针，一头一尾找符合条件的
            int le = i + 1, ri = nums.length - 1;
            while (le < ri) {
                // 如果满足条件，则加一条结果
                int sum = nums[i] + nums[le] + nums[ri];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[le], nums[ri]));

                    // 右移指针 le，直到一个不相等的值
                    while (le < ri && nums[le] == nums[le + 1]) {
                        le++;
                    }
                    // 左移ri，直到一个不相等的值
                    while (le < ri && nums[ri] == nums[ri - 1]) {
                        ri--;
                    }
                    le++;
                    ri--;
                } else if (sum < 0) {
                    // nums[i] <= nums[le] <= nums[ri]，因此需要将le右移
                    le++;
                } else {
                    ri--;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
