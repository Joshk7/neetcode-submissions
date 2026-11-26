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
     * @return {void}
     */
    reorderList(head: ListNode | null): void {
        const dummy = new ListNode(-1, head);
        let fast = dummy;
        let slow = dummy;
        while (fast && fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        let l1 = head;
        let prev = null;
        let node = slow;
        while (node) {
            let tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }

        let l2 = prev;
        while (l1 && l2) {
            let t1 = l1.next;
            let t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
    }
}
