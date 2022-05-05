//Given the head of a linked list, reverse the nodes of the list k at a time, 
//and return the modified list. 
//
// k is a positive integer and is less than or equal to the length of the 
//linked list. If the number of nodes is not a multiple of k then left-out nodes, in 
//the end, should remain as it is. 
//
// You may not alter the values in the list's nodes, only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
// Follow-up: Can you solve the problem in O(1) extra memory space? 
// Related Topics Linked List Recursion 👍 6996 👎 487


package leetcode.editor.en;

import leetcode.dp.editor.en.ListNode;

/**
 * Reverse Nodes in k-Group
 * 
 * @author: eumes
 * @date: 2022-05-04 19:38:56
 */
 public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
//        Solution_P25 solution = new Solution_P25();
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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 终止条件
        if (head == null) {
            return null;
        }

        // 先找到前k个节点
        ListNode e = head;
        for (int i = 0; i < k; i++) {
            if (e == null) {
                // 少于k个，不需要反转
                return head;
            }

            e = e.next;
        }

        // 先反转前k个节点[s, e)，得到新的头节点
        ListNode newHead = reverse(head, e);
        // 再递归反转e开始的链表
        head.next = reverseKGroup(e, k);
        return newHead;
    }

    // 反转[s, e)之间的节点，返回新的头节点
    private ListNode reverse(ListNode s, ListNode e) {
        ListNode cur = s, pre = null, nxt = s;
        while (cur != e) {
            nxt = cur.next;
            // 反转当前节点指向
            cur.next = pre;

            // 继续往右推进
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
