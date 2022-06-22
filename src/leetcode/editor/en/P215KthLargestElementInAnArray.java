//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 9534 👎 499


package leetcode.editor.en;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Kth Largest Element in an Array
 * 
 * @author: eumes
 * @date: 2022-06-15 01:16:17
 */
 public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
//        Solution_P215 solution = new Solution_P215();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P215 {

    // 利用快排，快速选择
    public int findKthLargest(int[] nums, int k) {
        // 先打乱
        shuffle(nums);
        int le = 0, ri = nums.length - 1;
        k--;
        while (le <= ri) {
            // 找到分界点位置piv
            int p = partition(nums, le, ri);
            if (p < k) {
                // 目标在右边
                le = p + 1;
            } else if (p > k) {
                // 目标在左边
                ri = p - 1;
            } else {
                // 找到了
                return nums[p];
            }
        }

        // 找不到
        return -1;
    }

    // 按降序来
    private int partition(int[] nums, int le, int ri) {
        int piv = nums[le];
        int i = le + 1, j = ri;
        while (i <= j) {
            // 找到左边第一个＜piv的
            while (i <= j && nums[i] >= piv) {
                i++;
            }
            // 找到右边第一个≥piv的
            while (i <= j && nums[j] < piv) {
                j--;
            }

            // 超过范围
            if (i >= j) {
                break;
            }

            // 交换i/j
            swap(nums, i, j);
        }

        // 将piv放到找到的位置j
        swap(nums, le, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random rd = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = rd.nextInt(n - i);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest_heap(int[] nums, int k) {
        // 小顶堆，堆顶是k个元素中最小的
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            // 维持k个元素
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
