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
        return dfs(inorder, postorder);
    }

    private TreeNode dfs(
        int[] inorder, 
        int[] postorder
    ) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        int n = postorder.length;
        int value = postorder[n - 1];
        TreeNode node = new TreeNode(value);
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }

        node.left = dfs(
            Arrays.copyOfRange(inorder, 0, index), 
            Arrays.copyOfRange(postorder, 0, index)
        );

        node.right = dfs(
            Arrays.copyOfRange(inorder, index + 1, n),
            Arrays.copyOfRange(postorder, index, n - 1)
        );
        return node;
    }
}