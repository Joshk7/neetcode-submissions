/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {boolean}
     */
    hasCycle(head: ListNode | null): boolean {
        const seen = new Set<ListNode>();
        const dummy = new ListNode(-1, head);
        let node = dummy;
        while (node) {
            if (seen.has(node)) {
                return true;
            }
            seen.add(node);
            node = node.next;
        }
        return false;
    }
}
