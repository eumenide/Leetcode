//You are given the head of a linked list, and an integer k. 
//
// Return the head of the linked list after swapping the values of the kᵗʰ node 
//from the beginning and the kᵗʰ node from the end (the list is 1-indexed). 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
//Output: [7,9,6,6,8,7,3,0,9,5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= k <= n <= 10⁵ 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Two Pointers 👍 2276 👎 88


package leetcode.dp.editor.en;

/**
 * @author: eumes
 * @date: 2022-04-04 21:30:06
 * @title: Swapping Nodes in a Linked List
 */
public class P1721SwappingNodesInALinkedList {
    
    public static void main(String[] args) {
        Solution_1721 solution = new Solution_1721();
        // TO TEST
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(solution.swapNodes(n1, 2));

        n1 = new ListNode(5);
        n2 = new ListNode(9, n1);
        n3 = new ListNode(0, n2);
        n4 = new ListNode(3, n3);
        n5 = new ListNode(8, n4);
        ListNode n6 = new ListNode(7, n5);
        ListNode n7 = new ListNode(6, n6);
        ListNode n8 = new ListNode(6, n7);
        ListNode n9 = new ListNode(9, n8);
        ListNode n10 = new ListNode(7, n9);
        System.out.println(solution.swapNodes(n10, 5));
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
class Solution_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // 0节点
        ListNode zero = new ListNode(-1, head);
        ListNode leftPre = zero, left;
        // 找到要交换的左边
        for (int i = 1; i < k; i++) {
            leftPre = leftPre.next;
        }
        left = leftPre.next;

        // 找到要交换的右边
        ListNode rightPre = zero, right;
        ListNode tail = left.next;
        while (tail != null) {
            rightPre = rightPre.next;
            tail = tail.next;
        }
        right = rightPre.next;


        System.out.println(left.val);
        System.out.println(right.val);
        // 交换
        if (left.next == right) {
            // left -> right
            left.next = right.next;
            right.next = left;
            leftPre.next = right;
        } else if (left == right.next) {
            // right -> left
            right.next = left.next;
            left.next = right;
            rightPre.next = left;
        } else {
            // lPre -> left -> x -> rPre -> right
            ListNode tmp = right.next;
            leftPre.next = right;
            right.next = left.next;
            rightPre.next = left;
            left.next = tmp;
        }

        return zero.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
