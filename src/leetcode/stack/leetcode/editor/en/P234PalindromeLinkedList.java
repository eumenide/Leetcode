//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 👍 6975 👎 486


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: eumes
 * @date: 2021-11-19 23:18:57
 * @title: Palindrome Linked List
 */
public class P234PalindromeLinkedList {
    
    public static void main(String[] args) {
        Solution_234 solution = new Solution_234();
        // TO TEST 1
        ListNode_234 node1 = new ListNode_234(1);
        ListNode_234 node2 = new ListNode_234(2, node1);
        ListNode_234 node3 = new ListNode_234(2, node2);
        ListNode_234 head = new ListNode_234(1, node3);
        System.out.println(solution.isPalindrome(head));

        // Test 2
        node1 = new ListNode_234(2);
        head = new ListNode_234(1, node1);
        System.out.println(solution.isPalindrome(head));
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

class ListNode_234 {
    int val;
    ListNode_234 next;
    ListNode_234() {}

    ListNode_234(int val) {
        this.val = val;
    }

    ListNode_234(int val, ListNode_234 next) {
        this.val = val;
        this.next = next;
    }
}

class Solution_234 {

    public boolean isPalindrome(ListNode_234 head) {
        ListNode_234 fast = head;
        ListNode_234 slow = head;
        ListNode_234 pre = null;
        ListNode_234 temp;

        // 快慢指针，找到中间位置，同时将前一半反转
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        // 处理奇数情况
        if (fast != null) {
            slow = slow.next;
        }

        // pre起始前一半反转，slow起始后一半
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    public boolean isPalindrome1(ListNode_234 head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
