//Given an integer array nums, return the number of reverse pairs in the array. 
//
//
// A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 
//2 * nums[j]. 
//
// 
// Example 1: 
// Input: nums = [1,3,2,3,1]
//Output: 2
// Example 2: 
// Input: nums = [2,4,3,5,1]
//Output: 3
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 3051 👎 186


package leetcode.editor.en;

/**
 * Reverse Pairs
 * 
 * @author: eumes
 * @date: 2022-06-10 01:29:42
 */
 public class P493ReversePairs {
    public static void main(String[] args) {
//        Solution_P493 solution = new Solution_P493();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P493 {
    // 临时数组，复制使用
    int[] tmpA;
    // 结果
    int count;
    public int reversePairs(int[] nums) {
        tmpA = new int[nums.length];
        count = 0;

        // 利用归并排序中的合并步骤，统计这个数量
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int le, int ri) {
        if (le == ri) {
            return;
        }

        int mid = le + ((ri - le) >> 1);
        mergeSort(nums, le, mid);
        mergeSort(nums, mid + 1, ri);
        merge(nums, le, mid, ri);
    }

    private void merge(int[] nums, int le, int mid, int ri) {
        // 复制数组，归并排序部分
        for (int i = le; i <= ri; i++) {
            tmpA[i] = nums[i];
        }

        // 这里计算count值
        int i = le, j = mid + 1;
        // 当nums[i] > 2 * nums[j]时，nums[i]同时也满足 > 2 * nums[mid+1,...,j]
        for (; i <= mid; i++) {
            // 找到第一个不满足的j
            while (j <= ri && (long) nums[i] > (long) 2 * nums[j]) {
                j++;
            }
            // 此时 nums[i] > 2 * nums[mid+1, ... , j)
            count += j - mid - 1;
        }

        // 归并排序合并部分
        i = le;
        j = mid + 1;
        for (int k = le; k <= ri; k++) {
            if (i > mid) {
                // 左边排完
                nums[k] = tmpA[j++];
            } else if (j > ri) {
                // 右边排完
                nums[k] = tmpA[i++];
            } else if (tmpA[i] > tmpA[j]) {
                // 右边小
                nums[k] = tmpA[j++];
            } else {
                nums[k] = tmpA[i++];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
