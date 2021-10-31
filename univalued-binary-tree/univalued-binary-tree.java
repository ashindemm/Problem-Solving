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
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return traverse(root, root.val);
    }
    
    public boolean traverse(TreeNode root, int val) {
        if (root == null)
            return true;
        // while (root != null) {
            if (root.val != val)
                return false;
            return traverse(root.left, val) && traverse(root.right, val);
        // }
        // return true;
    }
}