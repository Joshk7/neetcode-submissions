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
     * @param {ListNode} list1
     * @param {ListNode} list2
     * @return {ListNode}
     */
    mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode {
        const dummy = new ListNode();
        let node = dummy;
        while (list1 || list2) {
            if (!list1) {
                node.next = list2;
                list2 = null;
            } else if (!list2) {
                node.next = list1;
                list1 = null;
            } else {
                const v1 = list1.val;
                const v2 = list2.val;
                if (v1 < v2) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
            }
            node = node.next;
        }
        return dummy.next;
    }
}
