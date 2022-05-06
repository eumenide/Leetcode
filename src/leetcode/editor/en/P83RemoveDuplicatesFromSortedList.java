//Given the head of a sorted linked list, delete all duplicates such that each 
//element appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List 👍 4729 👎 184


package leetcode.editor.en;

import leetcode.dp.editor.en.ListNode;

/**
 * Remove Duplicates from Sorted List
 * 
 * @author: eumes
 * @date: 2022-05-07 00:08:30
 */
 public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
//        Solution_P83 solution = new Solution_P83();
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
class Solution_P83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                if (slow != pre) {
                    pre.next = null;
                }
                slow.next = fast;
                slow = slow.next;
            }

            pre = fast;
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
