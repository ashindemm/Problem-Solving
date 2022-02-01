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
    int rootToLeaf = 0;
    
    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        return rootToLeaf;
    }
    
    public void sum(TreeNode root, int currNum) {
        if (root != null) {
            currNum = (currNum << 1) | root.val;
            
            if (root.left == null && root.right == null)
                rootToLeaf += currNum;
            
            sum(root.left, currNum);
            sum(root.right, currNum);
        }
    }
}