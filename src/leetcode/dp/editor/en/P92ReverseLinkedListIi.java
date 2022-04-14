//Given the head of a singly linked list and two integers left and right where 
//left <= right, reverse the nodes of the list from position left to position 
//right, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 👍 5925 👎 
//278


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-13 00:13:45
 * @title: Reverse Linked List II
 */
public class P92ReverseLinkedListIi {
    
    public static void main(String[] args) {
        Solution_92 solution = new Solution_92();
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
class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = null, cur = dummy;

        // 找到开始反转的left
        for (int i = 0; i < left; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode lPre = pre, lHead = cur;

        // 反转指定区间
        for (int i = left; i <= right; i++) {
            ListNode tmp = cur.next;
            // 反转cur指向
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }

        lPre.next = pre;
        lHead.next = cur;
        return dummy.next;
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
