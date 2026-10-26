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

public class Codec {
    private List<String> preorder;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder = new ArrayList<>();
        dfsS(root);
        return String.join(",", preorder);
    }

    private void dfsS(TreeNode node) {
        if (node == null) {
            preorder.add("N");
            return;
        }

        preorder.add(String.valueOf(node.val));
        dfsS(node.left);
        dfsS(node.right);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsD(vals, i);
    }

    private TreeNode dfsD(String[] vals, int[] i) {
        if (vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsD(vals, i);
        node.right = dfsD(vals, i);
        return node;
    }
}
