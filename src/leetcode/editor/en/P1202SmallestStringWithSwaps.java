//You are given a string s, and an array of pairs of indices in the string 
//pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string. 
//
// You can swap the characters at any pair of indices in the given pairs any 
//number of times. 
//
// Return the lexicographically smallest string that s can be changed to after 
//using the swaps. 
//
// 
// Example 1: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2]]
//Output: "bacd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[1] and s[2], s = "bacd"
// 
//
// Example 2: 
//
// 
//Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//Output: "abcd"
//Explaination: 
//Swap s[0] and s[3], s = "bcad"
//Swap s[0] and s[2], s = "acbd"
//Swap s[1] and s[2], s = "abcd" 
//
// Example 3: 
//
// 
//Input: s = "cba", pairs = [[0,1],[1,2]]
//Output: "abc"
//Explaination: 
//Swap s[0] and s[1], s = "bca"
//Swap s[1] and s[2], s = "bac"
//Swap s[0] and s[1], s = "abc"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s only contains lower case English letters. 
// 
// Related Topics Hash Table String Depth-First Search Breadth-First Search 
//Union Find 👍 2263 👎 67


package leetcode.editor.en;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Smallest String With Swaps
 * 
 * @author: eumes
 * @date: 2022-04-27 22:44:08
 */
 public class P1202SmallestStringWithSwaps {
    public static void main(String[] args) {
//        Solution_P1202 solution = new Solution_P1202();
        // TO TEST
        // 这道题核心是要想到使用Union-Find的方式来解题。简单来说就是分组。pairs中的数字对代表可以两两交换的元素，比如第一位和第二位可以交换，第二位和第五位可以交换，继而可得出，第1，2，5这三位之间可以随意交换，这样我们可以将1，2，5位的三个元素由小到大排列即可。因此，问题就转化为，通过pairs找到所有不连通的集合，然后将各个集合升序排列，最后在组合到一起即是结果。

        // 1. 先将字符串分成N组。（N为字符串长度）
        // 2. 通过pairs找到所有不重合的组。
        // 3. 将每一组排序
        // 4. 循环字符串，查看当前位属于哪一组，并输出所属组中最小的元素。

        // 编码时，使用union方法进行分组，root方法查找字符串当前位属于哪一组。利用PriorityQueue为组内元素排序。
        // https://leetcode.jp/leetcode-1202-smallest-string-with-swaps-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 记录每个位置的根
    int[] union;
    // 记录每个分组 及其 对应的字符；此处利用优先队列排序
    Map<Integer, PriorityQueue<Character>> queueMap;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        union = new int[s.length()];
        queueMap = new HashMap<>();
        // 初始化，每个点各自成集合
        for (int i = 0; i < s.length(); i++) {
            union[i] = i;
        }

        // 合并每个pair对应的2个集合
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        // 对于每个字符，先寻找分组，再加入分组中进行排序
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            PriorityQueue<Character> queue = queueMap.getOrDefault(root, new PriorityQueue<>());
            queue.offer(s.charAt(i));

            queueMap.put(root, queue);
        }

        // 按分组，组装排好序的字符串
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            // 找到i所在分组中的最小字符
            builder.append(queueMap.get(root).poll());
        }

        return builder.toString();
    }

    // 合并两个集合
    private void union(int p1, int p2) {
        // 将p1根的根设为p2的根，即将p1、p2所在的两个集合合并
        union[find(p1)] = find(p2);
    }

    // 找到idx的根
    private int find(int idx) {
        int i = idx;
        // 值为本身下标的，都是根
        while (union[i] != i) {
            i = union[i];
        }

        // 更新idx的根
        union[idx] = i;
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
