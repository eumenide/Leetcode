//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 4288 👎 0


package leetcode.stack.leetcode.editor.cn;

/**
 * @author: eumes
 * @date: 2021-07-27 00:51:02
 * @title: Median of Two Sorted Arrays
 */
public class P4MedianOfTwoSortedArrays {
    
    public static void main(String[] args) {
        Solution_4 solution4 = new Solution_4();
        // TO TEST
        int[] num1 = {1, 3};
        int[] num2 = {2};
        System.out.println(solution4.findMedianSortedArrays(num1, num2) == 2.0);

        num1 = new int[] {1, 2};
        num2 = new int[] {3, 4};
        System.out.println(solution4.findMedianSortedArrays(num1, num2) == 2.5);

        num1 = new int[] {0, 0};
        num2 = new int[] {0, 0};
        System.out.println(solution4.findMedianSortedArrays(num1, num2) == 0.0);

        num1 = new int[] {};
        num2 = new int[] {1};
        System.out.println(solution4.findMedianSortedArrays(num1, num2) == 1.0);
        System.out.println(solution4.findMedianSortedArrays(num2, num1) == 1.0);
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
