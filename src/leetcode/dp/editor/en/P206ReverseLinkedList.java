//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
// Related Topics Linked List Recursion 👍 11390 👎 196


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-13 00:11:01
 * @title: Reverse Linked List
 */
public class P206ReverseLinkedList {
    
    public static void main(String[] args) {
        Solution_206 solution = new Solution_206();
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
class Solution_206 {
    public ListNode reverseList(ListNode head) {
        // 当前节点与前置节点
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            // 当前节点指向反转
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
