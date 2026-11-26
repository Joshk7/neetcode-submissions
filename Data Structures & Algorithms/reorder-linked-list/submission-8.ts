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
        let slow = head!;
        let fast = head!.next;
        while (fast && fast.next) {
            fast = fast.next.next;
            slow = slow.next!;
        }

        let second = slow.next;
        let prev: ListNode | null = (slow.next = null);
        while (second !== null) {
            let tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        let first = head!;
        second = prev;
        while (second) {
            let t1 = first.next;
            let t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
}
