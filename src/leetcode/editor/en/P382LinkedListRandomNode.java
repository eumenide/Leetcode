//Given a singly linked list, return a random node's value from the linked list.
// Each node must have the same probability of being chosen. 
//
// Implement the Solution class: 
//
// 
// Solution(ListNode head) Initializes the object with the head of the singly-
//linked list head. 
// int getRandom() Chooses a node randomly from the list and returns its value. 
//All the nodes of the list should be equally likely to be chosen. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
//[[[1, 2, 3]], [], [], [], [], []]
//Output
//[null, 1, 3, 2, 2, 3]
//
//Explanation
//Solution solution = new Solution([1, 2, 3]);
//solution.getRandom(); // return 1
//solution.getRandom(); // return 3
//solution.getRandom(); // return 2
//solution.getRandom(); // return 2
//solution.getRandom(); // return 3
//// getRandom() should return either 1, 2, or 3 randomly. Each element should 
//have equal probability of returning.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the linked list will be in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// At most 10⁴ calls will be made to getRandom. 
// 
//
// 
// Follow up: 
//
// 
// What if the linked list is extremely large and its length is unknown to you? 
//
// Could you solve this efficiently without using extra space? 
// 
// Related Topics Linked List Math Reservoir Sampling Randomized 👍 1728 👎 436


package leetcode.editor.en;

import leetcode.dp.editor.en.ListNode;

import java.util.Random;

/**
 * Linked List Random Node
 * 
 * @author: eumes
 * @date: 2022-05-12 01:13:37
 */
 public class P382LinkedListRandomNode {
    public static void main(String[] args) {
//        Solution_P382 solution = new Solution_P382();
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
class Solution_P382 {

    ListNode head;
    public Solution_P382(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        Random rd = new Random();
        // 有1/i概率选择当前节点，其他概率选择下一个
        int i = 1, res = head.val;
        ListNode p = head;
        while (p != null) {
            if (0 == rd.nextInt(i++)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
