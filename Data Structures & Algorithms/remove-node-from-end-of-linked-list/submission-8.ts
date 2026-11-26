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
     * @param {number} n
     * @return {ListNode}
     */
    removeNthFromEnd(head: ListNode | null, n: number): ListNode {
        const dummy = new ListNode(-1, head);
        let r = dummy;
        for (let i = 0; i <= n; i++) {
            r = r.next;
        }

        let l = dummy;
        while (r) {
            l = l.next;
            r = r.next;
        }
        
        l.next = l.next.next;
        return dummy.next;
    }
}
