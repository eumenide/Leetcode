//Given an array of non-negative integers arr, you are initially positioned at 
//start index of the array. When you are at index i, you can jump to i + arr[i] or 
//i - arr[i], check if you can reach to any index with value 0. 
//
// Notice that you can not jump outside of the array at any time. 
//
// 
// Example 1: 
//
// 
//Input: arr = [4,2,3,0,3,1,2], start = 5
//Output: true
//Explanation: 
//All possible ways to reach at index 3 with value 0 are: 
//index 5 -> index 4 -> index 1 -> index 3 
//index 5 -> index 6 -> index 4 -> index 1 -> index 3 
// 
//
// Example 2: 
//
// 
//Input: arr = [4,2,3,0,3,1,2], start = 0
//Output: true 
//Explanation: 
//One possible way to reach at index 3 with value 0 is: 
//index 0 -> index 4 -> index 1 -> index 3
// 
//
// Example 3: 
//
// 
//Input: arr = [3,0,2,1,2], start = 2
//Output: false
//Explanation: There is no way to reach at index 1 with value 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// 0 <= arr[i] < arr.length 
// 0 <= start < arr.length 
// 
// Related Topics Array Depth-First Search Breadth-First Search 👍 2537 👎 60


package leetcode.dp.editor.en;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2022-03-16 22:20:43
 * @title: Jump Game III
 */
public class P1306JumpGameIii {
    
    public static void main(String[] args) {
        Solution_1306 solution = new Solution_1306();
        // TO TEST

        String s = "011010";
        int minJump = 2, maxJump = 3;
        System.out.println(solution.canReach(s, minJump, maxJump));

        s = "01101110";
        System.out.println(solution.canReach(s,minJump, maxJump));
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_1306 {

    /**
     * 超时  O(n * m)
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    public boolean canReach_exceed(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }

        boolean[] canReach = new boolean[s.length()];
        canReach[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!canReach[i]) {
                continue;
            }
            for (int j = i + minJump; j <= i + maxJump; j++) {
                if (j >= s.length()) {
                    return canReach[s.length() - 1];
                }
                canReach[j] = s.charAt(j) == '0';
            }
        }

        return canReach[s.length() - 1];
    }

    /**
     * dp + 滑动窗口
     *
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }

        boolean[] canReach = new boolean[s.length()];
        canReach[0] = true;
        int pre = 0;
        for (int i = 1; i < s.length(); i++) {
            // 第i个能否到达，取决于：
            // 1. i是 0
            // 2. [i - maxJump, i - minJump]中有可以到达的
            // pre记录滑动窗口中可达到的数量，每次向右移动1步窗口，都要处理两个边界值
            if (i >= minJump && canReach[i - minJump]) {
                // 新的右边界，可到达，则pre+1
                pre++;
            }
            if (i > maxJump && canReach[i - maxJump - 1]) {
                // 旧的左边界可到达，则pre-1
                pre--;
            }

            canReach[i] = pre > 0 && s.charAt(i) == '0';
        }

        return canReach[s.length() - 1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
