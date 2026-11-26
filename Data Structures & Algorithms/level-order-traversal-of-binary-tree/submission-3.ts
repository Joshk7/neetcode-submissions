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
     * @return {number[][]}
     */
    levelOrder(root: TreeNode | null): number[][] {
        const answer: number[][] = [];
        if (!root) return answer;
        const queue = new Queue();
        queue.push(root);
        while (!queue.isEmpty()) {
            const size = queue.size();
            const level = [];
            for (let i = 0; i < size; i++) {
                const node = queue.pop();
                if (node !== null) {
                    level.push(node.val);
                }

                if (node.left) {
                    queue.push(node.left);
                }

                if (node.right) {
                    queue.push(node.right);
                }
            }
            answer.push(level);
        }
        return answer;
    }
}
