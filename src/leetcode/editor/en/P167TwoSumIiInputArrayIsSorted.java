//Given a 1-indexed array of integers numbers that is already sorted in non-
//decreasing order, find two numbers such that they add up to a specific target 
//number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1
// < index2 <= numbers.length. 
//
// Return the indices of the two numbers, index1 and index2, added by one as an 
//integer array [index1, index2] of length 2. 
//
// The tests are generated such that there is exactly one solution. You may not 
//use the same element twice. 
//
// Your solution must use only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// Example 2: 
//
// 
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We 
//return [1, 3].
// 
//
// Example 3: 
//
// 
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We 
//return [1, 2].
// 
//
// 
// Constraints: 
//
// 
// 2 <= numbers.length <= 3 * 10⁴ 
// -1000 <= numbers[i] <= 1000 
// numbers is sorted in non-decreasing order. 
// -1000 <= target <= 1000 
// The tests are generated such that there is exactly one solution. 
// 
// Related Topics Array Two Pointers Binary Search 👍 5339 👎 935


package leetcode.editor.en;

/**
 * Two Sum II - Input Array Is Sorted
 * 
 * @author: eumes
 * @date: 2022-05-07 00:47:22
 */
 public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
//        Solution_P167 solution = new Solution_P167();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P167 {
    public int[] twoSum(int[] numbers, int target) {
        int le = 0, ri = numbers.length - 1;
        while (le < ri) {
            int sum = numbers[le] + numbers[ri];
            if (sum == target) {
                return new int[]{le + 1, ri + 1};
            } else if (sum < target) {
                le++;
            } else {
                ri--;
            }
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
