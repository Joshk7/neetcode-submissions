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
    private int preIdx = 0;
    private int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) {
            return null;
        }

        if (inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, limit);
        return root;
    }
}
