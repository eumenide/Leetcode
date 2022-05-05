//Given the head of a singly linked list, return the middle node of the linked 
//list. 
//
// If there are two middle nodes, return the second middle node. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we 
//return the second one.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 100]. 
// 1 <= Node.val <= 100 
// 
// Related Topics Linked List Two Pointers 👍 5239 👎 132


package leetcode.editor.en;

import leetcode.dp.editor.en.ListNode;

/**
 * Middle of the Linked List
 * 
 * @author: eumes
 * @date: 2022-05-04 15:01:43
 */
 public class P876MiddleOfTheLinkedList {
    public static void main(String[] args) {
//        Solution_P876 solution = new Solution_P876();
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
class Solution_P876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
