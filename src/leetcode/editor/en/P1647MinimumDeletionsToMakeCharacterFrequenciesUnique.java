//A string s is called good if there are no two different characters in s that 
//have the same frequency. 
//
// Given a string s, return the minimum number of characters you need to delete 
//to make s good. 
//
// The frequency of a character in a string is the number of times it appears 
//in the string. For example, in the string "aab", the frequency of 'a' is 2, while 
//the frequency of 'b' is 1. 
//
// 
// Example 1: 
//
// 
//Input: s = "aab"
//Output: 0
//Explanation: s is already good.
// 
//
// Example 2: 
//
// 
//Input: s = "aaabbbcc"
//Output: 2
//Explanation: You can delete two 'b's resulting in the good string "aaabcc".
//Another way it to delete one 'b' and one 'c' resulting in the good string 
//"aaabbc". 
//
// Example 3: 
//
// 
//Input: s = "ceabaacb"
//Output: 2
//Explanation: You can delete both 'c's resulting in the good string "eabaab".
//Note that we only care about characters that are still in the string at the 
//end (i.e. frequency of 0 is ignored).
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s contains only lowercase English letters. 
// 
// Related Topics String Greedy Sorting 👍 2382 👎 42


package leetcode.editor.en;

import java.util.Arrays;

/**
 * Minimum Deletions to Make Character Frequencies Unique
 * 
 * @author: eumes
 * @date: 2022-06-28 23:10:47
 */
 public class P1647MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
//        Solution_P1647 solution = new Solution_P1647();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1647 {
    public int minDeletions(String s) {
        // 统计频率并排序
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);

        // 从后往前，和期望值比较，并计算需要删除的数量
        int exp = freq[25] - 1;
        int res = 0;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            if (freq[i] <= exp) {
                // 满足期望值，不需要删除
                exp = freq[i] - 1;
                continue;
            }
            // 需要删除的数量
            res += freq[i] - exp;

            // 期望值不能小于0
            if (exp > 0) {
                exp--;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
