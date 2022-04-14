//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 12252 👎 2849


package leetcode.stack.leetcode.editor.en;


/**
 * @author: eumes
 * @date: 2021-06-17 20:26:07
 * @title: Add Two Numbers
 */
public class P2AddTwoNumbers {
    
    public static void main(String[] args) {
        Solution_2 solution2 = new Solution_2();
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
class ListNode_2 {
    int val;
    ListNode_2 next;
    ListNode_2() {}
    ListNode_2(int val) { this.val = val; }
    ListNode_2(int val, ListNode_2 next) { this.val = val; this.next = next; }
}

class Solution_2 {
    public ListNode_2 addTwoNumbers(ListNode_2 l1, ListNode_2 l2) {
        ListNode_2 result = new ListNode_2();
        ListNode_2 current = result;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int left = l1 != null ? l1.val : 0;
            int right = l2 != null ? l2.val : 0;
            sum = left + right + carry;
            ListNode_2 sumNode = new ListNode_2(sum % 10);
            current.next = sumNode;
            current = sumNode;

            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
