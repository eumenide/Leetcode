//You are given the head of a singly linked-list. The list can be represented 
//as: 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// Reorder the list to be on the following form: 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 
//
// You may not modify the values in the list's nodes. Only nodes themselves may 
//be changed. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5 * 10⁴]. 
// 1 <= Node.val <= 1000 
// 
// Related Topics Linked List Two Pointers Stack Recursion 👍 4293 👎 177


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: eumes
 * @date: 2021-11-25 23:15:33
 * @title: Reorder List
 */
public class P143ReorderList {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
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

class ListNode_143 {
    int val;
    ListNode_143 next;
    ListNode_143() {}
    ListNode_143(int val) { this.val = val; }
    ListNode_143(int val, ListNode_143 next) { this.val = val; this.next = next; }
}
class Solution {
    public void reorderList2(ListNode_143 head) {
        ListNode_143 fast = head;
        ListNode_143 slow = head;
        ListNode_143 pre = null;
        ListNode_143 next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }

        // 反转后半段
        while (slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        // 前半段head开始，后半段pre开始倒
        ListNode_143 cur = head;
        ListNode_143 left;
        ListNode_143 right;
        while (pre != null) {
            if (pre.next == null) break;
            left = cur.next;
            right = pre.next;
            cur.next = pre;
            pre.next = left;

            cur = left;
            pre = right;
        }

    }

    public void reorderList1(ListNode_143 head) {
        Deque<ListNode_143> queue = new ArrayDeque<>();

        ListNode_143 tmp = head;

        while(tmp != null) {
            queue.offerLast(tmp);
            tmp = tmp.next;
        }

        tmp = queue.pollFirst();
        while(queue.size() > 1) {
            tmp.next = queue.pollLast();
            tmp = tmp.next;
            tmp.next = queue.pollFirst();
            tmp = tmp.next;
        }

        if (!queue.isEmpty()) {
            tmp.next = queue.pollFirst();
            tmp = tmp.next;
        }
        tmp.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
