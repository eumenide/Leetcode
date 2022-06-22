//You are given an array of strings products and a string searchWord. 
//
// Design a system that suggests at most three product names from products 
//after each character of searchWord is typed. Suggested products should have common 
//prefix with searchWord. If there are more than three products with a common 
//prefix return the three lexicographically minimums products. 
//
// Return a list of lists of the suggested products after each character of 
//searchWord is typed. 
//
// 
// Example 1: 
//
// 
//Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], 
//searchWord = "mouse"
//Output: [
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//Explanation: products sorted lexicographically = ["mobile","moneypot",
//"monitor","mouse","mousepad"]
//After typing m and mo all products match and we show user ["mobile",
//"moneypot","monitor"]
//After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
// 
//
// Example 2: 
//
// 
//Input: products = ["havana"], searchWord = "havana"
//Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// Example 3: 
//
// 
//Input: products = ["bags","baggage","banner","box","cloths"], searchWord = 
//"bags"
//Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage",
//"bags"],["bags"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= products.length <= 1000 
// 1 <= products[i].length <= 3000 
// 1 <= sum(products[i].length) <= 2 * 10⁴ 
// All the strings of products are unique. 
// products[i] consists of lowercase English letters. 
// 1 <= searchWord.length <= 1000 
// searchWord consists of lowercase English letters. 
// 
// Related Topics Array String Trie 👍 3003 👎 151


package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Search Suggestions System
 * 
 * @author: eumes
 * @date: 2022-06-19 21:20:44
 */
 public class P1268SearchSuggestionsSystem {
    public static void main(String[] args) {
//        Solution_P1268 solution = new Solution_P1268();
        // TO TEST
        System.out.println(~(-1));
        System.out.println(~(-10));
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_P1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);

        // 循环取searchWord的每个前缀，在products中找匹配
        for (int i = 1; i <= searchWord.length(); i++) {
            String word = searchWord.substring(0, i);

            // 二分查找，找到word在products中应在的位置
            int idx = findWord(products, word);
            // 往后最多找符合条件的3项
            List<String> sugg = new ArrayList<>();
            for (int j = 0; idx < products.length && j < 3 && products[idx].startsWith(word); j++, idx++) {
                sugg.add(products[idx]);
            }
            res.add(sugg);
        }

        return res;
    }

    private int findWord(String[] products, String word) {
        int n = products.length;
        int le = 0, ri = n - 1;
        while (le <= ri) {
            int mid = le + ((ri - le) >> 1);
            if (products[mid].compareTo(word) < 0) {
                le = mid + 1;
            } else {
                ri = mid - 1;
            }
        }

        return le;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
