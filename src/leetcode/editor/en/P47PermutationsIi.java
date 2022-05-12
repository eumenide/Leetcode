//Given a collection of numbers, nums, that might contain duplicates, return 
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 👍 5468 👎 96


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations II
 * 
 * @author: eumes
 * @date: 2022-05-13 01:18:57
 */
 public class P47PermutationsIi {
    public static void main(String[] args) {
//        Solution_P47 solution = new Solution_P47();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums, new ArrayList<>(), res);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 从Nums中挑选下一个
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            // 若标记已重复，则继续下一个
            if (tmp == 11 || i > 0 && tmp == nums[i - 1]) {
                continue;
            }
            // 标记当前已访问
            nums[i] = 1;
            list.add(tmp);
            backTrace(nums, list, res);
            // 回退
            list.remove(list.size() - 1);
            nums[i] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
