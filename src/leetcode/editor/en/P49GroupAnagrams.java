////Given an array of strings strs, group the anagrams together. You can return 
//
////the answer in any order. 
////
//// An Anagram is a word or phrase formed by rearranging the letters of a 
////different word or phrase, typically using all the original letters exactly 
//once. 
////
//// 
//// Example 1: 
//// Input: strs = ["eat","tea","tan","ate","nat","bat"]
////Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//// Example 2: 
//// Input: strs = [""]
////Output: [[""]]
//// Example 3: 
//// Input: strs = ["a"]
////Output: [["a"]]
//// 
//// 
//// Constraints: 
////
//// 
//// 1 <= strs.length <= 10⁴ 
//// 0 <= strs[i].length <= 100 
//// strs[i] consists of lowercase English letters. 
//// 
//// Related Topics Hash Table String Sorting 👍 8945 👎 308
//


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 * 
 * @author: eumes
 * @date: 2022-04-16 23:29:25
 */
 public class P49GroupAnagrams {
    public static void main(String[] args) {
        Solution_P49 solution = new Solution_P49();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] freq = new char[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            String key = String.valueOf(freq);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
