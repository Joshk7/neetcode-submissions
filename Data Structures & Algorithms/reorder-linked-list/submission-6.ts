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
        const arr = [];
        let node = head;
        while (node !== null) {
            arr.push(node);
            node = node.next;
        }
        
        console.log(arr);

        let l = 0,
            r = arr.length - 1;
        
        while (l < r) {
            arr[l].next = arr[r];
            l++;
            if (l < r) {
                arr[r].next = arr[l];
            }
            r--;
        }

        arr[l].next = null;
    }
}
