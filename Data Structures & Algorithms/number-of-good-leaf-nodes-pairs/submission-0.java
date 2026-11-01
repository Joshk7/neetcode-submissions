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
    public int countPairs(TreeNode root, int distance) {
        List<TreeNode> nodes = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();

        nodes.add(root);
        for (int u = 0; u < nodes.size(); u++) {
            TreeNode node = nodes.get(u);
            List<Integer> ids = new ArrayList<>();
            for (TreeNode child : new TreeNode[]{node.left, node.right}) {
                if (child != null) {
                    ids.add(nodes.size());
                    nodes.add(child);
                }
            }
            children.add(ids);
        }

        int[][] counts = new int[nodes.size()][distance + 1];
        int answer = 0;

        for (int u = nodes.size() - 1; u >= 0; u--) {
            if (children.get(u).isEmpty()) {
                counts[u][0] = 1;
            }

            for (int child : children.get(u)) {
                for (int i = 0; i <= distance; i++) {
                    for (int j = 0; j < distance - i; j++) {
                        answer += counts[u][i] * counts[child][j];
                    }
                }

                for (int j = 0; j < distance; j++) {
                    counts[u][j + 1] += counts[child][j];
                }
            }
        }

        return answer;
    }
}
