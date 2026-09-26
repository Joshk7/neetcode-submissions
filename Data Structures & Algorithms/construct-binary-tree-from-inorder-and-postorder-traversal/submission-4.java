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
    private int postIdx;
    private int inIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        inIdx = inorder.length - 1;

        return dfs(postorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] postorder, int[] inorder, int limit) {
        if (postIdx < 0) {
            return null;
        }

        if (inorder[inIdx] == limit) {
            inIdx--;
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIdx--]);
        root.right = dfs(postorder, inorder, root.val);
        root.left = dfs(postorder, inorder, limit);
        return root;
    }

}