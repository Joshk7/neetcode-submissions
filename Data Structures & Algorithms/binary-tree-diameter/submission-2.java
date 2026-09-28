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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        int diameter = leftLength + rightLength;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int sub = Math.max(left, right);
        
        return Math.max(diameter, sub);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        return 1 + Math.max(left, right);
    }
}
