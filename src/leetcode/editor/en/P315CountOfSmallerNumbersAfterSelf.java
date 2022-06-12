//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller 
//elements to the right of nums[i]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// 
//
// Example 2: 
//
// 
//Input: nums = [-1]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,-1]
//Output: [0,0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree 
//Segment Tree Merge Sort Ordered Set 👍 5613 👎 159


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

/**
 * Count of Smaller Numbers After Self
 * 
 * @author: eumes
 * @date: 2022-06-08 22:44:50
 */
 public class P315CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
//        Solution_P315 solution = new Solution_P315();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P315 {
    // 记录结果
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        // 记录归并排序中，原有下标位置现在的元素原有下标
        // index表示排好序的数组，其中index[i]表示原数组中位置为index[i]的，排序后应该在位置i上
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        // 归并排序，在此过程中统计逆序对数量
        mergeSort(nums, index, new int[nums.length], 0, nums.length - 1);

        List<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    // 归并排序[le, ri]中数组nums，其中index[i]表示初始nums数组中index[i]位置上的元素应放在位置i上
    private void mergeSort(int[] nums, int[] index, int[] tmpIdx, int le, int ri) {
        if (le == ri) {
            return;
        }

        int mid = le + ((ri - le) >> 1);
        mergeSort(nums, index, tmpIdx, le, mid);
        mergeSort(nums, index, tmpIdx, mid + 1, ri);

        merge(nums, index, tmpIdx, le, mid, ri);
    }

    // 合并以mid为分界线的排好序的左右数组[le, mid]和[mid + 1, ri]
    private void merge(int[] nums, int[] index, int[] tmpIdx, int le, int mid, int ri) {
        // 左右指针，rc表示右边数组中比左边数组中数字小的数量
        int ldx = le, rdx = mid + 1;
        int rc = 0;
        // copy出一份index信息，方便修改index数组
        if (ri + 1 - le >= 0) System.arraycopy(index, le, tmpIdx, le, ri + 1 - le);

        // 注意 ，索引的左右是分别排好序的，而nums表示的是原始数组
        // 双指针，合并两个数组，实质是更新位置信息
        for (int i = le; i <= ri; i++) {
            if (ldx > mid) {
                // 左边数组结束，右边数组中数字直接延后加上
                index[i] = tmpIdx[rdx++];
            } else if (rdx > ri) {
                // 右边数组完成，左边数组中数字要挪到后边
                index[i] = tmpIdx[ldx++];
                // 此时原位置i的逆序对数量为 +rc
                count[index[i]] += rc;
            } else if (nums[tmpIdx[ldx]] > nums[tmpIdx[rdx]]) {
                // 右边小，此时选择右边放到位置i上，此时右边小的数+1
                index[i] = tmpIdx[rdx++];
                rc++;
            } else {
                // 左边小，此时选择左边放到位置 i 上
                index[i] = tmpIdx[ldx++];
                // 当前位置 i （原先位置index[i]），原先右边比它小的数量为统计的已放置的右边的数量
                count[index[i]] += rc;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
