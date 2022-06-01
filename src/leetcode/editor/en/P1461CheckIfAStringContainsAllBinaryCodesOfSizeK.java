//Given a binary string s and an integer k, return true if every binary code of 
//length k is a substring of s. Otherwise, return false. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110110", k = 2
//Output: true
//Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They 
//can be all found as substrings at indices 0, 1, 3 and 2 respectively.
// 
//
// Example 2: 
//
// 
//Input: s = "0110", k = 1
//Output: true
//Explanation: The binary codes of length 1 are "0" and "1", it is clear that 
//both exist as a substring. 
// 
//
// Example 3: 
//
// 
//Input: s = "0110", k = 2
//Output: false
//Explanation: The binary code "00" is of length 2 and does not exist in the 
//array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 5 * 10⁵ 
// s[i] is either '0' or '1'. 
// 1 <= k <= 20 
// 
// Related Topics Hash Table String Bit Manipulation Rolling Hash Hash Function 
//👍 1589 👎 78


package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

/**
 * Check If a String Contains All Binary Codes of Size K
 * 
 * @author: eumes
 * @date: 2022-06-01 00:39:54
 */
 public class P1461CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
//        Solution_P1461 solution = new Solution_P1461();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1461 {

    // 将01串转成数字，长度为k的01串组成的左右数字应该是[0, 2 ^ k - 1]
    public boolean hasAllCodes(String s, int k) {
        // 使用boolean数组表示数字i是否存在
        boolean[] flag = new boolean[1 << k];

        // 滑动窗口，窗口大小为k，计算窗口表示的数字，并更新flag
        int num = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            num = (num << 1) + s.charAt(j) - '0';
            if (j - i + 1 == k) {
                // 窗口大小为k
                flag[num] = true;
                // 缩减窗口
                num -= (s.charAt(i++) - '0') << (k - 1);
            }
        }

        // 只有flag中所有数字都存在，才满足要求
        for (boolean f : flag) {
            if (!f) {
                return false;
            }
        }
        return true;
    }

    // 利用string的hash，效率非常低
    public boolean hasAllCodes_string(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
        }

        return set.size() == k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
