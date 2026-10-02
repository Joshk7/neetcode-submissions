/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();

            if (n.left != null) {
                queue.offer(n.left);
                parent.put(n.left, n);
            }

            if (n.right != null) {
                queue.offer(n.right);
                parent.put(n.right, n);
            }

            if (parent.containsKey(p) && parent.containsKey(q)) {
                break;
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode n = p;
        while (parent.containsKey(n)) {
            ancestors.add(n);
            n = parent.get(n);
        }

        n = q;
        while (parent.containsKey(n)) {
            if (ancestors.contains(n)) {
                return n;
            }
            n = parent.get(n);
        }

        return q;
    }
}