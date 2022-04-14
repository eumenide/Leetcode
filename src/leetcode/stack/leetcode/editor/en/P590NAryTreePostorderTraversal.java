//Given the root of an n-ary tree, return the postorder traversal of its nodes' 
//values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
//null,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// The height of the n-ary tree is less than or equal to 1000. 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics Stack Tree Depth-First Search 👍 1330 👎 76


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-21 22:20:08
 * @title: N-ary Tree Postorder Traversal
 */
public class P590NAryTreePostorderTraversal {
    
    public static void main(String[] args) {
        Solution_590 solution = new Solution_590();
        // TO TEST 1
        Node_590 n5 = new Node_590(5);
        Node_590 n6 = new Node_590(6);
        List<Node_590> c3 = new ArrayList<>();
        c3.add(n5);
        c3.add(n6);
        Node_590 n3 = new Node_590(3, c3);
        Node_590 n2 = new Node_590(2);
        Node_590 n4 = new Node_590(4);
        List<Node_590> c1 = new ArrayList<>();
        c1.add(n3);
        c1.add(n2);
        c1.add(n4);
        Node_590 root = new Node_590(1, c1);

        System.out.println(solution.postorder(root));

        // Test 2
        n2 = new Node_590(2);
        n6 = new Node_590(6);
        Node_590 n14 = new Node_590(14);
        Node_590 n12 = new Node_590(12);
        Node_590 n13 = new Node_590(13);
        Node_590 n10 = new Node_590(10);

        List<Node_590> c11 = new ArrayList<>();
        c11.add(n14);
        Node_590 n11 = new Node_590(11, c11);
        List<Node_590> c7 = new ArrayList<>();
        c7.add(n11);
        Node_590 n7 = new Node_590(7, c7);
        c3.clear();
        c3.add(n6);
        c3.add(n7);
        n3 = new Node_590(3, c3);

        List<Node_590> c8 = new ArrayList<>();
        c8.add(n12);
        Node_590 n8 = new Node_590(8, c8);
        List<Node_590> c4 = new ArrayList<>();
        c4.add(n8);
        n4 = new Node_590(4, c8);

        List<Node_590> c9 = new ArrayList<>();
        c9.add(n13);
        Node_590 n9 = new Node_590(9, c9);
        List<Node_590> c5 = new ArrayList<>();
        c5.add(n9);
        c5.add(n10);
        n5 = new Node_590(5, c5);

        c1.clear();
        c1.add(n2);
        c1.add(n3);
        c1.add(n4);
        c1.add(n5);
        root = new Node_590(1, c1);

        System.out.println(solution.postorder(root));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

 */
class Node_590 {
    public int val;
    public List<Node_590> children;

    public Node_590() {}

    public Node_590(int _val) {
        val = _val;
    }

    public Node_590(int _val, List<Node_590> _children) {
        val = _val;
        children = _children;
    }
};

class Solution_590 {

    public List<Integer> postorder(Node_590 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node_590> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node_590 node = stack.pop();
            list.add(0, node.val);
            if (node.children != null && node.children.size() > 0) {
                node.children.forEach(stack::push);
            }
        }

        return list;
    }

    public List<Integer> postorder1(Node_590 root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            postOrder(list, root.children);
            list.add(root.val);
        }

        return list;
    }

    public void postOrder(List<Integer> list, List<Node_590> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }

        nodes.forEach(node -> {
            postOrder(list, node.children);
            list.add(node.val);
        });

    }
}
//leetcode submit region end(Prohibit modification and deletion)
