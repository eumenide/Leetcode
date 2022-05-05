//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 12019 👎 469


package leetcode.editor.en;

import leetcode.dp.editor.en.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k Sorted Lists
 * 
 * @author: eumes
 * @date: 2022-05-04 13:19:43
 */
 public class P23MergeKSortedLists {
    public static void main(String[] args) {
//        Solution_P23 solution = new Solution_P23();
        // TO TEST
        
    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_P23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先队列模拟最小堆
        PriorityQueue<ListNode> minH = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode n : lists) {
            if (n != null) {
                minH.offer(n);
            }
        }

        while (!minH.isEmpty()) {
            ListNode node = minH.poll();
            p.next = node;
            if (node.next != null) {
                minH.offer(node.next);
            }

            p = p.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
