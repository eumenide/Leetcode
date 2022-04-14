//A permvoidutatioint[]n ointf aintn array of integers is an arrangement of its members into a
//sequence or linear order. 
//
// 
// For example, for arr = [1,2,3], the following are considered permutations of 
//arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1]. 
// 
//
// The next permutation of an array of integers is the next lexicographically 
//greater permutation of its integer. More formally, if all the permutations of the 
//array are sorted in one container according to their lexicographical order, 
//then the next permutation of that array is the permutation that follows it in the 
//sorted container. If such arrangement is not possible, the array must be 
//rearranged as the lowest possible order (i.e., sorted in ascending order). 
//
// 
// For example, the next permutation of arr = [1,2,3] is [1,3,2]. 
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2]. 
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does 
//not have a lexicographical larger rearrangement. 
// 
//
// Given an array of integers nums, find the next permutation of nums. 
//
// The replacement must be in place and use only constant extra memory. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,1]
//Output: [1,2,3]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,1,5]
//Output: [1,5,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics Array Two Pointers 👍 9895 👎 3263


package leetcode.dp.editor.en;

import java.util.Arrays;

/**
 * @author: eumes
 * @date: 2022-04-03 22:49:56
 * @title: Next Permutation
 */
public class P31NextPermutation {
    
    public static void main(String[] args) {
        Solution_31 solution = new Solution_31();
        // TO TEST
        int[] nums = new int[] {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1, 1, 5};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_31 {
    public void nextPermutation(int[] nums) {
        // 1,2,6,5,4,3,0
        int i = nums.length - 2;
        // 从右往左，找到第一个破坏单调性的 i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 此时，不是全 减；若i=0，代表此时数组为全减，直接反转即可
        if (i >= 0) {
            // 从右往左，找到第一个 > i 的 j
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换，i 和 j
            swap(nums, i, j);
        }
        // 将 i 右边的反转
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
