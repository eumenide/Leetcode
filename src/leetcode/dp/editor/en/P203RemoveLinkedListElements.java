//Given the head of a linked list and an integer val, remove all the nodes of 
//the linked list that has Node.val == val, and return the new head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,6,3,4,5,6], val = 6
//Output: [1,2,3,4,5]
// 
//
// Example 2: 
//
// 
//Input: head = [], val = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [7,7,7,7], val = 7
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 10⁴]. 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics Linked List Recursion 👍 4772 👎 162


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-12 00:55:59
 * @title: Remove Linked List Elements
 */
public class P203RemoveLinkedListElements {
    
    public static void main(String[] args) {
        Solution_203 solution = new Solution_203();
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
class Solution_203 {

    public ListNode removeElements_1(ListNode head, int val) {
        // 遍历节点
        ListNode node = head;
        ListNode pre = new ListNode();
        ListNode res = pre;
        pre.next = head;
        while (node != null) {
            // 如果相等，删除，即调整前指针的指向
            if (node.val == val) {
                pre.next = node.next;
            } else {
                pre = pre.next;
            }
            node = node.next;
        }

        return res.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        // 删除Head，直到head.val != val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        // 遍历 并删除
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return head;
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
