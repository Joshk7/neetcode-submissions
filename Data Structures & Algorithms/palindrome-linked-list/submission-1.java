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
    ListNode cur;

    public boolean isPalindrome(ListNode head) {
        cur = head;
        return recurse(head);
    }

    private boolean recurse(ListNode node) {
        if (node == null) {
            return true;
        }

        if (!recurse(node.next)) {
            return false;
        }

        if (node.val != cur.val) {
            return false;
        }

        cur = cur.next;
        return true;
    }
}