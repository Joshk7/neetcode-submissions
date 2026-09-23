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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }

        int result = 0;
        if (low <= node.val && node.val <= high) {
            result += node.val;
        }

        int left = dfs(node.left, low, high);
        int right = dfs(node.right, low, high);
        return result + left + right;
    }
}