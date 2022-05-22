//You are given an integer array nums with no duplicates. A maximum binary tree 
//can be built recursively from nums using the following algorithm: 
//
// 
// Create a root node whose value is the maximum value in nums. 
// Recursively build the left subtree on the subarray prefix to the left of the 
//maximum value. 
// Recursively build the right subtree on the subarray suffix to the right of 
//the maximum value. 
// 
//
// Return the maximum binary tree built from nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,1,6,0,5]
//Output: [6,3,5,null,2,0,null,null,1]
//Explanation: The recursive calls are as follow:
//- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right 
//suffix is [0,5].
//    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix 
//is [2,1].
//        - Empty array, so no child.
//        - The largest value in [2,1] is 2. Left prefix is [] and right suffix 
//is [1].
//            - Empty array, so no child.
//            - Only one element, so child is a node with value 1.
//    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is 
//[].
//        - Only one element, so child is a node with value 0.
//        - Empty array, so no child.
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [3,null,2,null,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// All integers in nums are unique. 
// 
// Related Topics Array Divide and Conquer Stack Tree Monotonic Stack Binary 
//Tree 👍 3686 👎 296


package leetcode.editor.en;

/**
 * Maximum Binary Tree
 * 
 * @author: eumes
 * @date: 2022-05-21 23:24:58
 */
 public class P654MaximumBinaryTree {
    public static void main(String[] args) {
//        Solution_P654 solution = new Solution_P654();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_P654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int le, int ri) {
        if (le > ri) {
            return null;
        }
        // 找最大值
        int idx = le, maxV = nums[le];
        for (int i = le; i <= ri; i++) {
            if (maxV < nums[i]) {
                idx = i;
                maxV = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxV);
        // 构造左右子树
        root.left = construct(nums, le, idx - 1);
        root.right = construct(nums, idx + 1, ri);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
