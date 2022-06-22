//You are given an array of words where each word consists of lowercase English 
//letters. 
//
// wordA is a predecessor of wordB if and only if we can insert exactly one 
//letter anywhere in wordA without changing the order of the other characters to make 
//it equal to wordB. 
//
// 
// For example, "abc" is a predecessor of "abac", while "cba" is not a 
//predecessor of "bcad". 
// 
//
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, 
//where word1 is a predecessor of word2, word2 is a predecessor of word3, and so 
//on. A single word is trivially a word chain with k == 1. 
//
// Return the length of the longest possible word chain with words chosen from 
//the given list of words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["a","b","ba","bca","bda","bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
// 
//
// Example 2: 
//
// 
//Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//Output: 5
//Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", 
//"pcxbc", "pcxbcf"].
// 
//
// Example 3: 
//
// 
//Input: words = ["abcd","dbqca"]
//Output: 1
//Explanation: The trivial word chain ["abcd"] is one of the longest word 
//chains.
//["abcd","dbqca"] is not a valid word chain because the ordering of the 
//letters is changed.
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] only consists of lowercase English letters. 
// 
// Related Topics Array Hash Table Two Pointers String Dynamic Programming 👍 44
//71 👎 185


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest String Chain
 * 
 * @author: eumes
 * @date: 2022-06-16 01:10:10
 */
 public class P1048LongestStringChain {
    public static void main(String[] args) {
//        Solution_P1048 solution = new Solution_P1048();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1048 {
    public int longestStrChain(String[] words) {
        int res = 0;
        // 按字符串长度排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // map 记录 以 该字符串结尾的 最大链长度
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            int best = 0;
            StringBuilder builder = new StringBuilder(word);
            // 尝试去除第i个字符，寻找pre字符串并更新链长度
            for (int i = 0; i < word.length(); i++) {
                builder.deleteCharAt(i);
                best = Math.max(best, map.getOrDefault(builder.toString(), 0) + 1);
                builder.insert(i, word.charAt(i));
            }
            map.put(word, best);
            res = Math.max(res, best);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
