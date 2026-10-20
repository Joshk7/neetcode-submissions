/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(-1, head);
        ListNode dummy = new ListNode(-1, head);
        ListNode insertion = newHead;
        while (dummy.next != null) {
            ListNode prev = dummy;
            ListNode node = dummy.next;
            ListNode prevMin = prev;
            ListNode min = node;
            while (node != null) {
                if (node.val < min.val) {
                    prevMin = prev;
                    min = node;
                }
                prev = prev.next;
                node = node.next;
            }

            prevMin.next = min.next;

            insertion.next = min;
            insertion = insertion.next;
        }

        return newHead.next;
    }
}