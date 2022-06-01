//Serialization is the process of converting a data structure or object into a 
//sequence of bits so that it can be stored in a file or memory buffer, or 
//transmitted across a network connection link to be reconstructed later in the same or 
//another computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no 
//restriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this 
//string can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode 
//serializes a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics String Tree Depth-First Search Breadth-First Search Design 
//Binary Tree 👍 6699 👎 258


package leetcode.editor.en;

import java.util.LinkedList;

/**
 * Serialize and Deserialize Binary Tree
 * 
 * @author: eumes
 * @date: 2022-05-30 00:51:52
 */
 public class P297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
//        Solution_P297 solution = new Solution_P297();
        // TO TEST

    }
    
 }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec_Solution_P297 {

    private static final String SEP = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(NULL).append(SEP);
            return;
        }

        builder.append(root.val).append(SEP);
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SEP)) {
            nodes.add(node);
        }

        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String node = nodes.removeFirst();
        if (node.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
