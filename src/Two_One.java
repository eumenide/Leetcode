/**
 * @author eumes
 * @date 2018/10/9
 * Description:
 *      Merge two sorted linked lists and return it as a new list. The new list
 *      should be made by splicing together the nodes of the first two lists.
 * Example:
 *      Input: 1->2->4, 1->3->4
 *      Output: 1->1->2->3->4->4
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Two_One {

    public static void main(String[] args){
        Two_One two_one = new Two_One();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = two_one.mergeTwoLists(l1, l4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
