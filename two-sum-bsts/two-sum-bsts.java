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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> tree1 = new ArrayList<Integer>();
        List<Integer> tree2 = new ArrayList<Integer>();
        traverse(root1, tree1);
        traverse(root2, tree2);
        
        Map<Integer, Integer> twoSum = new HashMap<Integer, Integer>();
        for (int i = 0; i < tree1.size(); i++) {
            twoSum.put(target - tree1.get(i), i);
        }
        
        for (int i = 0; i < tree2.size(); i++) {
            if (twoSum.get(tree2.get(i)) != null)
                return true;
        }
        return false;
    }
    
    public void traverse(TreeNode root, List<Integer> tree) {
        if (root == null)
            return;
        
        traverse(root.left, tree);
        tree.add(root.val);
        traverse(root.right, tree);
    }
}