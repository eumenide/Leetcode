//Design a special dictionary with some words that searchs the words in it by a 
//prefix and a suffix. 
//
// Implement the WordFilter class: 
//
// 
// WordFilter(string[] words) Initializes the object with the words in the 
//dictionary. 
// f(string prefix, string suffix) Returns the index of the word in the 
//dictionary, which has the prefix prefix and the suffix suffix. If there is more than 
//one valid index, return the largest of them. If there is no such word in the 
//dictionary, return -1. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//Output
//[null, 0]
//
//Explanation
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = 
//"a" and suffix = 'e".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 15000 
// 1 <= words[i].length <= 10 
// 1 <= prefix.length, suffix.length <= 10 
// words[i], prefix and suffix consist of lower-case English letters only. 
// At most 15000 calls will be made to the function f. 
// 
// Related Topics String Design Trie 👍 1716 👎 413


package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

/**
 * Prefix and Suffix Search
 * 
 * @author: eumes
 * @date: 2022-06-19 00:12:06
 */
 public class P745PrefixAndSuffixSearch {
    public static void main(String[] args) {
//        Solution_P745 solution = new Solution_P745();
        // TO TEST
        char SEP = 'z' + 1;
        System.out.println(SEP);
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
// 字典树解法
class WordFilter {

    // 第27个为分割符
    public static final char SEP = 'z' + 1;

    private static class TrieNode {
        TrieNode[] children;
        int idx;

        public TrieNode() {
            // 小写字母 + 分割符，27个
            this.children = new TrieNode[27];
            this.idx = 0;
        }
    }

    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = SEP + words[i];
            // 先插入无后缀的
            insert(root, word, i);
            for (int j = 0; j < word.length(); j++) {
                // 循环从第1个开始取后缀，跳过SEP
                insert(root, word.substring(j + 1) + word, i);
            }
        }
    }

    private void insert(TrieNode root, String word, int idx) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            // ch在字典树中的root的children中的位置
            int k = ch - 'a';
            if (cur.children[k] == null) {
                // 新插入
                cur.children[k] = new TrieNode();
            }
            // 更新最新的idx
            cur.children[k].idx = idx;
            cur = cur.children[k];
        }
    }

    public int f(String prefix, String suffix) {
        // 需要找的是 后缀 + SEP + 前缀
        String word = suffix + SEP + prefix;
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int k = ch - 'a';
            // 没有直接返回-1
            if (cur.children[k] == null) {
                return -1;
            }
            // 否则，继续往下找
            cur = cur.children[k];
        }

        return cur.idx;
    }
}

// 使用map存储所有的前缀后缀词
class WordFilter_all {

    Map<String, Integer> map;
    public WordFilter_all(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                for (int k = 0; k <= words[i].length(); k++) {
                    // 前缀 + # + 后缀
                    map.put(words[i].substring(0, j) + "#" + words[i].substring(words[i].length() - k), i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
//leetcode submit region end(Prohibit modification and deletion)
