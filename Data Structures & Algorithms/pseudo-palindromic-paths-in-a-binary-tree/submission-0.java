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
    public int pseudoPalindromicPaths(TreeNode root) {
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        ArrayDeque<int[]> freqs = new ArrayDeque<>();
        nodes.offer(root);
        freqs.offer(new int[10]);
        int ans = 0;

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int[] freq = freqs.poll();
            int[] copy = freq.clone();
            copy[node.val]++;

            if (node.left == null && node.right == null) {
                int odd = 0;
                for (int c : copy) {
                    if (c % 2 == 1) odd++;
                    if (odd > 1) break;
                }
                ans += odd > 1 ? 0 : 1; 
            }

            if (node.left != null) {
                nodes.offer(node.left);
                freqs.offer(copy);
            }

            if (node.right != null) {
                nodes.offer(node.right);
                freqs.offer(copy);
            }
        }

        return ans;
    }
}
