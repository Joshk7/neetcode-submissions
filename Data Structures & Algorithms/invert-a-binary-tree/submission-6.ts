/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {TreeNode}
     */
    invertTree(root: TreeNode | null): TreeNode {
        if (!root) return null;
        const queue = new Queue([root]);
        while (!queue.isEmpty()) {
            let node: TreeNode = queue.pop();
            [node.left, node.right] = [node.right, node.left]
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        return root;
    }
}
