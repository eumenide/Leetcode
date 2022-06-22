//A valid encoding of an array of words is any reference string s and array of 
//indices indices such that: 
//
// 
// words.length == indices.length 
// The reference string s ends with the '#' character. 
// For each index indices[i], the substring of s starting from indices[i] and 
//up to (but not including) the next '#' character is equal to words[i]. 
// 
//
// Given an array of words, return the length of the shortest reference string 
//s possible of any valid encoding of words. 
//
// 
// Example 1: 
//
// 
//Input: words = ["time", "me", "bell"]
//Output: 10
//Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5
//].
//words[0] = "time", the substring of s starting from indices[0] = 0 to the 
//next '#' is underlined in "time#bell#"
//words[1] = "me", the substring of s starting from indices[1] = 2 to the next 
//'#' is underlined in "time#bell#"
//words[2] = "bell", the substring of s starting from indices[2] = 5 to the 
//next '#' is underlined in "time#bell#"
// 
//
// Example 2: 
//
// 
//Input: words = ["t"]
//Output: 2
//Explanation: A valid encoding would be s = "t#" and indices = [0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// words[i] consists of only lowercase letters. 
// 
// Related Topics Array Hash Table String Trie 👍 1281 👎 501


package leetcode.editor.en;

import java.util.*;

/**
 * Short Encoding of Words
 * 
 * @author: eumes
 * @date: 2022-06-20 23:41:16
 */
 public class P820ShortEncodingOfWords {
    public static void main(String[] args) {
//        Solution_P820 solution = new Solution_P820();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P820 {

     private static class TrieNode {
         TrieNode[] children;
         int depth;
         public TrieNode() {}
     }

    public int minimumLengthEncoding(String[] words) {
        // 去重
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<TrieNode> list = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode cur;
        for (String word : set) {
            cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int k = word.charAt(i) - 'a';
                if (cur.children == null) {
                    cur.children = new TrieNode[27];
                }
                if (cur.children[k] == null) {
                    cur.children[k] = new TrieNode();
                }

                cur = cur.children[k];
                cur.depth = word.length() + 1;

                list.add(cur);
            }
        }

        int res = 0;
        for (TrieNode node : list) {
            if (node.children == null) {
                res += node.depth;
            }
        }
        return res;
    }

    public int minimumLengthEncoding_set(String[] words) {
        // set存储所有word
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            // 针对每个word，去除set中的后缀
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        // 计算结果长度
        int res = 0;
        for (String word : set) {
            res += word.length() + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
