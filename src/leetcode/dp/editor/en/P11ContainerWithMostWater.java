//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the iᵗʰ line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can 
//contain is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics Array Two Pointers Greedy 👍 15852 👎 915


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-05 20:29:22
 * @title: Container With Most Water
 */
public class P11ContainerWithMostWater {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height));

        height = new int[] {1, 1};
        System.out.println(solution.maxArea(height));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // 按最大width逐渐缩短
        // 先取[0,n-1]，则 area = (n-1-0) * min(height[0], height[n-1])
        // 0和n-1中取短的那一边进行移动，直到找到比它长的
        // 假设height[0] < height[n-1]，则从1开始找到比height[0]长的，更新area
        int n = height.length;
        int area = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                area = Math.max(area, (right - left) * height[left]);
                int hL = height[left++];
                while (left < right && hL >= height[left]) {
                    left++;
                }
            } else if (height[left] > height[right]) {
                area = Math.max(area, (right - left) * height[right]);
                int rL = height[right--];
                while (left < right && rL >= height[right]) {
                    right--;
                }
            } else {
                area = Math.max(area, (right - left) * height[left]);
                int hL = height[left++];
                while (left < right && hL >= height[left]) {
                    left++;
                }
                int rL = height[right--];
                while (left < right && rL >= height[right]) {
                    right--;
                }
            }
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
