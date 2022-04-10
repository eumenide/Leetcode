//Given an integer array nums sorted in non-decreasing order, return an array 
//of the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, 
//could you find an O(n) solution using a different approach? Related Topics Array 
//Two Pointers Sorting 👍 5054 👎 148


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-09 02:19:39
 * @title: Squares of a Sorted Array
 */
public class P977SquaresOfASortedArray {
    
    public static void main(String[] args) {
        Solution_977 solution = new Solution_977();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = right;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[i--] = nums[right] * nums[right];
                right--;
            } else {
                res[i--] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }

    public int[] sortedSquares_1(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int i = right; i >= 0 && left < right; i--) {
            int lS = nums[left] * nums[left];
            int rS = nums[right] * nums[right];
            if (lS < rS) {
                res[i] = rS;
                right--;
            } else if (lS > rS) {
                res[i] = lS;
                left++;
            } else {
                res[i--] = lS;
                res[i] = rS;
                left++;
                right--;
            }
        }
        res[0] = nums[left] * nums[left];

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
