//Given an array of non-negative integers nums, you are initially positioned at 
//the first index of the array. 
//
// Each element in the array represents your maximum jump length at that 
//position. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// You can assume that you can always reach the last index. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming Greedy 👍 7470 👎 279


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-03-16 22:20:29
 * @title: Jump Game II
 */
public class P45JumpGameIi {
    
    public static void main(String[] args) {
        Solution_45 solution = new Solution_45();
        // TO TEST
        int[] nums = new int[] {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
        nums = new int[] {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums));

        nums = new int[] {2, 1};
        System.out.println(solution.jump(nums));
        nums = new int[] {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
        nums = new int[] {2, 3, 1, 1, 1, 4};
        System.out.println(solution.jump(nums));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_45 {
    public int jump(int[] nums) {
        // 当前从上一位置跳到right，rightFurthest表示[上一位置,right]中任意位置起跳，能跳到的最远位置
        //  则从该位置跳到最远位置，跳跃次数+1，重置right
        int right = 0;
        int jumpNum = 0;
        int rightFurthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 到当前位置时，所能跳到的最远位置
            rightFurthest = Math.max(rightFurthest, i + nums[i]);
            // right即为上一次跳跃后的最远位置
            // 当到达上一次跳跃后的最远位置后，再次跳跃 & 重置最远位置
            if (i == right) {
                jumpNum++;
                right = rightFurthest;
            }
        }

        return jumpNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
