//Given a string array words, return the maximum value of length(word[i]) * 
//length(word[j]) where the two words do not share common letters. If no such two 
//words exist, return 0. 
//
// 
// Example 1: 
//
// 
//Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//Output: 16
//Explanation: The two words can be "abcw", "xtfn".
// 
//
// Example 2: 
//
// 
//Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
//Output: 4
//Explanation: The two words can be "ab", "cd".
// 
//
// Example 3: 
//
// 
//Input: words = ["a","aa","aaa","aaaa"]
//Output: 0
//Explanation: No such pair of words.
// 
//
// 
// Constraints: 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] consists only of lowercase English letters. 
// 
// Related Topics Array String Bit Manipulation 👍 2577 👎 104


package leetcode.editor.en;

import java.util.Map;

/**
 * Maximum Product of Word Lengths
 * 
 * @author: eumes
 * @date: 2022-05-29 23:45:28
 */
 public class P318MaximumProductOfWordLengths {
    public static void main(String[] args) {
//        Solution_P318 solution = new Solution_P318();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 充分利用位运算 - O(n ^ 2)
    public int maxProduct(String[] words) {
        int res = 0;
        int n = words.length;
        int[] bits = new int[n];

        for (int i = 0; i < n; i++) {
            String tmpI = words[i];
            // 比特位，从右往左，分别表示a~z是否存在；此处利用左移 和 或运算
            for (int j = 0; j < tmpI.length(); j++) {
                bits[i] |= (1 << (tmpI.charAt(j) - 'a'));
            }

            // 与之前的每个字符串比较，此处用与运算
            for (int j = 0; j < i; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, tmpI.length() * words[j].length());
                }
            }
        }

        return res;
    }

    // 暴力 - O(n^3)
    public int maxProduct_bruce(String[] words) {
        int res = 0;
        int n = words.length;
        // arr[i][j]表示第i个字符串是否包含字符'a' + j
        int[][] arr = new int[n][26];

        for (int i = 0; i < n; i++) {
            // 记录words[i]中的字符
            String tmpI = words[i];
            for (int j = 0; j < tmpI.length(); j++) {
                arr[i][tmpI.charAt(j) - 'a'] = 1;
            }

            // 和之前的每个字符串比较
            for (int j = 0; j < i; j++) {
                String tmpJ = words[j];
                int k = 0;
                // 如果包含words[i]中的字符，则不符合条件；否则更新结果
                for (; k < tmpI.length(); k++) {
                    if (arr[j][tmpI.charAt(k) - 'a'] != 0) {
                        break;
                    }
                }

                if (k == tmpI.length()) {
                    res = Math.max(res, tmpI.length() * tmpJ.length());
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
