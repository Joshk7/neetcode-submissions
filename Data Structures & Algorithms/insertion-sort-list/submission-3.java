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
        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            for (ListNode tmp = head; tmp != cur; tmp = tmp.next) {
                if (tmp.val > cur.val) {
                    int swap = tmp.val;
                    tmp.val = cur.val;
                    cur.val = swap;
                }
            }
        }
        return head;
    }
}