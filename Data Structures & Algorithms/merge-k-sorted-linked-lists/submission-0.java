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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode dummy = ans;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode head : lists) {
            minHeap.offer(head);
        }

        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.poll();
            if (top.next != null) {
                minHeap.offer(top.next);
            }
            dummy.next = top;
            dummy = dummy.next;
        }

        return ans.next;
    }
}
