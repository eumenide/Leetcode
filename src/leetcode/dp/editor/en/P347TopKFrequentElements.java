//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 8361 👎 353


package leetcode.dp.editor.en;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author: eumes
 * @date: 2022-04-09 18:27:29
 * @title: Top K Frequent Elements
 */
public class P347TopKFrequentElements {
    
    public static void main(String[] args) {
        Solution_347 solution = new Solution_347();
        // TO TEST
        
    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 频率表，key = 数值， value = 频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // 优先队列，最小堆
        PriorityQueue<Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.poll().getKey();
        }

        return res;
    }

    public int[] topKFrequent_1(int[] nums, int k) {
        // 各数字频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 桶排序
        List<Integer>[] buc = new List[nums.length + 1];
        map.forEach((key, v) -> {
            if (buc[v] == null) {
                buc[v] = new ArrayList<>();
            }
            buc[v].add(key);
        });

        int[] res = new int[k];
        int idx = k - 1;
        for (int i = nums.length; i >= 0 && idx >= 0; i--) {
            if (buc[i] != null) {
                for (int n : buc[i]) {
                    res[idx--] = n;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
