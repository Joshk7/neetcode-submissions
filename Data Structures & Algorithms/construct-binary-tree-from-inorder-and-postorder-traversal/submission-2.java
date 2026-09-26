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
    private HashMap<Integer, Integer> inorderIdx;
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;

        return dfs(0, inorder.length - 1, postorder);
    }

    private TreeNode dfs(int l, int r, int[] postorder) {
        if (l > r) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIdx--]);
        int idx = inorderIdx.get(root.val);
        root.right = dfs(idx + 1, r, postorder);
        root.left = dfs(l, idx - 1, postorder);
        return root;
    }
}