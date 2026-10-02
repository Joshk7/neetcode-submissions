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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder);
    }

    private TreeNode construct(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int val = preorder[0];
        TreeNode node = new TreeNode(val);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        node.right = construct(preorderRight, inorderRight);
        node.left = construct(preorderLeft, inorderLeft);
        return node;
    }
}
