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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int size = postorder.length;
        int value = postorder[size - 1];
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (inorder[i] == value) {
                index = i;
            }
        }

        TreeNode node = new TreeNode(value);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        node.left = buildTree(leftInorder, leftPostorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, size);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, size - 1);
        node.right = buildTree(rightInorder, rightPostorder);
        return node;
    }
}