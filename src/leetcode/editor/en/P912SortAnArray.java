//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge 
//Sort Bucket Sort Radix Sort Counting Sort 👍 2194 👎 530


package leetcode.editor.en;

import java.util.Random;

/**
 * Sort an Array
 * 
 * @author: eumes
 * @date: 2022-06-07 00:40:08
 */
 public class P912SortAnArray {
    public static void main(String[] args) {
//        Solution_P912 solution = new Solution_P912();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P912 {
    int[] tmpA;
    public int[] sortArray(int[] nums) {
        tmpA = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 归并排序[le, ri]
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
        // copy数组
        for (int i = le; i <= ri; i++) {
            tmpA[i] = nums[i];
        }

        // 双指针
        int i = le, j = mid + 1;
        for (int idx = le; idx <= ri; idx++) {
            if (i > mid) {
                nums[idx] = tmpA[j++];
            } else if (j > ri) {
                nums[idx] = tmpA[i++];
            } else if (tmpA[i] <= tmpA[j]) {
                nums[idx] = tmpA[i++];
            } else {
                nums[idx] = tmpA[j++];
            }
        }
    }
}

class QuickSort {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int le, int ri) {
        // 终止条件
        if (le >= ri) {
            return;
        }

        // 先排好一个元素
        int p = partition(nums, le, ri);
        // 递归快速排序左边&右边
        quickSort(nums, le, p - 1);
        quickSort(nums, p + 1, ri);
    }

    // 排好一个元素的位置p，使得p左边均≤它，右边均＞它
    private int partition(int[] nums, int le, int ri) {
        int piv = nums[le];
        int i = le + 1, j = ri;
        while (i <= j) {
            // 先找到左边第一个＞piv的位置
            while (i <= j && nums[i] <= piv) {
                i++;
            }
            // 再找到右边第一个≤piv的位置
            while (i <= j && nums[j] > piv) {
                j--;
            }

            // 超出范围，直接跳出
            if (i >= j) {
                break;
            }

            // 交换i/j
            swap(nums, i, j);
        }

        // 将piv放到找到的位置j上
        swap(nums, le, j);
        return j;
    }

    // 打乱
    private void shuffle(int[] nums) {
        Random rd = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = rd.nextInt(n - i);
            swap(nums, i, idx);
        }
    }

    // 交换nums中的两个位置
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
