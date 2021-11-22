//Given the root of an n-ary tree, return the preorder traversal of its nodes' 
//values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
//null,12,null,13,null,null,14]
//Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
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
// Related Topics Stack Tree Depth-First Search 👍 1402 👎 72


package leetcode.stack.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: eumes
 * @date: 2021-11-21 21:36:45
 * @title: N-ary Tree Preorder Traversal
 */
public class P589NAryTreePreorderTraversal {
    
    public static void main(String[] args) {
        Solution_589 solution = new Solution_589();
        // TO TEST 1
        Node_589 n5 = new Node_589(5);
        Node_589 n6 = new Node_589(6);
        List<Node_589> c3 = new ArrayList<>();
        c3.add(n5);
        c3.add(n6);
        Node_589 n3 = new Node_589(3, c3);
        Node_589 n2 = new Node_589(2);
        Node_589 n4 = new Node_589(4);
        List<Node_589> c1 = new ArrayList<>();
        c1.add(n3);
        c1.add(n2);
        c1.add(n4);
        Node_589 root = new Node_589(1, c1);

        System.out.println(solution.preorder(root));

        // Test 2
        n2 = new Node_589(2);
        n6 = new Node_589(6);
        Node_589 n14 = new Node_589(14);
        Node_589 n12 = new Node_589(12);
        Node_589 n13 = new Node_589(13);
        Node_589 n10 = new Node_589(10);

        List<Node_589> c11 = new ArrayList<>();
        c11.add(n14);
        Node_589 n11 = new Node_589(11, c11);
        List<Node_589> c7 = new ArrayList<>();
        c7.add(n11);
        Node_589 n7 = new Node_589(7, c7);
        c3.clear();
        c3.add(n6);
        c3.add(n7);
        n3 = new Node_589(3, c3);

        List<Node_589> c8 = new ArrayList<>();
        c8.add(n12);
        Node_589 n8 = new Node_589(8, c8);
        List<Node_589> c4 = new ArrayList<>();
        c4.add(n8);
        n4 = new Node_589(4, c8);

        List<Node_589> c9 = new ArrayList<>();
        c9.add(n13);
        Node_589 n9 = new Node_589(9, c9);
        List<Node_589> c5 = new ArrayList<>();
        c5.add(n9);
        c5.add(n10);
        n5 = new Node_589(5, c5);

        c1.clear();
        c1.add(n2);
        c1.add(n3);
        c1.add(n4);
        c1.add(n5);
        root = new Node_589(1, c1);

        System.out.println(solution.preorder(root));

    }
    
}

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
 */
class Node_589 {
    public int val;
    public List<Node_589> children;

    public Node_589() {}

    public Node_589(int _val) {
        val = _val;
    }

    public Node_589(int _val, List<Node_589> _children) {
        val = _val;
        children = _children;
    }
};


class Solution_589 {

    public List<Integer> preorder(Node_589 root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<Node_589> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node_589 node = stack.pop();
            list.add(node.val);

            if (node.children != null && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }

        return list;
    }

    public List<Integer> preorder1(Node_589 root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            preOrder(list, root);
        }

        return list;
    }

    public void preOrder(List<Integer> list, Node_589 node) {
        if (node == null) {
            return;
        }
        list.add(node.val);

        if (node.children != null && node.children.size() > 0) {
            node.children.forEach(n -> preOrder(list, n));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
