//You are given the root of a binary tree. We install cameras on the tree nodes 
//where each camera at a node can monitor its parent, itself, and its immediate 
//children. 
//
// Return the minimum number of cameras needed to monitor all nodes of the tree.
// 
//
// 
// Example 1: 
//
// 
//Input: root = [0,0,null,0,0]
//Output: 1
//Explanation: One camera is enough to monitor all nodes if placed as shown.
// 
//
// Example 2: 
//
// 
//Input: root = [0,0,null,0,null,0,null,null,0]
//Output: 2
//Explanation: At least two cameras are needed to monitor all nodes of the tree.
// The above image shows one of the valid configurations of camera placement.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// Node.val == 0 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 375
//2 👎 44


package leetcode.editor.en;

/**
 * Binary Tree Cameras
 * 
 * @author: eumes
 * @date: 2022-06-18 00:47:34
 */
 public class P968BinaryTreeCameras {
    public static void main(String[] args) {
//        Solution_P968 solution = new Solution_P968();
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
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_P968 {
    // 节点的三种形态：0 未被monitor的，1 被monitor的，2 设置camera的
    private static final Integer UNMONITORED = 0;
    private static final Integer MONITORED = 1;
    private static final Integer CAMERA = 2;

    private int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        setCamera(root, true);
        return cameras;
    }

    // 采用自底向上遍历，返回值为root节点状态
    private int setCamera(TreeNode root, boolean isRoot) {
        if (root == null) {
            // 空节点默认被monitor
            return 1;
        }

        int left = setCamera(root.left, false);
        int right = setCamera(root.right, false);

        // 如果左右节点 有未被monitor的，则root节点需要设置camera
        if (left == UNMONITORED || right == UNMONITORED) {
            cameras++;
            return CAMERA;
        }

        // 如果左右节点 有设置了camera的，则root节点被monitor了
        if (left == CAMERA || right == CAMERA) {
            return MONITORED;
        }

        // 剩下的情况：左右节点被monitor了，需要根据root是否有父节点 -> 来决定是自己设置camera还是交由父节点monitor
        if (isRoot) {
            cameras++;
            return CAMERA;
        }
        return UNMONITORED;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
