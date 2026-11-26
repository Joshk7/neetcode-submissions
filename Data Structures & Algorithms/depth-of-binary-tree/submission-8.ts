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
     * @return {number}
     */
    maxDepth(root: TreeNode | null): number {
        if (root === null) return 0;
        const queue = new Queue([root]);
        let depth = 0;
        while (!queue.isEmpty()) {
            let length = queue.size();
            depth++;
            for (let i = 0; i < length; i++) {
                let node = queue.pop();
                if (node.left != null) {
                    queue.push(node.left);
                }

                if (node.right != null) {
                    queue.push(node.right);
                }
            }
        }

        return depth;
    }
}
