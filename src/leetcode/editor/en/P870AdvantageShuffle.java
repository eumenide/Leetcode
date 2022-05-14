//You are given two integer arrays nums1 and nums2 both of the same length. The 
//advantage of nums1 with respect to nums2 is the number of indices i for which 
//nums1[i] > nums2[i]. 
//
// Return any permutation of nums1 that maximizes its advantage with respect to 
//nums2. 
//
// 
// Example 1: 
// Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//Output: [2,11,7,15]
// Example 2: 
// Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//Output: [24,32,8,12]
// 
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
// Related Topics Array Greedy Sorting 👍 1237 👎 79


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Advantage Shuffle
 * 
 * @author: eumes
 * @date: 2022-05-14 22:47:18
 */
 public class P870AdvantageShuffle {
    public static void main(String[] args) {
//        Solution_P870 solution = new Solution_P870();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // num1升序，num2降序，且需记录索引
        Arrays.sort(nums1);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }

        // 每次取n2的最大值，此时决策如下：
        // 1. 如果n1最大值比他大，则选择n1最大值
        // 2. 否则，放弃赢，选择最小值
        int le = 0, ri = n - 1;
        int[] res = new int[n];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int maxV = poll[1];
            if (nums1[ri] > maxV) {
                res[i] = nums1[ri--];
            } else {
                res[i] = nums1[le++];
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
