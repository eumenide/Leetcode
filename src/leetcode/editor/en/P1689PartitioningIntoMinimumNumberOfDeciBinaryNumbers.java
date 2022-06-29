//A decimal number is called deci-binary if each of its digits is either 0 or 1 
//without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 
//and 3001 are not. 
//
// Given a string n that represents a positive decimal integer, return the 
//minimum number of positive deci-binary numbers needed so that they sum up to n. 
//
// 
// Example 1: 
//
// 
//Input: n = "32"
//Output: 3
//Explanation: 10 + 11 + 11 = 32
// 
//
// Example 2: 
//
// 
//Input: n = "82734"
//Output: 8
// 
//
// Example 3: 
//
// 
//Input: n = "27346209830709182346"
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 1 <= n.length <= 10⁵ 
// n consists of only digits. 
// n does not contain any leading zeros and represents a positive integer. 
// 
// Related Topics String Greedy 👍 1436 👎 971


package leetcode.editor.en;

/**
 * Partitioning Into Minimum Number Of Deci-Binary Numbers
 * 
 * @author: eumes
 * @date: 2022-06-27 22:07:48
 */
 public class P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
//        Solution_P1689 solution = new Solution_P1689();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1689 {
    public int minPartitions(String n) {
        // 结果就是最大的数字
        int res = 0;
        for (char ch : n.toCharArray()) {
            res = Math.max(ch - '0', res);
            if (res == 9) {
                return 9;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
